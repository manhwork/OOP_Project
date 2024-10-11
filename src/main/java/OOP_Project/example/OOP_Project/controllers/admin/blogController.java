
package OOP_Project.example.OOP_Project.controllers.admin;

import OOP_Project.example.OOP_Project.models.BlogModel;
import OOP_Project.example.OOP_Project.services.blogService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class blogController {
    @Autowired
    private blogService blogService;
    
    @GetMapping("/blog")
    public String index(Model model){
        List<BlogModel> records = this.blogService.getAllBlogs(); //Lấy danh sách các bài viết
        String title = "Quản lý bài viết";
        model.addAttribute("title",title);
        model.addAttribute("records",records);
        return "admin/blog.html"; //Trả về view quản lý BlogModel
    }
    
    
    
    @GetMapping("/blog/add")
    public String add(Model model){
        String title = "Thêm mới bài viết";
        model.addAttribute("title",title);
        model.addAttribute("blog", new BlogModel()); // Tạo đối tượng BlogModel mới
        return "admin/blogAdd";// Trả về view thêm mới BlogModel
    }
    
    
    @PostMapping("/blog/add")
    public String create(@ModelAttribute("blog") BlogModel blog){
        if(this.blogService.saveBlog(blog) != null){ //Lưu BlogModel
            return "redirect:/admin/blog"; //Trả về trang quản lí bài viết
        }
        else{
            return "redirect:/admin/blog/add"; //Trả về trang thêm mới nếu thất bại
        }
    }
}
