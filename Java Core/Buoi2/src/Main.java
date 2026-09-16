public class Main {
    public static void main(String[] args) {
       double diem = 7;
        // nếu điểm >= 8 thì in ra giỏi
        // nếu >= 6 và < 8 thì in ra khá
        // nếu >= 5 và < 6 thì in ra trung bình
        // dưới 5 thì yếu
        if (diem >=8){
            System.out.println("Giỏi");
        } else if (diem >= 6) { // sql: AND   Java: &&
            System.out.println("Khá");
        } else if (diem >= 5) {
            System.out.println("Trung bình");
        }else {
            System.out.println("Yếu");
        }

//              if (diem >= 5){//nếu điểm >= 5 thì in ra qua môn
//           System.out.println("Qua"); // in ra qua môn
//       }
//       else {// ngược lại
//          System.out.println("Trượt");// in ra trượt
//      }
        // if (Đkien){
        //  thực thi nếu đk đúng
        // }eles{
        //  thực thi nếu đk sai
        // }
        
    }
}