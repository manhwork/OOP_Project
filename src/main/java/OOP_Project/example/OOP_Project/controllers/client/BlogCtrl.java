
package OOP_Project.example.OOP_Project.controllers.client;

import OOP_Project.example.OOP_Project.models.BlogModel;
import OOP_Project.example.OOP_Project.services.blogService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BlogCtrl {
    @Autowired
    private blogService blogService;
    
    @GetMapping("/blog")
    public String blog(ModelMap model) {
        model.addAttribute("pageTitle","Blog");
        return "client/blog/blog.html";
    }
     
    
    @GetMapping("/blog/BlogDetail/{id}")
   public String getBlogById (@PathVariable("id") Integer id, ModelMap model){
       
       BlogModel blog = blogService.getBlogById(id);
       
       //List<BlogModel> blogs = blogService.getAllBlogs();
       model.addAttribute("blog", blog);
       
       //model.addAttribute("pageTitle","Blog" + id);
       
       return "client/blog/BlogDetail"; // Đưa đến trang BlogDetail khi ấn ReadMore
   }
    
    
}
