import model.NhanVien;

import java.util.ArrayList;

public class QuanLyNhanVienThuong extends NhanVien {
    public static ArrayList<NhanVien> listNVThuong=new ArrayList<>();
    public void xuatNhanVienThuong(){
        System.out.println("<======>DANH SÁCH NHÂN VIÊN HIỆN TẠI<======>");
        System.out.print("STT    Mã NV   Tên nhân viên      SĐT         Số ngày làm     Lương Ngày       Lương");
        for (int i=0;i<listNVThuong.size();i++) {
            NhanVien nhanVien = listNVThuong.get(i);
            //mã số, họ tên, số điện thoại, số ngày làm việc, lương 1 ngày và cách tính lương
            System.out.print("\n ["+(i+1)+"]      "+nhanVien.getMaNV()+"    "+nhanVien.getTenNV()+"         " +
                    ""+nhanVien.getSDT()+"         "+nhanVien.getSoNgayLam()+"          "+nhanVien.getLuongNgay()+"      "+nhanVien.getLuong());
        }
        System.out.print("\n");
    }

    public boolean chamTrung(int maNV){
        for (int i=0;i<listNVThuong.size();i++) {
            NhanVien nhanVien = listNVThuong.get(i);
            if(nhanVien.getMaNV()==maNV){
                return true;
            }
        }
        return false;
    }
    public void themNhanVien(int maNV,String tenNV,String SDT,double soNgayLam,int loaiNV,double luongNgay,
                                int maTruongPhong,String tenTruongPhong,double luong){
        if(chamTrung(maNV)==false){
            listNVThuong.add(new NhanVien(maNV,tenNV,SDT, soNgayLam,loaiNV,luongNgay,maTruongPhong,tenTruongPhong,luong));
        }
    }

    public void nhanVienLuongMax(){
        double max=0;
        for (int i=0;i<listNVThuong.size();i++){
            NhanVien nhanVien = listNVThuong.get(i);
            double x = nhanVien.getLuong();
            if(x>max){
                max=x;
            }
        }
        System.out.println("<======>Nhân viên có lương cao nhất công ty<======>");
        System.out.print("STT    Mã NV   Tên nhân viên      SĐT         Số ngày làm     Lương Ngày       Lương");
        for (int i=0;i<listNVThuong.size();i++) {
            NhanVien nhanVien = listNVThuong.get(i);
            if(nhanVien.getLuong()==max) {
                int k=0;
                //mã số, họ tên, số điện thoại, số ngày làm việc, lương 1 ngày và cách tính lương
                System.out.print("\n [" + (k + 1) + "]      " + nhanVien.getMaNV() + "    " + nhanVien.getTenNV() + "         " +
                        "" + nhanVien.getSDT() + "         " + nhanVien.getSoNgayLam() + "          " + nhanVien.getLuongNgay() + "      " + nhanVien.getLuong());
            }
        }
        System.out.print("\n");
    }
}
