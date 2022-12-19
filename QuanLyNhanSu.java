import model.NhanVien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuanLyNhanSu extends NhanVien {
   public static ArrayList<NhanVien> listNV= new ArrayList<>();
    public Scanner scanner= new Scanner(System.in);
    QuanLyTruongPhong qlTruongPhong= new QuanLyTruongPhong();
    QuanLyGiamDoc qlGiamDoc= new QuanLyGiamDoc();
    QuanLyNhanVienThuong qlNhanVienThuong= new QuanLyNhanVienThuong();
    public void dumyDataNV(){
        listNV.add(new NhanVien(1,"Lính lác F","0389985",20,1,100,8,"Nguyen văn T",0));
        listNV.add(new NhanVien(2,"Lính lác C","0389985",30,1,100,8,"Nguyen văn T",0));
        listNV.add(new NhanVien(3,"Lính lác S","0389985",40,1,100,8,"Nguyen văn T",0));
        //nv thuong  maNV, tenNV, SDT,soNgayLamViec , loaiNV, luongNgay, maTruongPhong, tenTruongPhong, luong
        listNV.add(new NhanVien(4,"Lính lác G","0389985",35,1,100,7,"Nguyen văn T",0));
        listNV.add(new NhanVien(5,"Lính lác R","0389985",31,1,100,7,"Nguyen văn T",0));
        listNV.add(new NhanVien(6,"Lính lác W","0389985",29,1,100,8,"Nguyen văn T",0));
        listNV.add(new NhanVien(7,"Tran Gia D","0389985",30,2,200,0,null,0,0));
        //int maNV,String tenNV,String SDT,double soNgayLam,int loaiNV,double luongNgay,int maTruongPhong,String tenTruongPhong,double coPhan
        listNV.add(new NhanVien(8,"Nguyen Kim C","0389985",30,2,200,0,null,0,0));
        listNV.add(new NhanVien(9,"Lê Giang B","0389985",30,3,300,0,null,20,0));
        listNV.add(new NhanVien(10,"Lê Phú A","0389985",30,3,300,0,null,50,0));
    }
    public void locListNhanVien(){
        double luong=0;
        for (int i=0; i<listNV.size();i++){
            NhanVien nhanVien = listNV.get(i);
            if(nhanVien.getLoaiNV()==1){
                    nhanVien.setLuong(nhanVien.getSoNgayLam()*nhanVien.getLuongNgay());
                    qlNhanVienThuong.themNhanVien(nhanVien.getMaNV(),nhanVien.getTenNV(),nhanVien.getSDT(),
                            nhanVien.getSoNgayLam(),nhanVien.getLoaiNV(), nhanVien.getLuongNgay(),
                            nhanVien.getMaTruongPhong(),nhanVien.getTenTruongPhong(),nhanVien.getLuong());
            }else if(nhanVien.getLoaiNV()==2) {
                    luong = qlTruongPhong.tinhLuongTP(nhanVien.getMaNV());nhanVien.setLuong(luong);
                    qlTruongPhong.themNhanVien(nhanVien.getMaNV(),nhanVien.getTenNV(),nhanVien.getLuong());
            }else if (nhanVien.getLoaiNV()==3){
                    nhanVien.setLuong(nhanVien.getSoNgayLam()*nhanVien.getLuongNgay());
                    qlGiamDoc.themNhanVien(nhanVien.getMaNV(),nhanVien.getTenNV(), nhanVien.getSDT(),
                            nhanVien.getLoaiNV(),nhanVien.getCoPhan(),nhanVien.getLuong());
            }
        }
    }
    public void xuatNhanVien(){
        System.out.println("<======>DANH SÁCH NHÂN VIÊN TOÀN CÔNG TY<======>");
        for (NhanVien nhanvien: listNV) {
            System.out.println(nhanvien);
        }
    }
    public void nhapNhanVien(){
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMaNV((listNV.size()+1));
        System.out.println("Nhập loại nhân viên cần thêm: 1.Nhân viên thường, 2.Trưởng phòng, 3.Giám đốc");
        int loaiNV=scanner.nextInt();
        nhanVien.setLoaiNV(loaiNV);
        System.out.print("Nhập tên nhân viên: "); scanner.nextLine();nhanVien.setTenNV(scanner.nextLine());
        System.out.print("Nhập số điện thoại: "); nhanVien.setSDT(scanner.nextLine());
        System.out.print("Nhập số ngày làm việc: ");nhanVien.setSoNgayLam(scanner.nextDouble());
        if(loaiNV==1){
            nhanVien.setLuongNgay(100);
            nhanVien.setLuong(nhanVien.getLuongNgay()*nhanVien.getSoNgayLam());
            qlTruongPhong.xuatTruongPhong();
            System.out.println("Nhập mã trưởng phòng quản lý, Nếu không có ai quản lý thì để nhập 0 ");
            int maTP= scanner.nextInt();
            if (maTP==0){
                nhanVien.setMaTruongPhong(0);
                nhanVien.setTenTruongPhong("null");
            }else {
                switch (qlTruongPhong.timMaTP(maTP)){
                    case 0:
                        System.out.println("Trưởng phòng không tồn tại");
                        break;
                    case 1:
                        for (int k=0;k<listNV.size();k++){
                            NhanVien truongPhong = listNV.get(k);
                            if(truongPhong.getMaNV()==maTP){
                                nhanVien.setMaTruongPhong(truongPhong.getMaNV());
                                nhanVien.setTenTruongPhong(truongPhong.getTenNV());
                            }
                        }
                        break;
                }
            }
            nhanVien.setCoPhan(0);
        }else if(loaiNV==2){
            //Truong phong
            nhanVien.setCoPhan(0);
            nhanVien.setLuongNgay(200);
            nhanVien.setMaTruongPhong(0);
            nhanVien.setTenTruongPhong(null);
        }else {
            nhanVien.setLuongNgay(300);
            nhanVien.setMaTruongPhong(0);
            nhanVien.setTenTruongPhong(null);
            System.out.println("Nhập cổ phần của "+nhanVien.getTenNV());
            double coPhan=scanner.nextDouble();
            if(coPhan<0||coPhan>100){
                nhanVien.setCoPhan(coPhan);
            }else {
                System.out.println("Cổ phần phải lớn hơn 0 và nhỏ hơn 100");
            }
        }
        listNV.add(nhanVien);
        locListNhanVien();
    }
    public void xoaNhanVien(){
        System.out.println("Nhập mã nhân viên cần xoá: "); int maNVXoa= scanner.nextInt();
        if(timMaNV(maNVXoa)<0){
            System.out.println("Mã nhân viên này không tồn tại");
        }else {
            for (int i=0; i<listNV.size();i++){
                NhanVien nhanVien = listNV.get(i);
                if(nhanVien.getMaNV()==maNVXoa){
                    listNV.remove(nhanVien);
                }
                if(nhanVien.getLoaiNV()==2){
                    goLienKet(maNVXoa);
                }
            }
            System.out.println("Đã xoá thành công!");
        }

    }
    public void goLienKet(int maTP){
        for (int i=0;i<listNV.size();i++){
            NhanVien nhanVien = listNV.get(i);
            if(nhanVien.getMaTruongPhong()==maTP){
                nhanVien.setMaTruongPhong(0);
                nhanVien.setTenTruongPhong(null);
            }
        }
    }
    public int timMaNV(int maNV){
        for (int i=0;i<listNV.size();i++) {
            NhanVien nhanVien = listNV.get(i);
            if(nhanVien.getMaNV()==maNV){
                return i;
            }
        }
        return -1;
    }
    public double tongLuongCongTy(){
        double tongLuong=0;
        for (int i = 0; i < listNV.size(); i++) {
            NhanVien nhanVien = listNV.get(i);
            tongLuong=tongLuong+nhanVien.getLuong();
            }
        return tongLuong;
    }
    public int demSoNhanVien(int maNV){
        int count=0;
        for (int i=0;i<listNV.size();i++) {
            NhanVien nhanVien = listNV.get(i);
            if(nhanVien.getMaTruongPhong()==maNV){
                count++;
            }
        }
        return count;
    }
    public void boNhiemTruongPhong(){
        System.out.println("2. Phân bổ Nhân viên vào Trưởng phòng");
        System.out.print("Nhập mã nhân viên cần bổ nhiệm: ");int maNV= scanner.nextInt();
        if (timMaNV(maNV)<0){
            System.out.println("Mã nhân viên này không tồn tại");
        }else if(getLoaiNV()==2){
                System.out.println("Trưởng phòng này đã tồn tại!");
            }else {
                NhanVien nhanVien = listNV.get(timMaNV(maNV));
                nhanVien.setLoaiNV(2);
                nhanVien.setLuongNgay(200);
                nhanVien.setMaTruongPhong(0);
                nhanVien.setTenTruongPhong(null);
                //nhanVien.setLuong(nhanVien.getLuongNgay()*nhanVien.getSoNgayLam());
                System.out.println("Đã bổ nhiệm thành công nhân viên "+nhanVien.getTenNV()+" thành trưởng phòng");
            }
    }
    public void sapXepTheoTen(){
        for (int i=0;i<listNV.size()-1;i++){
            for (int j=i+1;j<listNV.size();j++){
                if (tachTen(listNV.get(i).getTenNV()).compareTo(tachTen(listNV.get(j).getTenNV()))>0){
                    Collections.swap(listNV,i,j);
                }
            }
        }
        xuatNhanVien();
    }
    public String tachTen(String hoten){
        String ten = hoten.substring(hoten.lastIndexOf(" ")+1);
        return ten;
    }
    public void sapXepLuongGiam(){
        for (int i=0;i<listNV.size()-1;i++){
            for (int j=i+1;j<listNV.size();j++){
                if (listNV.get(i).getLuong()<listNV.get(j).getLuong()){
                    Collections.swap(listNV,i,j);
                }
            }
        }
        xuatNhanVien();
    }
    public void thuNhap(double loiNhuan){
        //Thu nhập = Lương tháng + số cổ phần * Lợi nhuận công ty
        System.out.println("<======>THU NHẬP CỦA GIÁM ĐỐC<======>");
        System.out.print("STT    MÃ GD          TÊN GIÁM ĐỐC        Cổ Phần(%)         THU NHẬP ");
        double thuNhap=0;
        int k=0;
        for (int i=0;i<listNV.size();i++) {
            NhanVien nhanVien = listNV.get(i);
            if(nhanVien.getLoaiNV()==3){
                thuNhap= nhanVien.getLuong()+ (nhanVien.getCoPhan()/100)*loiNhuan;
                System.out.print("\n ["+(++k)+"]      "+nhanVien.getMaNV());
                System.out.print("                "+nhanVien.getTenNV()+"          "+nhanVien.getCoPhan()+"%           "+thuNhap);
            }
        }
        System.out.print("\n");
    }
}
