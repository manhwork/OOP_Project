
package OOP_Project.example.OOP_Project.controllers.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AboutAuthorCtrl {

    @GetMapping("/about_author")
    public String AA(ModelMap model) {
        model.addAttribute("pageTitle","About Author");
        return "client/about_author.html";
    }
     
    
    
}
