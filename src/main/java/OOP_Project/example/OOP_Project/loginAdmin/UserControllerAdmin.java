package OOP_Project.example.OOP_Project.loginAdmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserControllerAdmin {
    @RequestMapping("/logon")
    public String logon(){
        return "admin/logon";
    }
}
