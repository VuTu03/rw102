import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Main {
    public enum Gioitinh{
        NAM, NU, KHAC
    }
    public static void main(String[] args) {
       //biến SET @min INT
        int min = 0;
        // varchar       String
        String fullname = "Vũ Văn Tú";//varchar: chứa bao nhiêu kí tự cũng đc
        char gender = 'M';// chỉ chứa đc 1 kí tự
        int age = 23;// int
        long a = 1;
        short b = 1;
        byte c = 1;
        float point = 7f;// float
        double d = 7;
        LocalDate birthday = LocalDate.of(2003,07,07);
        LocalDateTime date1 = LocalDateTime.now();
        Date date = new Date();
        Gender gender1 = Gender.MALE;


        System.out.println("Fullname: " + fullname);
        System.out.println("Age: " + age);
        System.out.println("Point: " + point);
        System.out.println("Birthday: " + birthday);
        System.out.println("Day: " + date);
        System.out.println("Datetime: " + date1);
        System.out.println("Gender: " + gender1);

        //arrays: khi muốn biểu diễn 1 danh sách chứa các ptu kiểu dữ liệu
        // số nguyên int... thêm [] này là thành arrays
        //ds điểm
        int[] points = new int[]{9,8,7,6};
        int[] point2 = new int[4];// ds này chỉ có 4 ptu
        point2[0] = 9;
        point2[1] = 8;
        point2[2] = 7;
        point2[3] = 6;
        // vd: 1 học sinh có điểm các môn lần lượt là 10, 9, 8.5, 7.1 - Như này khi có nhiều điểm thì làm sẽ quá dài
        double p1 = 10;
        double p2 = 9;
        double p3 = 8.5;
        double p4 = 7.1;
        // 30 điểm thì phải khai báo 30 lần: như này sẽ ngắn gọn và nhanh hơn
        double[] diem = new double[]{10, 9, 8.5, 7.1};
        //Thêm danh sách các học sinh
        String[] hocsinh = new String[]{"An", "Duong", "Linh"};
        // kiểu đúng sai
        boolean check = false;
        boolean check1 = true;

        // so sánh
        boolean check2 = 1 > 2;
        System.out.println("check: " + check2);

    }
}