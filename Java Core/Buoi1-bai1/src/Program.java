import java.time.LocalDate;
import java.time.LocalDateTime;

public class Program {
    public static void main(String[] args) {
        // Department
        Department department1 = new Department();
        department1.id = 1;
        department1.name = "Sale";

        Department department2 = new Department();
        department2.id = 2;
        department2.name = "Marketing";

        Department department3 = new Department();
        department3.id = 3;
        department3.name = "Bảo vệ";

        System.out.println("Department Name: " + department1.name);

        //Position
        Position position1 = new Position();
        position1.id = 1;
        position1.name = Positionname.DEV;

        Position position2 = new Position();
        position2.id = 2;
        position2.name = Positionname.TEST;

        Position position3 = new Position();
        position3.id = 2;
        position3.name = Positionname.SCRUM_MASTER;

        System.out.println("Position name: " + Positionname.TEST);

        //Account
        Account account1 = new Account();
        account1.id = 1;
        account1.email = "Vuvantu@gmail.com";
        account1.fullname = "Vũ Văn Tú";
        account1.username = "Vantu";
        account1.department = department1;
        account1.position = position1;
        account1.createDate = LocalDate.now();

        Account account2 = new Account();
        account2.id = 2;
        account2.email = "Trananhkiet@gmail.com";
        account2.fullname = "Trần Anh Kiệt";
        account2.username = "Anhkiet";
        account2.department = department2;
        account2.position = position2;
        account2.createDate = LocalDate.now();

        Account account3 = new Account();
        account3.id = 3;
        account3.email = "Chuongduong@gmail.com";
        account3.fullname = "Nguyễn Chương Dương";
        account3.username = "Chuongduong";
        account3.department = department3;
        account3.position = position3;
        account3.createDate = LocalDate.now();

        System.out.println("Account Email: " + account3.email);

        // Group
        Group group1 = new Group();
        group1.id = 1;
        group1.name = "Java";
        group1.createID = 1;
        group1.createDate = LocalDate.now();

        Group group2 = new Group();
        group2.id = 2;
        group2.name = "Python";
        group2.createID = 2;
        group2.createDate = LocalDate.now();

        Group group3 = new Group();
        group3.id = 3;
        group3.name = "C++";
        group3.createID = 3;
        group3.createDate = LocalDate.now();

        System.out.println("Group Name: " + group3.name);

        // GroupAccount
        GroupAccount groupAccount1 = new GroupAccount();
        groupAccount1.group = group1;
        groupAccount1.account = account1;
        groupAccount1.joindate = LocalDate.now();

        // TypeQuestion
        TypeQuestion typeQuestion1 = new TypeQuestion();
        typeQuestion1.id = 1;
        typeQuestion1.typename = Typename.ESSAY;

        TypeQuestion typeQuestion2 = new TypeQuestion();
        typeQuestion2.id = 2;
        typeQuestion2.typename = Typename.MULTIPLE_CHOICE;

        TypeQuestion typeQuestion3 = new TypeQuestion();
        typeQuestion3.id = 3;
        typeQuestion3.typename = Typename.HARD;

        System.out.println("TypeQuestion name: " + typeQuestion2.typename);

        // CategoryQuestion
        CategoryQuestion categoryQuestion1 = new CategoryQuestion();
        categoryQuestion1.id = 1;
        categoryQuestion1.categoryname = Categoryname.JAVA;

        CategoryQuestion categoryQuestion2 = new CategoryQuestion();
        categoryQuestion2.id = 2;
        categoryQuestion2.categoryname = Categoryname.NET;

        CategoryQuestion categoryQuestion3 = new CategoryQuestion();
        categoryQuestion3.id = 3;
        categoryQuestion3.categoryname = Categoryname.SQL;

        System.out.println("CategoryQuestion: " + categoryQuestion1.categoryname);

        // Question
        Question question1 = new Question();
        question1.id = 1;
        question1.content ="Java là gì?";
        question1.categoryQuestion = categoryQuestion1;
        question1.typeQuestion = typeQuestion1;
        question1.createID = 1;
        question1.createDate = LocalDate.now();

        Question question2 = new Question();
        question2.id = 2;
        question2.content ="NET là gì?";
        question2.categoryQuestion = categoryQuestion2;
        question2.typeQuestion = typeQuestion2;
        question2.createID = 2;
        question2.createDate = LocalDate.now();

        Question question3 = new Question();
        question3.id = 3;
        question3.content ="SQL là gì?";
        question3.categoryQuestion = categoryQuestion2;
        question3.typeQuestion = typeQuestion3;
        question3.createID = 3;
        question3.createDate = LocalDate.now();

        System.out.println("Question id: " + question3.id );

        // Answer
        Answer answer1 = new Answer();
        answer1.id = 1;
        answer1.content = "Java là ...";
        answer1.question = question1;
        answer1.isCorrect = true;

        Answer answer2 = new Answer();
        answer2.id = 2;
        answer2.content = "NET là ...";
        answer2.question = question2;
        answer2.isCorrect = false;

        Answer answer3 = new Answer();
        answer3.id = 3;
        answer3.content = "SQL là ...";
        answer3.question = question3;
        answer2.isCorrect = false;

        System.out.println("Answer content: " + question2.content);

        // Exam
        Exam exam1 = new Exam();
        exam1.id = 1;
        exam1.code = "1";
        exam1.title = "1";
        exam1.categoryQuestion = categoryQuestion1;
        exam1.duration = LocalDateTime.now();
        exam1.creatorID = 1;
        exam1.crateDate = LocalDate.now();

        Exam exam2 = new Exam();
        exam2.id = 2;
        exam2.code = "2";
        exam2.title = "2";
        exam2.categoryQuestion = categoryQuestion2;
        exam2.duration = LocalDateTime.now();
        exam2.creatorID = 2;
        exam2.crateDate = LocalDate.now();

        Exam exam3 = new Exam();
        exam3.id = 3;
        exam3.code = "3";
        exam3.title = "3";
        exam3.categoryQuestion = categoryQuestion3;
        exam3.duration = LocalDateTime.now();
        exam3.creatorID = 3;
        exam3.crateDate = LocalDate.now();

        System.out.println("Exam title: " + exam1.title);

        // ExamQuestion
        ExamQuestion examQuestion1 = new ExamQuestion();
        examQuestion1.exam = exam1;
        examQuestion1.question = question1;

        ExamQuestion examQuestion2 = new ExamQuestion();
        examQuestion2.exam = exam2;
        examQuestion2.question = question2;

        ExamQuestion examQuestion3 = new ExamQuestion();
        examQuestion3.exam = exam3;
        examQuestion3.question = question3;

        System.out.println("ExamQuestion exam: " + examQuestion2.exam);

    }
}
