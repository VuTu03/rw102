import java.time.LocalDate;

public class Person {
    int id;// auto_incerment
    String name;
    Gender gender;// enum
    LocalDate birthday;
    String cccd;
    boolean isPassCourse;
    int[] point;// ds điểm - trong sql ko có arrays

    //Phương thức: hành động của đối tượng - giống procedure
    void an(){
        System.out.println("Person đang ăn");
    }
    void ngu(){
        System.out.println("Person đang ngủ");
    }
    void inThongTin(){
        System.out.println("Id: "+id);
        System.out.println("Name: "+name);
        System.out.println("Gender: "+gender);
        System.out.println("Birthday: "+birthday);
        System.out.println("Cccd: "+cccd);
        System.out.println("Point: "+point);
    }
}
