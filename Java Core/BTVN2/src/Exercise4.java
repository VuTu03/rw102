import java.time.LocalDate;
import java.util.Random;

public class Exercise4 {
    Random random = new Random();
        public static void question1() {
            int a = new  Random().nextInt();
            System.out.println(a);
        }
    public static void question2(){
        double a = new Random().nextDouble();
        System.out.println(a);
    }
    public static void question3(){
            String[] ten = {"An","Hiêp","Hoài","Đức","Loan"};
            int vitri = new Random().nextInt(ten.length);
        System.out.println("Tên ngẫu nhiên: " + ten[vitri]);
    }
    public static void question4() {
        LocalDate startDate = LocalDate.of(1995, 7, 24);
        LocalDate endDate = LocalDate.of(1995, 12, 20);
        long start = startDate.toEpochDay();
        long end = endDate.toEpochDay();
        long randomDay = start + new Random().nextLong() % (end - start + 1);
        System.out.println("Ngày ngẫu nhiên: " + LocalDate.ofEpochDay(randomDay));
    }
    public static void question5(){
            LocalDate endDay = LocalDate.now();
            LocalDate startDay = endDay.minusDays(1);
            long start = startDay.toEpochDay();
            long end = endDay.toEpochDay();
        long randomDay = start + new Random().nextLong() % (end - start + 1);
        System.out.println("Ngày ngẫu nhiên: " + LocalDate.ofEpochDay(randomDay));
    }

}
