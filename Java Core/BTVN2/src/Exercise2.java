import java.time.LocalDateTime;
import java.util.logging.SimpleFormatter;

public class Exercise2 {
    public static void question1(){
        int number = 5;
        System.out.printf("%d\n",  + number);
    }
    public static void question2(){
        int number = 100000000;
        System.out.printf("%,d\n", + number);
    }
    public static void question3(){
        double number = 5.567098;
        System.out.printf("%.4f\n", + number);
    }
    public static void question4(){
        String name = "Nguyễn Văn A";
        System.out.println("Họ và tên: " + name + " và tôi đang độc thân ");
    }
    public static void question5(){
        String pattern = "dd/MM/yyyy";
        LocalDateTime localDateTime = LocalDateTime.now();
    }
}
