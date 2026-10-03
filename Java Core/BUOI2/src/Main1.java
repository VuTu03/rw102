public class Main1 {
    public static void main(String[] args) {
        String[] hocsinh = new String[]{"A", "B", "C", "D", "E"};
        // in ra tất cả các học sinh trong ds trên
//        System.out.println(hocsinh[0]);
//        System.out.println(hocsinh[1]);
//        System.out.println(hocsinh[2]);
        // vòng lặp: xử lý 1 chuỗi hành động lặp đi lặp lại
        // index: xử lý theo vị trí của ptu trong ds
//        System.out.println("For i");
//        for (int i = 0; i <= hocsinh.length; i++){
//            System.out.println(hocsinh[i]);
//        }

       // System.out.println("For each");
        // gán lần lượt các ptu trong mảng với 1 object, sau khi xử lý xong thì với ptu tiếp theo
        // gán cho đến khi hết ds dừng vòng for
//        for (String hs : hocsinh){
//            System.out.println(hs);
//        }


        // khi nào dùng for i, khi nào dùng for each
        // khi nào cần sử dụng đến vị trí thì dùng for i
        // khi nào ko cần sử dụng đến vị trí thì dùng for each

        // tìm ra vị trí của hs có tên là "B" trong ds
//        for (int i = 0; i < hocsinh.length; i ++){
//            if (hocsinh[i] == "B"){
//                System.out.println("Cần tìm " + (i+1) +"trong danh sách");
//            }
//        }
        // ktra xem có học sinh nào có tên là G ko?
//        boolean check = false;
//        for (int i = 0; i < hocsinh.length; i ++){
//            if (hocsinh[i] == "G"){
//                check = true;
//            }
//        }
//        for (String hs: hocsinh){
//            if (hs == "G"){
//                check = true;
//            }
//        }
//        if (check = true){
//            System.out.println("Có học sinh tên G");
//        }else {
//            System.out.println("Ko có học sinh tên G");
//        }

        //1, i: vị trí các ptu trong mảng; i bắt đầu từ 0
        //2, i < hocsinh.length; nếu i >= 0 độ dài của array thì dừng vòng lặp - đkien dừng vòng lặp
        //3, i ++ <=> i = i + 1 (tăng 1 lên 1 đơn vị sau mỗi lần lặp)

        // for i: index -- lặp theo vị trí
//        for (int i=0; i < hocsinh.length; i++) {
//            System.out.println(hocsinh[i]);// in ra gtri của vtri tương ứng
//        }
        // in ra từ 1 -10
//        for (int i = 1; i <= 10; i ++){
//            System.out.println(i);
//        }
        // in ra 10 - 1
//        System.out.println("For"); // với lần lặp có thể biết trc
//        for (int i = 10; i >= 1; i--){ // lặp 10 lần
//            System.out.println(i);
//        }

        // vòng lặp, for làm đc thì while cũng làm đc
        System.out.println("While");
        int i = 1;
        while (i <= 10){// check đkien nếu thoả mãn thì mới thực thi
            System.out.println(i);
            i++;
        }
        System.out.println("Do-While");// lặp với số lần chưa bt trc
        int j = 5;
        do {// thực thi 1 lần trc rồi mới check đkien
            System.out.println(j);
            j++;
        } while (j <= 10);

    }
}