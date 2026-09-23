public class Exercise5 {
    public static void main(String[] args) {
        //Question 5: So sánh 2 phòng ban thứ 1 và phòng ban thứ 2 xem có bằng nhau không (bằng nhau khi tên của 2 phòng ban đó bằng nhau)
        public static void question5(Department department1, Department department2) {
            if (department1.equals(department2)) {
                System.out.println("Có bằng nhau !");
            } else {
                System.out.println("Không bằng nhau !");
            }
        }



        //Question 6: Khởi tạo 1 array phòng ban gồm 5 phòng ban, sau đó in ra danh sách phòng ban theo thứ tự tăng dần theo tên (sắp xếp theo vần ABCD) VD:
        //Accounting
        //Boss of director
        //Marketing
        //Sale
        //Waiting room
        public static void question6(Department[] departments) {
            for (int i = 0; i < departments.length; i++) {
                for (int j = 0; j < departments.length - 1; j++) {
                    if (departments[i].name.compareToIgnoreCase(departments[j].name) < 0) {
                        Department temp = departments[i];
                        departments[i] = departments[j];
                        departments[j] = temp;
                    }
                }
            }





            //Question 7: Khởi tạo 1 array học sinh gồm 5 Phòng ban, sau đó in ra danh sách phòng ban được sắp xếp theo tên VD:
        //Accounting
        //Boss of director
        //Marketing waiting room
        //Sale
            public static void question7(Department[] departments) {
                for (int i = 0; i < departments.length; i++) {
                    String reverseNameDepartment = reverseWords(departments[i].name);
                    for (int j = 0; j < departments.length - 1; j++) {
                        String reverseNameComparingDepartment = reverseWords(departments[j].name);
                        if (reverseNameDepartment.compareToIgnoreCase(reverseNameComparingDepartment) < 0) {
                        Department temp = departments[i];
                        departments[i] = departments[j];
                        departments[j] = temp;
                    }
                    }
                }
                for (Department department : departments) {
                    System.out.println(department);
                }
            }
            private static String reverseWords(String str) {
                str = str.trim();
                str = str.replaceAll("\\s+", " ");
                String[] words = str.split(" ");
                str = "";
                for (int i = words.length - 1; i >= 0; i--) {
                    str += words[i] + " ";
                }
                return str.substring(0, str.length() - 2);
            }


        }
}
