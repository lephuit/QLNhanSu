package model;
public class NhanVien {
    public  int maNV;
    public String tenNV;
    public String SDT;
    public double soNgayLam;
    public double luongNgay;
    public int maTruongPhong;
    public String tenTruongPhong;
    public int loaiNV;
    public double coPhan;
    public double luong;

    public NhanVien(){}
    public NhanVien(int maNV,String tenNV,String SDT,double soNgayLam,int loaiNV,double luongNgay,
                    int maTruongPhong,String tenTruongPhong,double coPhan,double luong){
        this.maNV=maNV;
        this.SDT=SDT;
        this.tenNV=tenNV;
        this.soNgayLam=soNgayLam;
        this.maTruongPhong=maTruongPhong;
        this.tenTruongPhong=tenTruongPhong;
        this.coPhan=coPhan;
        this.loaiNV=loaiNV;
        this.luongNgay=luongNgay;
        this.luong=luong;
    }
    //Nhân viên thường
    public NhanVien(int maNV,String tenNV,String SDT,double soNgayLam,int loaiNV,double luongNgay,
                    int maTruongPhong,String tenTruongPhong,double luong){
        this.maNV=maNV;
        this.SDT=SDT;
        this.tenNV=tenNV;
        this.soNgayLam=soNgayLam;
        this.maTruongPhong=maTruongPhong;
        this.tenTruongPhong=tenTruongPhong;
        this.loaiNV=loaiNV;
        this.luongNgay=luongNgay;
        this.luong=luong;
    }
    //Giam dốc
    public NhanVien(int maNV,String tenNV,String SDT,int loaiNV,double coPhan,double luong){
        this.maNV=maNV;
        this.tenNV=tenNV;
        this.coPhan=coPhan;
        this.loaiNV=loaiNV;
        this.SDT=SDT;
        this.luong=luong;

    }
    //Truong phong
    public NhanVien(int maNV, String tenNV,double luong){
        this.maNV=maNV;
        this.tenNV=tenNV;
        this.luong=luong;
    }

//    public NhanVien(int maNV,String tenNV,String SDT,double soNgayLam,double luongNgay){
//        this.maNV=maNV;
//        this.SDT=SDT;
//        this.tenNV=tenNV;
//        this.soNgayLam=soNgayLam;
//        this.luongNgay=luongNgay;
//    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public double getSoNgayLam() {
        return soNgayLam;
    }

    public int getLoaiNV() {
        return loaiNV;
    }

    public void setLoaiNV(int loaiNV) {
        this.loaiNV = loaiNV;
    }

    public void setSoNgayLam(double soNgayLam) {
        this.soNgayLam = soNgayLam;
    }

    public double getLuongNgay() {
        return luongNgay;
    }

    public void setLuongNgay(double luongNgay) {
        this.luongNgay = luongNgay;
    }

    public int getMaTruongPhong() {
        return maTruongPhong;
    }

    public void setMaTruongPhong(int maTruongPhong) {
        this.maTruongPhong = maTruongPhong;
    }

    public String getTenTruongPhong() {
        return tenTruongPhong;
    }

    public void setTenTruongPhong(String tenTruongPhong) {
        this.tenTruongPhong = tenTruongPhong;
    }

    public double getCoPhan() {
        return coPhan;
    }

    public void setCoPhan(double coPhan) {
        this.coPhan = coPhan;
    }

    @Override
    public String toString() {
        return "[" +
                "Mã NV:" + maNV +
                ", Tên: '" + tenNV + '\'' +
                ", SDT: '" + SDT + '\'' +
                ", Số ngày làm: " + soNgayLam +
                ", Lương 1 ngày: " + luongNgay +
                ", Mã TP: " + maTruongPhong +
                ", Tên TP: '" + tenTruongPhong + '\'' +
                ", Loại NV: " + loaiNV +
                ", Cổ phần: " + coPhan +
                ", Lương: " + luong +
                ']';
    }

}
