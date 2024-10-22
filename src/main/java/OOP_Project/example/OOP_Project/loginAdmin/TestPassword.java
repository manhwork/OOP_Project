package OOP_Project.example.OOP_Project.loginAdmin;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// lấy mã hóa mật khẩu cho csdl
public class TestPassword {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("12345"));
    }
}
