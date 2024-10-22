package OOP_Project.example.OOP_Project.controllers.admin;

import OOP_Project.example.OOP_Project.models.categoryModel;
import OOP_Project.example.OOP_Project.services.StorageService;
import OOP_Project.example.OOP_Project.services.categoryService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin")
public class categoryController {

    @Autowired
    private categoryService cateService;

    @Autowired
    private StorageService storageService;

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
    public String addPost(@ModelAttribute("category") categoryModel category, @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            this.storageService.store(file);
            System.out.println(file);
            category.setImage(file.getOriginalFilename());
        }
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
    public String editPost(@ModelAttribute("category") categoryModel category, @PathVariable("id") Integer id, @RequestParam("file") MultipartFile file) {
        categoryModel cateExist = this.cateService.findById(id);
        if (!file.isEmpty()) {
            // Xóa ảnh cũ nếu có
            String oldImagePath = cateExist.getImage();
            if (oldImagePath != null && !oldImagePath.isEmpty()) {
                Path oldImage = storageService.load(oldImagePath);
                try {
                    Files.deleteIfExists(oldImage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // Lưu ảnh mới
            storageService.store(file);
            category.setImage(file.getOriginalFilename());
        } else {
            category.setImage(cateExist.getImage());
        }
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
