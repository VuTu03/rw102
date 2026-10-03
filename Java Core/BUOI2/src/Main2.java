import java.util.Random;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
//        // dùng for để in từ 1 - 10
//        for (int i = 1; i <= 10; i++ ){
//            System.out.println("i = " + i);
//        }
        Department department1 = new Department();
        department1.id = 1;
        department1.name = "Sale";

        Department department2 = new Department();
        department2.id = 2;
        department2.name = "Marketing";

        Department department3 = new Department();
        department3.id = 3;
        department3.name = "Bảo vệ";

        Department department4 = new Department();
        department4.id = 4;
        department4.name = "ABC";

        Department department5 = new Department();
        department5.id = 5;
        department5.name = "XYZ";

        Department department6 = new Department();
        department6.id = 6;
        department6.name = "HBC";

        Department[] departments = {department1, department2, department3, department4, department5, department6};

        // continue: bỏ qua lần lặp hiện tại và chuyển qua lần lặp tiếp theo mà ko làm các hành động khác, tăng i lên 1 đơn vị
        // break: dừng luôn vòng lặp tại ví trí break, và vẫn chạy các câu lệnh khác của method
        // return: dừng luôn method
        // ko in ra gtri < 5
//        for (int i = 1; i <= 10; i ++){ // for chạy từ 1 - 10 trong 10s
//            if (i < 5){
//                System.out.println(i);
//            }
//        }
//        for (int i = 1; i <= 10; i ++) { // for chỉ chạy từ 1 - 5 trong 5s
//            if (i >= 5) {
//                break;
//            }
//            System.out.println(i);
//        }
//        System.out.println("Hello");
//
//        // in ra gtri 5 thì dừng luôn method
//        for (int i = 1; i <= 10; i ++) {
//            if (i == 5) {
//                return;
//            }
//            System.out.println(i);
//        }
        // i++ : tăng i lên 1 đơn vị
        // ++i : cũng tăng lên 1 đơn vị
        // nếu ++ đứng sau biến thì thứ tự thực hiện: gán rồi mới tăng
        // nếu ++ đứng trước biến thì thứ tự thực hiện: tăng rồi mới gán
//        int a = 1; // gán gtri 1 vào cho a
//        //int b = a++;// 2 hàng động: 1.gán    2.tăng gtri
//        int b = a++; // gán 1
//        a = a + 1; // tăng 2
//        System.out.println("a = " + a);
//        System.out.println("b = " + b);


//        int x = 1;
//        // int y = ++x;//2 hành động: 1.gán  2. tăng giá trị
//        x = x + 1; // 2
//        int y = x; // 2
//        System.out.println("x = " + x);
//        System.out.println("y = " + y);

//        System.out.println("Hello");// line: in xong thì xuống dòng
//
//        Random random = new Random();// random số
        // random ngẫu nhiên
//        int x = random.nextInt();
//        System.out.println(x);
//        // random từ 0-10
//        int y = random.nextInt(11);
//        System.out.println(y);
//        // random từ 10-20
//        int z = random.nextInt(10,21);
//        System.out.println(z);

//        String name = "Nam"; // fix cứng
//        System.out.println(name);
        // nhập dữ liệu từ bàn phím
        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhập dữ liệu từ bàn phím: ");
//        String name = sc.nextLine(); // sc.nextLine(): nhận dữ liệu nhập tù bàn phím
//        System.out.println("Tên bạn muốn nhập là: " +name);


        System.out.println("Nhập tuổi: ");
        while (true){
            if (sc.hasNextInt() == true){ // ktra dữ liệu nhập vào có phải số nguyên ko
                 int age = sc.nextInt();
                System.out.println("Tuổi bạn vừa nhập là: "+ age);
            }else {
                System.out.println("Nhập sai định dạng. Nhập lại: ");
            }
            sc.nextLine();
        }


    }
}
