public class Main {
    public static void main(String[] args) {
//        double diem = 5;
//         nếu điểm > 8 thì giỏi
//         nếu >=6 thì khá
//         nếu >=5 thì trung bình
//         dưới 5 thì yếu
//        if (diem >= 8){
//            System.out.println("Giỏi");
//        } else if (diem >= 6) { // sql: AND     java: &&
//            System.out.println("Khá");
//        } else if (diem >= 5) {
//            System.out.println("Trung bình");
//        }else {
//            System.out.println("Yếu");
//        }


        // nếu điểm >= 5 thì in ra qua môn
        // nếu <=5 thì tạch
//        if (diem >=5){ // nếu điểm >=5 thì
//            System.out.println("Qua môn"); // in ra qua môn
//        }else{ // ngược lại
//            System.out.println("Tạch"); // in ra tạch
//        }

        //if (đkien){
        //      thực thi nếu đkien đúng
        //}else{
        //      thực hiện nếu đkien sai
        //}

        //int number = 3;
        // = là phép gán giá trị
        // == là so sánh
        // nếu number = 0 thì in ra không
        // nếu = 1 thì in ra một
        // nếu = 2 thì in ra hai
        // nếu = 3 thì in ra ba
        // các trường hợp còn lại thì in ra ko xác định
        // ==== bài này dùng đc if-else với switch-case
//        if (number == 0){
//            System.out.println("Không");
//        } else if (number == 1) {
//            System.out.println("Một");
//        } else if (number == 2) {
//            System.out.println("Hai");
//        } else if (number == 3) {
//            System.out.println("Ba");
//        }else {
//            System.out.println("Ko xác định");
//        } // so sánh n lần tuỳ cấu trức if else

        // dùng switch - case
        // sẽ so sánh giá trị trong switch với các giá trị ở các case, bằng gtri case nào thì sẽ xử lý theo case đó
        // ko thoả mãn case nào thì rơi vào default
//        switch (number){ // so sánh 1 lần
//            case 0:
//                System.out.println("Không");
//                break;
//            case 1:
//                System.out.println("Một");
//                break;
//            case 2:
//                System.out.println("Hai");
//                break;
//            case 3:
//                System.out.println("Ba");
//                break;
//            default:
//                System.out.println("Không xác định");
//            }
            // java 17
        // 1 bài toán dùng đc if else thì chưa chắc dùng đc switch-case

        // 1 bài toàn dùng đc switch-case thì dùng đc if-else

        // nếu number < 0 thì in ra đây là số âm
        // nếu < 10 thì in ra đây là 1 số dương nhỏ hơn 10
        // nếu > 10 thì in ra đây là 1 số  lớn hơn 10
//        if (number < 0){
//            System.out.println("Đây là số âm");
//        } else if (number < 10) {
//            System.out.println("số dương nhỏ hơn 10");
//        }else {
//            System.out.println("số lớn hơn 10");
//        }
        // bài này switch-case ko dùng đc, so sánh giá trị ở switch và ở case là so sánh == , ko so sánh đc >, < , >= , <=
        // cùng 1 bài dùng đc if-else, dùng đc switch-case thì dùng cách nào? tại sao

        // tuỳ từng trường hợp: nếu có hơn 1 giá trị so sánh thì dùng switch-case
        // nếu chỉ có 1 giá trị so sánh thì dùng cái nào cũng đc (nên dùng if-else)
        //System.out.println(number == 0 ? "Không" : "Không xác định"); // toán tử tenary(JS toán tử 3 ngôi) - Cách viết khác của if else
                            //đkien    ?   TH ĐÚNG   :   TH SAI
    }


    }
