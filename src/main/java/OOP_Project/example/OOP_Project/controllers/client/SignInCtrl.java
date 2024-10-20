
package OOP_Project.example.OOP_Project.controllers.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class SignInCtrl {

    @GetMapping("/login")
    public String AA(ModelMap model) {
        model.addAttribute("pageTitle","Sign in");
        return "client/login.html";
    }
     
    
    
}
