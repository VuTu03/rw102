import java.time.LocalDate;

public class Program {
    public static void main(String[] args) {
        Department department1 = new Department();
        department1.id = 1;
        department1.name = "Sale";

        Department department2 = new Department();
        department2.id = 2;
        department2.name = "Marketing";

        Department department3 = new Department();
        department3.id = 3;
        department3.name = "Bảo vệ";

        Position position1 = new Position();
        position1.id = 1;
        position1.name = Position.PositionName.DEV;

        Position position2 = new Position();
        position2.id = 2;
        position2.name = Position.PositionName.TEST;

        Position position3 = new Position();
        position3.id = 3;
        position3.name = Position.PositionName.SCRUM_MASTER;

        Position position4 = new Position();
        position4.id = 1;
        position4.name = Position.PositionName.PM;


        Account account1 = new Account();
        account1.id = 1;
        account1.email = "Email 1";
        account1.username = "Username 1";
        account1.fullName = "FullName 1";
        account1.department = department1;
        account1.position = position1;
        account1.createDate = LocalDate.of(2020, 1, 1);

        Account account2 = new Account();
        account2.id = 2;
        account2.email = "Email 2";
        account2.username = "Username 2";
        account2.fullName = "FullName 2";
        account2.department = department1;
        account2.position = position1;
        account2.createDate = LocalDate.of(2020, 1, 1);

        Account account3 = new Account();
        account3.id = 3;
        account3.email = "Email 3";
        account3.username = "Username 3";
        account3.fullName = "FullName 3";
        account3.department = department1;
        account3.position = position1;
        account3.createDate = LocalDate.of(2020, 1, 1)
    }
//        Exercise 1 (Optional): Flow Control
//        IF
//        Question 1:
//        Kiểm tra account thứ 2
//        Nếu không có phòng ban (tức là department == null) thì sẽ in ra text
//        "Nhân viên này chưa có phòng ban"
//        Nếu không thì sẽ in ra text "Phòng ban của nhân viên này là …"
        if (account2.department == null){
            System.out.println("Nhân viên này chưa có phòng ban");
        }else {
            System.out.println("Phòng ban của nhân viên này là: " +department);
        }


//        Question 2:
//        Kiểm tra account thứ 2
//        Nếu không có group thì sẽ in ra text "Nhân viên này chưa có group"
//        Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text "Group của nhân viên này là Java Fresher, C# Fresher"
//        Nếu có mặt trong 3 Group thì sẽ in ra text "Nhân viên này là người quan trọng, tham gia nhiều group"
//        Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là người hóng chuyện, tham gia tất cả các group"
            int Group = 4 ;
        if (Group == 4){
            System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
        } else if (Group == 1 && Group == 2) {
            System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
        } else if (Group == 3) {
            System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
        } else {
            System.out.println("Nhân viên này ko có Group");
        }


//        Question 3:
//        Sử dụng toán tử ternary để làm Question 1
        System.out.println(Department == null
                ? "Nhân viên này chưa có phòng ban."
 	 	 	: "Phòng của nhân viên này là: " + Department);

//        Question 4:
//        Sử dụng toán tử ternary để làm yêu cầu sau:
//        Kiểm tra Position của account thứ 1
//        Nếu Position = Dev thì in ra text "Đây là Developer"
//        Nếu không phải thì in ra text "Người này không phải là Developer"
        String Position;
        System.out.println(Position.toString() == "Dev"
                ? "Đây là Developer"
                : "Người này không phải là Developer");






//        SWITCH CASE
//        Question 5:
//        Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau: Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên"
//        Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên"
//        Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên"
//        Còn lại in ra "Nhóm có nhiều thành viên"
        int Account = 3;
        switch (Account){
            case 1:
                System.out.println("Nhóm có một thành viên");
                break;
            case 2:
                System.out.println("Nhóm có hai thành viên");
                break;
            case 3:
                System.out.println("Nhóm có ba thành viên");
                break;
            default:
                System.out.println("Nhóm có nhiều thành viên");
        }

//        Question 6:
//        Sử dụng switch case để làm lại Question 2
        switch (Group){
            case 1:
                System.out.println("Group của nhân viên này là Java Fresher");
                break;
            case 2:
                System.out.println("Group của nhân viên này là C# Fresher");
                break;
            case 3:
                System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
                break;
            case 4:
                System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
                break;
            default:
                System.out.println("Nhân viên này ko có Group");
        }


//        Question 7:
//        Sử dụng switch case để làm lại Question 4
        switch (Position) {case "Dev":
            System.out.println("Đây là Developer");
            break;
            default:
                System.out.println("Người này không phải là Developer");
                break;

//        FOREACH
//        Question 8:
//        In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ
            Account[] accArray = { acc1, acc2, acc3 };
            for (Account account : accArray) {
                System.out.println("AccountID: " + account.id + " Email: " + account.email + " Name: " + account.fullName);
            }

//        Question 9:
//        In ra thông tin các phòng ban bao gồm: id và name
            Department[] depArray = { dep1, dep2, dep3 };
            for (Department department : depArray) {
                System.out.println("DepID: " + department.id + " Name: " + department.name);
            }


//        FOR
//        Question 10:
//        In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ theo định dạng như sau:
//        Thông tin account thứ 1 là:
//        Email: NguyenVanA@gmail.com
//        Full name: Nguyễn Văn A
//        Phòng ban: Sale

//        Thông tin account thứ 2 là:
//        Email: NguyenVanB@gmail.com
//        Full name: Nguyễn Văn B
//        Phòng ban: Marketting

            Account[] accArray1 = { acc1, acc2 };
            for (int i = 0; i < accArray1.length; i++) {
                System.out.println("Thông tin account thứ " + (i + 1) + " là:");
                System.out.println("Email: " + accArray1[i].email);
                System.out.println("Full name: " + accArray1[i].fullName);
                System.out.println("Phòng ban: " + accArray1[i].department.name);
            }


//        Question 11:
//        In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
//        Thông tin department thứ 1 là:
//        Id: 1
//        Name: Sale
//        Thông tin department thứ 2 là:
//        Id: 2
//        Name: Marketing
            Department[] depArray1 = { dep1, dep2, dep3 };
            for (int i = 0; i < depArray1.length; i++) {
                System.out.println("Thông tin department thứ " + (i + 1) + " là:");
                System.out.println("Id: " + depArray1[i].id);
                System.out.println("Name: " + depArray1[i].name);
            }



//        Question 12:
//        Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10
            for (int i = 0; i < department.length: i++){
                if (i < 2){
                    System.out.println("Department ID: " + department[i].id + "Department Name: " + department[i].name);
                }
        }



//        Question 13:
//        In ra thông tin tất cả các account ngoại trừ account thứ 2
                Account[] accArray2 = { acc1, acc2, acc3 };
                for (int i = 0; i < accArray2.length; i++) {
                    if (i != 1) {
                        System.out.println("Thông tin account thứ " + (i + 1));
                        System.out.println("Email: " + accArray2[i].email);
                                System.out.println("Full name: " +[i].fullName);
                        System.out.println("Phòng ban: " +[i].department.name);
                    }
                }


//        Question 14:
//        In ra thông tin tất cả các account có id < 4
                Account[] accArray3 = { acc1, acc2, acc3 };
                for (int j = 0; j < accArray3.length; j++) {
                    if (accArray3[j].id < 4) {
                        System.out.println("Thông tin account thứ " + (j + 1) +"Là : ");
                                System.out.println("Email: " + accArray3[j].email);
                                System.out.println("Full name: " + fullName);
                        System.out.println("Phòng ban: " + department.name);
                    }
                }


//        Question 15:
//        In ra các số chẵn nhỏ hơn hoặc bằng 20
                for (int i = 1; i <= 20; i++) {
                    if (i%2 ==0 ) {
                    System.out.print(i);
                }
                }

            }
}
