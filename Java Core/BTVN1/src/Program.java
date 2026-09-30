import java.time.LocalDate;
import java.time.LocalDateTime;

public class Program {
    public static void main(String[] args) {
        Department department1 = new Department();
        department1.id = 1;
        department1.name ="Sale";
        Department department2 = new Department();
        department2.id = 2;
        department2.name ="Marketing";
        Department department3 = new Department();
        department3.id = 3;
        department3.name ="Bảo vệ";
        System.out.println("Id: "+ department1.id);
        System.out.println("Name: "+ department1.name);


        Position position1 = new Position();
        position1.id = 1;
        position1.name = PositionName.PM;
        Position position2 = new Position();
        position2.id = 2;
        position2.name = PositionName.Dev;
        Position position3 = new Position();
        position3.id = 3;
        position3.name = PositionName.Test;
        Position position4 = new Position();
        position4.id = 4;
        position4.name = PositionName.Scrum_Master;
        System.out.println("ID: "+ position1.id);
        System.out.println("Name: "+ position1.name);


        Account account1 = new Account();
        account1.id = 1;
        account1.email = "tu@gmail.com";
        account1.userName = "VuTu";
        account1.fullName = "Vũ Văn Tú";
        account1.department = department1;
        account1.position = position1;
        account1.createDate = LocalDate.now();
        Account account2 = new Account();
        account2.id = 2;
        account2.email = "tuan@gmail.com";
        account2.userName = "Vantuan";
        account2.fullName = "Nguyễn Văn Tuấn";
        account2.department = department2;
        account2.position = position2;
        account2.createDate = LocalDate.now();
        Account account3 = new Account();
        account3.id = 3;
        account3.email = "linh@gmail.com";
        account3.userName = "thuylinh";
        account3.fullName = "Đỗ Thuỳ Linh";
        account3.department = department3;
        account3.position = position3;
        account3.createDate = LocalDate.now();
        System.out.println("ID: "+ account1.id);
        System.out.println("Name: "+ account1.email);
        System.out.println("UserName: "+ account1.userName);
        System.out.println("FullName: "+ account1.fullName);
        System.out.println("Department: "+ account1.department);
        System.out.println("Position: "+ account1.position);
        System.out.println("Date: "+ account1.createDate);



        Group group1 = new Group();
        group1.id = 1;
        group1.groupName = "Hội dev";
        group1.createId = 1;
        group1.createDate = LocalDate.now();
        Group group2 = new Group();
        group2.id = 2;
        group2.groupName = "Hội Test";
        group2.createId = 2;
        group2.createDate = LocalDate.now();
        Group group3 = new Group();
        group3.id = 3;
        group3.groupName = "Hội Marketing";
        group3.createId = 3;
        group3.createDate = LocalDate.now();
        System.out.println("ID: "+ group1.id);
        System.out.println("Name: "+ group1.groupName);
        System.out.println("NameID: "+ group1.createId);
        System.out.println("Date: "+ group1.createDate);

        
        GroupAccount groupAccount1 = new GroupAccount();
        groupAccount1.group = group1;
        groupAccount1.account = account1;
        groupAccount1.joinDate = LocalDate.now();
        GroupAccount groupAccount2 = new GroupAccount();
        groupAccount2.group = group2;
        groupAccount2.account = account2;
        groupAccount2.joinDate = LocalDate.now();
        GroupAccount groupAccount3 = new GroupAccount();
        groupAccount3.group = group3;
        groupAccount3.account = account3;
        groupAccount3.joinDate = LocalDate.now();

        TypeQuestion typeQuestion1 = new TypeQuestion();
        typeQuestion1.id = 1;
        typeQuestion1.name = TypeName.Essay;
        TypeQuestion typeQuestion2 = new TypeQuestion();
        typeQuestion2.id = 2;
        typeQuestion2.name = TypeName.Multiple_Choice;

        CategoryQuestion categoryQuestion1 = new CategoryQuestion();
        categoryQuestion1.id = 1;
        categoryQuestion1.name = CategoryName.Java;
        CategoryQuestion categoryQuestion2 = new CategoryQuestion();
        categoryQuestion2.id = 2;
        categoryQuestion2.name = CategoryName.NET;
        CategoryQuestion categoryQuestion3 = new CategoryQuestion();
        categoryQuestion3.id = 3;
        categoryQuestion3.name = CategoryName.SQL;
        CategoryQuestion categoryQuestion4 = new CategoryQuestion();
        categoryQuestion4.id = 4;
        categoryQuestion4.name = CategoryName.Ruby;
        CategoryQuestion categoryQuestion5 = new CategoryQuestion();
        categoryQuestion5.id = 5;
        categoryQuestion5.name = CategoryName.Postman;

        Question question1 = new Question();
        question1.id = 1;
        question1.content = "...";
        question1.categoryQuestion = categoryQuestion1;
        question1.typeQuestion = typeQuestion1;
        question1.creatorId = 1;
        question1.createDate = LocalDate.now();
        Question question2 = new Question();
        question2.id = 2;
        question2.content = "...";
        question2.categoryQuestion = categoryQuestion2;
        question2.typeQuestion = typeQuestion2;
        question2.creatorId = 2;
        question2.createDate = LocalDate.now();
        Question question3 = new Question();
        question3.id = 3;
        question3.content = "...";
        question3.categoryQuestion = categoryQuestion1;
        question3.typeQuestion = typeQuestion1;
        question3.creatorId = 3;
        question3.createDate = LocalDate.now();

        Answer answer1 = new Answer();
        answer1.id = 1;
        answer1.content = "...";
        answer1.question = question1;
        answer1.isCorrect = true;
        Answer answer2 = new Answer();
        answer2.id = 1;
        answer2.content = "...";
        answer2.question = question2;
        answer2.isCorrect = false;

        Exam exam1 = new Exam();
        exam1.id = 1;
        exam1.code = "...";
        exam1.title = "...";
        exam1.categoryQuestion = categoryQuestion1;
        exam1.duration = LocalDateTime.now();
        exam1.creatorID = 1;
        exam1.createDate = LocalDate.now();
        Exam exam2 = new Exam();
        exam2.id = 2;
        exam2.code = "...";
        exam2.title = "...";
        exam2.categoryQuestion = categoryQuestion2;
        exam2.duration = LocalDateTime.now();
        exam2.creatorID = 2;
        exam2.createDate = LocalDate.now();

        ExamQuestion examQuestion1 = new ExamQuestion();
        examQuestion1.exam = exam1;
        examQuestion1.question = question1;
        ExamQuestion examQuestion2 = new ExamQuestion();
        examQuestion2.exam = exam2;
        examQuestion2.question = question2;

    }
}
