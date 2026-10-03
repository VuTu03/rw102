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
        account2.department = department2;
        account2.position = position2;
        account2.createDate = LocalDate.of(2022, 5, 6);

        Account account3 = new Account();
        account3.id = 3;
        account3.email = "Email 3";
        account3.username = "Username 3";
        account3.fullName = "FullName 3";
        account3.department = department3;
        account3.position = position3;
        account3.createDate = LocalDate.of(2021, 4, 7);

        Group group1 = new Group();
        group1.id = 1;
        group1.name = "Hội dev";
        group1.creator = account1;
        group1.createDate = LocalDate.now();

        Group group2 = new Group();
        group2.id = 2;
        group2.name = "Hội Test";
        group2.creator = account2;
        group2.createDate = LocalDate.now();

        Group group3 = new Group();
        group3.id = 3;
        group3.name = "Hội Marketing";
        group3.creator = account3;
        group3.createDate = LocalDate.now();

      // phần bài tập:

//        Exercise1.question1(account2);
//        Exercise1.question3(account2);
//        Exercise1.question4(account1);
//
//        Exercise2.question1();
//        Exercise2.question2();
//        Exercise2.question3();
//        Exercise2.question4();
//
//        Exercise4.question1();
//        Exercise4.question2();
//        Exercise4.question3();
//        Exercise4.question4();
//        Exercise4.question5();

        Exercise5.question1();



    }
}


