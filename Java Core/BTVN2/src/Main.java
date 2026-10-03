public class Main {
    public static void main(String[] args) {
//// IF
//// Question 1:
////        Kiểm tra account thứ 2
////        Nếu không có phòng ban (tức là department == null) thì sẽ in ra text
////        "Nhân viên này chưa có phòng ban"
////        Nếu không thì sẽ in ra text "Phòng ban của nhân viên này là …"
//
//// Question 2:
////        Kiểm tra account thứ 2
////        Nếu không có group thì sẽ in ra text "Nhân viên này chưa có group"
////        Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text "Group của nhân viên này là Java Fresher, C# Fresher"
////        Nếu có mặt trong 3 Group thì sẽ in ra text "Nhân viên này là người quan trọng, tham gia nhiều group"
////        Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là người hóng chuyện, tham gia tất cả các group"
//        int Group = 3;
//        if (Group == 1 && Group == 2){
//            System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
//        } else if (Group == 3) {
//            System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
//        } else if (Group == 4) {
//            System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
//        }else {
//            System.out.println("Nhân viên này chưa có Group");
//        }
//
//// Question 3:
////        Sử dụng toán tử ternary để làm Question 1
//        System.out.println(Department == null ? "Nhân viên này chưa có phòng ban" : "Phòng ban của nhân viên này là...");
//
//// Question 4:
//    // Sử dụng toán tử ternary để làm yêu cầu sau:
//    //Kiểm tra Position của account thứ 1
//    //Nếu Position = Dev thì in ra text "Đây là Developer"
//    //Nếu không phải thì in ra text "Người này không phải là Developer"
//        String Position = "Dev";
//        System.out.println(Position == "Dev"  ? "Đây là Developer" : "Người này không phải là Developer");
//
//// SWITCH CASE
//        //Question 5:
//        //Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau:
//        // Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên"
//        //Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên"
//        //Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên"
//        //Còn lại in ra "Nhóm có nhiều thành viên"
//        int Account = 2;
//        switch (Account){
//            case 1:
//                System.out.println("Nhóm có một thành viên");
//                break;
//            case 2:
//                System.out.println("Nhóm có hai thành viên");
//                break;
//            case 3:
//                System.out.println("Nhóm có ba thành viên");
//                break;
//            default:
//                System.out.println("Nhóm có nhiều thành viên");
//        }
//
////        Question 6:
////        Sử dụng switch case để làm lại Question 2
//        switch (Group){
//            case 1:
//                System.out.println("Group của nhân viên này là Java Fresher");
//                break;
//            case 2:
//                System.out.println("Group của nhân viên này là C# Fresher");
//                break;
//            case 3:
//                System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
//                break;
//            case 4:
//                System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
//                break;
//            default:
//                System.out.println("Nhân viên này chưa có group");
//        }
//
////        Question 7:
////        Sử dụng switch case để làm lại Question 4
//        switch (Position){
//            case "Dev":
//                System.out.println("Đây là Developer");
//                break;
//            default:
//                System.out.println("Người này không phải là Developer");
//        }
//
////        FOREACH
////        Question 8:
////        In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ
//            String[] account = new String[]{"Email", "FullName",""};
//
////        Question 9:
////        In ra thông tin các phòng ban bao gồm: id và name
//        String[] Department1 = new String[]{"ID","Name"};
//        for (String dep1 : Department1 ){
//            System.out.println("ID" + dep1.id + "Name: " + dep1.name);
//        }
//
//
////        FOR
//        //Question 10:
//        //In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ theo định dạng như sau:
//        //Thông tin account thứ 1 là:
//        //Email: NguyenVanA@gmail.com
//        //Full name: Nguyễn Văn A
//        //Phòng ban: Sale
//        //
//        //Thông tin account thứ 2 là:
//        //Email: NguyenVanB@gmail.com
//        //Full name: Nguyễn Văn B
//        //Phòng ban: Marketting
//
//
//
//
//
//
//
////        Question 15:
////        In ra các số chẵn nhỏ hơn hoặc bằng 20
//        int so = 20;
//        for (int i = 1; i <= 20 ; i ++){
//            if (i % 2 == 0){
//                System.out.println(so);
//            }
//
//        }
//

    }
}