import model.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        Scanner scanner= new Scanner(System.in);
        QuanLyNhanSu quanLyNhanSu=new QuanLyNhanSu();
        QuanLyTruongPhong qlTruongPhong= new QuanLyTruongPhong();
        QuanLyNhanVienThuong qlNVthuong = new QuanLyNhanVienThuong();
        QuanLyGiamDoc quanLyGiamDoc = new QuanLyGiamDoc();
        quanLyNhanSu.dumyDataNV();
        CongTy congTy = new CongTy();
///        congTy.dumydataCongTy();
        int chon;
        do {
            quanLyNhanSu.locListNhanVien();
            System.out.print("==================MENU====================\n" +
                    "1. Nhập thông tin công ty\n" +
                    "2. Phân bổ Nhân viên vào Trưởng phòng\n" +
                    "3. Thêm, xóa thông tin một nhân sự (có thể là Nhân viên, trưởng phòng hoặc giám đốc).\n " +
                    "Lưu ý khi xóa trưởng phòng, phải ngắt liên kết với các nhân viên đang tham chiếu tới.\n" +
                    "4. Xuất ra thông tin toàn bộ người trong công ty\n" +
                    "5. Tính và xuất tổng lương cho toàn công ty\n" +
                    "6. Tìm Nhân viên thường có lương cao nhất\n" +
                    "7. Tìm Trưởng Phòng có số lượng nhân viên dưới quyền nhiều nhất\n" +
                    "8. Sắp xếp nhân viên toàn công ty theo thứ tự abc\n" +
                    //https://www.youtube.com/watch?v=L42NVLVznZE&list=PLFPekWzEN9zMJ_3EU06_RzvTJWzA4b4Uo&index=29
                    "9. Sắp xếp nhân viên toàn công ty theo thứ tự lương giảm dần\n" +
                    "10. Tìm Giám Đốc có số lượng cổ phần nhiều nhất\n" +
                    "11. Tính và Xuất tổng THU NHẬP của từng Giám Đốc \n" +
                    "0. Thoát.\n" +
                    "===================================================\n" +
                    "Hãy lựa chọn : ");
            chon = scanner.nextInt();
            if (chon == 1) {
                if(congTy.ttCongty.size()==1){
                    System.out.println("Thông tin công ty đã có");
                    congTy.xuatCongTy();
                }else {
                    congTy.nhapCongTy();
                    System.out.println("Thông tin công ty vừa nhập là: ");
                    congTy.xuatCongTy();
                }
            } else if (chon == 2) {
                qlTruongPhong.xuatTruongPhong();
                qlNVthuong.xuatNhanVienThuong();
                quanLyNhanSu.boNhiemTruongPhong();

               // qlTruongPhong.setLuong();
            }else if (chon==3){
                // Thêm, xóa thông tin một nhân sự
                System.out.println("Nhập 1 nếu muốn thêm nhân viên, 2 nếu muốn xoá nhân viên");
                int them= scanner.nextInt();
                if(them==1){
                    quanLyNhanSu.nhapNhanVien();
                }else if(them==2){
                    quanLyNhanSu.xoaNhanVien();
                }else {
                    System.out.println("Bạn nhập không đúng yêu cầu!");
                }
            }else if(chon==4){
                //"4. Xuất ra thông tin toàn bộ người trong công ty\n" +
                System.out.println(" DANH SÁCH TẤT CẢ NGÂN VIÊN TRONG CÔNG TY");
                quanLyNhanSu.xuatNhanVien();
            }else if(chon==5){
                //Tính và xuất tổng lương cho toàn công ty
                System.out.println("Lương của toàn bộ người trong công ty là "+quanLyNhanSu.tongLuongCongTy()+" (USD)");
            }else if(chon==6){
                //"6. Tìm Nhân viên thường có lương cao nhất\n"
                qlNVthuong.nhanVienLuongMax();
            }else if(chon==7){
                //"7. Tìm Trưởng Phòng có số lượng nhân viên dưới quyền nhiều nhất
                qlTruongPhong.nhanVienDuoiQuyen();
            }else if(chon==8){
               //  Sắp xếp nhân viên toàn công ty theo thứ tự abc
                System.out.println("<======>SẮP XẾP TÊN NHÂN VIÊN THEO ABC <======>");
                quanLyNhanSu.sapXepTheoTen();
                quanLyNhanSu.xuatNhanVien();
            }else if(chon==9){
                //9. Sắp xếp nhân viên toàn công ty theo thứ tự lương giảm dần
                System.out.println("<======>SẮP XẾP DANH SÁCH NHÂN VIÊN THEO LƯƠNG GIẢM DẦN<======>");
                quanLyNhanSu.sapXepLuongGiam();
            }else if(chon==10){
                //Tìm Giám Đốc có số lượng cổ phần nhiều nhất
                quanLyGiamDoc.timCoPhanCao();
            }else if(chon==11){
                if(congTy.ttCongty.size()==0){
                    System.out.println("Bạn chưa nhập thông tin công ty, Vui lòng chọn 1 để nhập thông tin công ty.");
                }else {
                    double loiNhuan= congTy.ttCongty.get(0).getDoanhThuThang()-quanLyNhanSu.tongLuongCongTy();
                    //System.out.println(loiNhuan);
                    quanLyNhanSu.thuNhap(loiNhuan);
                }
            }else {
                System.out.println("Vui lòng chọn đúng MENU!");
            }
        }while (chon != 0) ;
    }

}