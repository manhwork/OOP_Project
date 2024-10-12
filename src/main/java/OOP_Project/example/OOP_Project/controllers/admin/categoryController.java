package OOP_Project.example.OOP_Project.controllers.admin;

import OOP_Project.example.OOP_Project.models.categoryModel;
import OOP_Project.example.OOP_Project.services.categoryService;
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
public class categoryController {

    @Autowired
    private categoryService cateService;

    @GetMapping("/category")
    public String index(Model model) {
        List<categoryModel> records = this.cateService.getItem();
        String title = "Quản lý danh mục sản phẩm";
        model.addAttribute("title", title);
        model.addAttribute("records", records);

        return "admin/category.html";
    }

    @GetMapping("/category/add")
    public String add(Model model) {
        String title = "Thêm mới danh mục sản phẩm";
        model.addAttribute("title", title);
        model.addAttribute("category", new categoryModel());
        return "admin/categoryAdd";
    }

    @PostMapping("/category/add")
    public String addPost(@ModelAttribute("category") categoryModel category) {
        if (this.cateService.create(category)) {
            return "redirect:/admin/category";
        } else {
            return "redirect:/admin/category/add";
        }
    }

    @GetMapping("/category/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        String title = "Chỉnh sửa danh mục sản phẩm";
        model.addAttribute("title", title);
        categoryModel data = this.cateService.findById(id);
        model.addAttribute("category", data);

        return "admin/categoryEdit";
    }

    @PostMapping("/category/edit/{id}")
    public String editPost(@ModelAttribute("category") categoryModel category, @PathVariable("id") Integer id) {
        if (this.cateService.update(category)) {
            return "redirect:/admin/category";
        } else {
            return "redirect:/admin/category/edit/" + id;
        }
    }

    @PostMapping("/category/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        categoryModel category = this.cateService.findById(id);
        if (category != null) {
            category.setIs_exist(false);
            this.cateService.update(category);
        }
        return "redirect:/admin/category";
    }
}
