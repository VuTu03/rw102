import java.util.Scanner;

public class Exercise5 {
    public static void question1(){
        Scanner scanner = new Scanner(System.in);
        int n1;
        int n2;
        int n3;
        System.out.println("Nhập số nguyên thứ 1: ");
        while (true){
            if (!scanner.hasNextInt()){
                System.out.println("Vui lòng nhập số nguyên!");
                scanner.nextLine();
                continue;
            }
            n1 = scanner.nextInt();
            scanner.nextLine();
            break;
        }
        System.out.println("Nhập số nguyên thứ 2: ");
        while (true){
            if (!scanner.hasNextInt()){
                System.out.println("Vui lòng nhập số nguyên!");
                scanner.nextLine();
                continue;
            }
            n2 = scanner.nextInt();
            scanner.nextLine();
            break;
        }
        System.out.println("Nhập số nguyên thứ 3: ");
        while (true){
            if (!scanner.hasNextInt()){
                System.out.println("Vui lòng nhập số nguyên!");
                scanner.nextLine();
                continue;
            }
            n3 = scanner.nextInt();
            scanner.nextLine();
            break;
        }
        System.out.printf("Ba số vừa nhập là: %d, %d, %d", n1, n2, n3);
    }
    public static void question2(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số thực thứ 1: ");
        double number = scanner.nextDouble();
        System.out.println("Nhập số thực thứ 2: ");
        double number1 = scanner.nextDouble();
        System.out.println("Số thực vừa nhập là: " + number + ", " + number1);

    }
}
