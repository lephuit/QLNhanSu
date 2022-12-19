import model.CongTy;
import model.NhanVien;

import java.util.ArrayList;

public class QuanLyGiamDoc extends CongTy{
    public static ArrayList<NhanVien> listGD= new ArrayList<>();
    public void timCoPhanCao(){
        double coPhan=0;
        for (int i=0;i<listGD.size();i++){
            NhanVien giamDoc= listGD.get(i);
            if (giamDoc.getCoPhan()>coPhan){
                coPhan=giamDoc.getCoPhan();
            }
        }
        System.out.println("<======>GIÁM ĐỐC CÓ CỔ PHẦN CAO NHẤT<======>");
        System.out.print("STT    MÃ GD          TÊN GIÁM ĐỐC        Cổ Phần(%) ");
        int k=0;
        for (int i=0;i<listGD.size();i++) {
            NhanVien nhanVien = listGD.get(i);
            if(nhanVien.getCoPhan()==coPhan){
                System.out.print("\n ["+(++k)+"]      "+nhanVien.getMaNV());
                System.out.print("                "+nhanVien.getTenNV()+"          "+nhanVien.getCoPhan()+"%");
            }
        }
        System.out.print("\n");
    }
    public boolean chamTrung(int maNV){
        for (int i=0;i<listGD.size();i++) {
            NhanVien nhanVien = listGD.get(i);
            if(nhanVien.getMaNV()==maNV){
                return true;
            }
        }
        return false;
    }
    public void themNhanVien(int maNV,String tenNV,String SDT,int loaiNV,double coPhan,double luong){
        if(chamTrung(maNV)==false){
            listGD.add(new NhanVien(maNV,tenNV,SDT,loaiNV,coPhan,luong));
        }
    }
}
