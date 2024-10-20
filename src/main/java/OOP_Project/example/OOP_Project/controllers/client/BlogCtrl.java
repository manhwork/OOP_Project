
package OOP_Project.example.OOP_Project.controllers.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BlogCtrl {

    @GetMapping("/blog")
    public String blog(ModelMap model) {
        model.addAttribute("pageTitle","Blog");
        return "client/blog/blog.html";
    }
     
    @GetMapping("/blog/Blog1")
    public String getBlog1(){
        return "client/blog/Blog1";
    }
    
    @GetMapping("/blog/Blog2")
    public String getBlog2(){
        return "client/blog/Blog2";
    }
    
    @GetMapping("/blog/Blog3")
    public String getBlog3(){
        return "client/blog/Blog3";
    }
    
}
