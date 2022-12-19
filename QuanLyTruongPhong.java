import model.NhanVien;

import java.util.ArrayList;

public class QuanLyTruongPhong extends NhanVien {
    public static ArrayList<NhanVien> listTP= new ArrayList<>();

    public void xuatTruongPhong(){
        System.out.println("<======>DANH SÁCH TRƯỞNG PHÒNG HIỆN TẠI<======>");
        System.out.print("STT    MÃ TP      TÊN TRƯỞNG PHÒNG   ");
        for (int i=0;i<listTP.size();i++) {
            NhanVien nhanVien = listTP.get(i);
            System.out.print("\n ["+(i+1)+"]      "+nhanVien.getMaNV());
            System.out.print("        "+nhanVien.getTenNV());
        }
        System.out.print("\n");
    }
    public int timMaTP(int maTP){
        for (int i=0;i<listTP.size();i++) {
            NhanVien nhanVien = listTP.get(i);
            if(nhanVien.getMaNV()==maTP){
                return 1;
            }
        }
        return 0;
    }
    public double tinhLuongTP(int maNV){
        QuanLyNhanSu quanLyNhanSu = new QuanLyNhanSu();
        int soNV= quanLyNhanSu.demSoNhanVien(maNV);
        for (int i=0;i<quanLyNhanSu.listNV.size();i++) {
            NhanVien nhanVien = quanLyNhanSu.listNV.get(i);
            if(nhanVien.getMaNV()==maNV||nhanVien.getLoaiNV()==2){
                return (nhanVien.getSoNgayLam()*200+soNV*100);
            }
        }
        return 0;
    }
    public void nhanVienDuoiQuyen(){
        int maxNV=0;
        QuanLyNhanSu quanLyNhanSu = new QuanLyNhanSu();
        for (int i=0; i< listTP.size();i++){
            NhanVien nhanVien= listTP.get(i);
            int soNV = quanLyNhanSu.demSoNhanVien(nhanVien.getMaNV());
            if(soNV>maxNV){
                maxNV=soNV;
            }
        }
        System.out.println("<======>TRƯỞNG PHÒNG CÓ SỐ NHÂN VIÊN DƯỚI QUYỀN NHIỀU NHẤT<======>");
        System.out.print("STT    MÃ TP      TÊN TRƯỞNG PHÒNG      Lương      SỐ NV DƯỚI QUYỀN  ");
        int j=0;
        for (int i=0;i<listTP.size();i++) {
            NhanVien nhanVien = listTP.get(i);
            if(quanLyNhanSu.demSoNhanVien(nhanVien.getMaNV())==maxNV){
                System.out.print("\n ["+(++j)+"]      "+nhanVien.getMaNV());
                System.out.print("        "+nhanVien.getTenNV()+"      "+nhanVien.getLuong()+"       "+maxNV);
            }
        }
        System.out.print("\n");
    }
    public boolean chamTrung(int maNV){
        for (int i=0;i<listTP.size();i++) {
            NhanVien nhanVien = listTP.get(i);
            if(nhanVien.getMaNV()==maNV){
                return true;
            }
        }
        return false;
    }
    public void themNhanVien(int maNV,String tenNV,double luong){
        if(chamTrung(maNV)==false){
            listTP.add(new NhanVien(maNV,tenNV,luong));
        }
    }
}
