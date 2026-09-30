import java.time.LocalDate;

public class Account {
    int id;
    String username;
    String fullname;
    String email;
    // department_id và position_id   Khoá ngoại
    // với khoá ngoại thì sẽ chuyển thành object
    Department department;
    Position position;
    LocalDate createDate;
}
