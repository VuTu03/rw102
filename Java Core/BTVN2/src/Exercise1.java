public class Exercise1 {
    public static void question1 (Account account){
        // IF
        if (account.department == null){
            System.out.println("Nhân viên này chưa có phòng ban");
        }else {
            System.out.println("Phòng ban của nhân viên này là: " + account.department.name);
        }
    }
    public static void question2 (Account account){

    }

    public static void question3 (Account account){
        System.out.println(account.department == null ? "Nhân viên này chưa có phòng ban" : "Phòng ban của nhân viên này là: " + account.department.name);
    }

    public static void question4 (Account account){
            System.out.println(account.position.name.toString() == "Dev" ? "Đây là Developer" : "Người này không phải là Developer");
    }
    // SWITCH CASE
    public static void question5 (Group group){
        if (group.creator == null){
            System.out.println();

        }
    }
}
