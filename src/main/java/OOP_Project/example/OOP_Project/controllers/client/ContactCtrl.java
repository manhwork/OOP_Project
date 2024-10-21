
package OOP_Project.example.OOP_Project.controllers.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ContactCtrl {

    @GetMapping("/contact")
    public String contact(ModelMap model) {
        model.addAttribute("pageTitle","Contact");
        return "client/contact.html";
    }
     
    
    
}
