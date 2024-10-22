
package OOP_Project.example.OOP_Project.controllers.client;

import OOP_Project.example.OOP_Project.models.BlogModel;
import OOP_Project.example.OOP_Project.services.blogService;
import java.awt.print.Pageable;
import java.util.Comparator;
import java.util.List;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        List<BlogModel> blogs = blogService.getAllBlogs();
        blogs.sort(Comparator.comparing(BlogModel::getCreateAt).reversed()); // Sắp xếp ngày tạo để các sản phẩm thêm sau sẽ hiện lên trước
        model.addAttribute("blogs", blogs);
        model.addAttribute("pageTitle","Blog");
        return "client/blog/blog.html";
    }
     
    
    @GetMapping("/blog/BlogDetail/{slug}")
   public String getBlogById (@PathVariable("slug") String slug, ModelMap model){
       
       BlogModel blog = this.blogService.getItemSlug(slug);
       
       model.addAttribute("blog", blog);
       String pageTitle = blog.getSlug();
       model.addAttribute("pageTitle","Blog");
       
       return "client/blog/BlogDetail"; // Đưa đến trang BlogDetail khi ấn ReadMore
   }
    
    
   
   
}
