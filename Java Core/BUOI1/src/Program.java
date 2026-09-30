import java.time.LocalDate;

public class Program {
    public static void main(String[] args) {
        // tạo ra các department
        Department department1 = new Department();
        department1.id = 1;
        department1.name ="Sale";
        Department department2 = new Department();
        department2.id = 2;
        department2.name ="Marketing";
        Department department3 = new Department();
        department3.id = 1;
        department3.name ="Bảo vệ";
        System.out.println("Department ID: " + department1.id);
        System.out.println("Department Name: " + department1.name);

        // tạo ra các position
        Position position1 = new Position();
        position1.id = 1;
        position1.name = PositionName.DEV;
        Position position2 = new Position();
        position2.id = 2;
        position2.name = PositionName.TEST;
        Position position3 = new Position();
        position3.id = 3;
        position3.name = PositionName.PM;
        Position position4 = new Position();
        position4.id = 4;
        position4.name = PositionName.SCRUM_MASTER;


        // tạo ra các account
        Account account1 = new Account();
        account1.id = 1;
        account1.username = "VuTu";
        account1.fullname = "Vũ Văn Tú";
        account1.email = "tu@gmail.com";
        account1.department = department1;
        account1.position = position1;
        account1.createDate = LocalDate.now();
    }
}
