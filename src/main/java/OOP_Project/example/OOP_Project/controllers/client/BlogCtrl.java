
package OOP_Project.example.OOP_Project.controllers.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class BlogCtrl {

    @GetMapping("/blog")
    public String blog(ModelMap model) {
        model.addAttribute("pageTitle","Blog");
        return "client/blog.html";
    }
     
    
    
}
