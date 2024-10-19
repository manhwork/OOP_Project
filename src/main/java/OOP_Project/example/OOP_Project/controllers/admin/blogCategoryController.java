
package OOP_Project.example.OOP_Project.controllers.admin;

import OOP_Project.example.OOP_Project.models.blogCategoryModel;
import OOP_Project.example.OOP_Project.services.blogCateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class blogCategoryController {
    @Autowired
    private blogCateService blogCateService;
    
    @GetMapping("/blogCategory")
    public String index(Model model){
        List<blogCategoryModel> records = this.blogCateService.getAllblogCategories();
        String title = "Quản lý danh mục bài viết";
        model.addAttribute("title",title);
        model.addAttribute("records",records);
        
        return "admin/blogCategory.html";
    }
    @GetMapping("/blogCategory/add")
    public String add(Model model){
        String title = "Thêm mới danh mục sản phẩm";
        model.addAttribute("title",title);
        model.addAttribute("blogCategory", new blogCategoryModel());
        return "admin/blogCategoryAdd";
    }
    
    @PostMapping("/blogCategory/add")
    public String create(@ModelAttribute("blogCategory") blogCategoryModel blogCategory){
        if (this.blogCateService.saveblogCategory(blogCategory) != null) { 
            return "redirect:/admin/blogCategory"; 
        } else {
            return "redirect:/admin/blogCategory/add"; // Redirect về trang thêm mới nếu thất bại
        }
    }
    // Chức năng sửa
    @GetMapping("/blogCategory/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id){
        String title = "Chỉnh sửa danh mục sản phẩm";
        model.addAttribute("title",title);
        blogCategoryModel data = this.blogCateService.getblogCategoryById(id);
        if (data == null) {
        return "redirect:/admin/blogCategory";  
        }
        model.addAttribute("blogCategory",data);
        return "admin/blogCateEdit";
    }
    
    @PostMapping("/blogCategory/edit/{id}")
    public String editPost(@ModelAttribute("blogCategory") blogCategoryModel blogCategory, @PathVariable("id") Integer id){
        if (this.blogCateService.update(blogCategory)){
            return "redirect:/admin/blogCategory";
        }else{
            return "redirect:/admin/blogCategory/edit/" + id;
        }
    }
    
 
    @PostMapping("/blogCategory/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        blogCategoryModel blogCategory = this.blogCateService.getblogCategoryById(id);
        if (blogCategory != null) {
            blogCategory.setIs_exist(false);
            this.blogCateService.delete(blogCategory);
        }
        return "redirect:/admin/blogCategory";
    }

}
