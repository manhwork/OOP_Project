package OOP_Project.example.OOP_Project.controllers.admin;

import OOP_Project.example.OOP_Project.models.BlogModel;
import OOP_Project.example.OOP_Project.models.blogCategoryModel;
import OOP_Project.example.OOP_Project.services.StorageService;
import OOP_Project.example.OOP_Project.services.blogCateService;
import OOP_Project.example.OOP_Project.services.blogService;
import java.io.File;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.web.multipart.MultipartException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
@RequestMapping("/admin")
public class blogController {

    @Autowired
    private blogService blogService;

    @Autowired
    private StorageService storageService;

    @GetMapping("/blog")
    public String index(Model model) {
        List<BlogModel> records = this.blogService.getAllBlogs(); //Lấy danh sách các bài viết
        String title = "Quản lý bài viết";
        model.addAttribute("title", title);
        model.addAttribute("records", records);
        return "admin/blog.html"; //Trả về view quản lý BlogModel
    }

    @GetMapping("/blog/add")
    public String add(Model model) {
        String title = "Thêm mới bài viết";
        model.addAttribute("title", title);
        model.addAttribute("blog", new BlogModel()); // Tạo đối tượng BlogModel mới
        return "admin/blogAdd";// Trả về view thêm mới BlogModel
    }

    // sửa phần này
    @PostMapping("/blog/add")
    public String create(@ModelAttribute("blog") BlogModel blog, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

        if (!file.isEmpty()) {
//            storageService.store(file);
//            blog.setImage(file.getOriginalFilename());
            try {
                storageService.store(file);
                blog.setImage(file.getOriginalFilename());
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("message", "Lỗi trong quá trình lưu file: " + e.getMessage());
                //return "redirect:/admin/blog/add";
            }
        }

        if (this.blogService.saveBlog(blog) != null) { //Lưu BlogModel
            return "redirect:/admin/blog"; //Trả về trang quản lí bài viết
        } else {
            return "redirect:/admin/blog/add"; //Trả về trang thêm mới nếu thất bại
        }
    }

    // Chức năng sửa
    @GetMapping("/blog/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        String title = "Chỉnh sửa danh mục sản phẩm";
        model.addAttribute("title", title);
        BlogModel blog = this.blogService.getBlogById(id);
        if (blog == null) {
            return "redirect:/admin/blog";  // Điều hướng lại nếu blog không tồn tại
        }
        model.addAttribute("blog", blog);
        return "admin/blogEdit";
    }

    @PostMapping("/blog/edit/{id}")
    public String editPost(@ModelAttribute("blog") BlogModel blog, @PathVariable("id") Integer id, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        BlogModel existingBook = this.blogService.getBlogById(id);

        if (!file.isEmpty()) {
            // Xóa ảnh cũ nếu có
            String oldImagePath = existingBook.getImage();
            if (oldImagePath != null && !oldImagePath.isEmpty()) {
                Path oldImage = storageService.load(oldImagePath);
                try {
//                    Files.deleteIfExists(oldImage);
                    Files.deleteIfExists(storageService.load(oldImagePath));
                } catch (IOException e) {
//                    e.printStackTrace();
                    redirectAttributes.addFlashAttribute("message", "Lỗi khi xóa ảnh cũ: " + e.getMessage());
                }
            }
            // Lưu ảnh mới

//            storageService.store(file);
//            blog.setImage(file.getOriginalFilename());
//        } else {
//            blog.setImage(existingBook.getImage());
//        }
            try {
                storageService.store(file);
                blog.setImage(file.getOriginalFilename());
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("message", "Lỗi khi lưu ảnh mới: " + e.getMessage());
            }
        } else {
            blog.setImage(existingBook.getImage());
        }

        if (this.blogService.update(blog)) {
            return "redirect:/admin/blog";
        } else {
            redirectAttributes.addFlashAttribute("message", "Lỗi khi cập nhật bài viết.");
            return "redirect:/admin/blog/edit/" + id;
        }
    }

    @PostMapping("/blog/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        BlogModel blog = this.blogService.getBlogById(id);
        if (blog != null) {
            blog.setIs_exist(false);
            this.blogService.delete(blog);
        }
        return "redirect:/admin/blog";
    }

    @ExceptionHandler(MultipartException.class)
    public String handleMultipartException(MultipartException e, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "Lỗi trong quá trình upload file: " + e.getMessage());
        return "redirect:/admin/blog";  // Trả về trang blog hoặc trang lỗi
    }
}
