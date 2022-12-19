package model;
import java.util.ArrayList;
import java.util.Scanner;

public class CongTy {
    private int maCongTy;
    private String tenCongTy;
    private String MST;
    public double doanhThuThang;
    public double loiNhuan;
    public ArrayList<CongTy> ttCongty = new ArrayList<>(1);
    public void dumydataCongTy(){
        ttCongty.add(new CongTy(01,"Công ty A","31223215",50000));
    }

    public CongTy(){}
    public CongTy(int maCongTy,String tenCongTy,String MST,double doanhThuThang){
        this.maCongTy=maCongTy;
        this.tenCongTy=tenCongTy;
        this.MST=MST;
        this.doanhThuThang=doanhThuThang;
    }
    public void nhapCongTy(){
        Scanner scanner= new Scanner(System.in);
        System.out.print("Nhập mã công ty: ");setMaCongTy(scanner.nextInt());
        System.out.print("Nhập tên công ty: ");scanner.nextLine();setTenCongTy(scanner.nextLine());
        System.out.print("MST : ");setMST(scanner.nextLine());
        System.out.print("Doanh thu tháng: ");setDoanhThuThang(scanner.nextDouble());
        ttCongty.add(new CongTy(getMaCongTy(),getTenCongTy(),getMST(),getDoanhThuThang()));
    }


    public double getLoiNhuan() {
        return loiNhuan;
    }

    public void setLoiNhuan(double loiNhuan) {
        this.loiNhuan = loiNhuan;
    }

    public ArrayList<CongTy> getTtCongty() {
        return ttCongty;
    }

    public void setTtCongty(ArrayList<CongTy> ttCongty) {
        this.ttCongty = ttCongty;
    }

    public void xuatCongTy(){
        System.out.println("Mã công ty: "+getMaCongTy()+"Tên công ty: "+getTenCongTy()+" MST : "+getMST()+" Doanh thu tháng: "+getDoanhThuThang());
    }
    public int getMaCongTy() {
        return maCongTy;
    }

    public void setMaCongTy(int maCongTy) {
        this.maCongTy = maCongTy;
    }

    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }

    public String getMST() {
        return MST;
    }

    public void setMST(String MST) {
        this.MST = MST;
    }

    public double getDoanhThuThang() {
        return doanhThuThang;
    }

    public void setDoanhThuThang(double doanhThuThang) {
        this.doanhThuThang = doanhThuThang;
    }

    @Override
    public String toString() {
        return "CongTy{" +
                "maCongTy=" + maCongTy +
                ", tenCongTy='" + tenCongTy + '\'' +
                ", MST='" + MST + '\'' +
                ", doanhThuThang=" + doanhThuThang +
                ", loiNhuan=" + loiNhuan +
                ", ttCongty=" + ttCongty +
                '}';
    }
}
