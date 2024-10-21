package OOP_Project.example.OOP_Project.controllers.admin;

import OOP_Project.example.OOP_Project.models.authorModel;
import OOP_Project.example.OOP_Project.models.categoryModel;
import OOP_Project.example.OOP_Project.services.StorageService;
import OOP_Project.example.OOP_Project.services.authorService;
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
public class authorController {

    @Autowired
    private authorService authorService;

    @Autowired
    private StorageService storageService;

    @GetMapping("/author")
    public String index(Model model) {
        List<authorModel> records = this.authorService.getItem();
        String title = "Quản lý tác giả";
        model.addAttribute("title", title);
        model.addAttribute("records", records);

        return "admin/author.html";
    }

    @GetMapping("/author/add")
    public String add(Model model) {
        String title = "Thêm mới tác giả";
        model.addAttribute("title", title);
        model.addAttribute("author", new authorModel());
        return "admin/authorAdd";
    }

    @PostMapping("/author/add")
    public String addPost(@ModelAttribute("author") authorModel author, @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            this.storageService.store(file);
            System.out.println(file);
            author.setImage(file.getOriginalFilename());
        }
        if (this.authorService.create(author)) {
            return "redirect:/admin/author";
        } else {
            return "redirect:/admin/author/add";
        }
    }

    @GetMapping("/author/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        String title = "Chỉnh sửa tác giả";
        model.addAttribute("title", title);
        authorModel data = this.authorService.findById(id);
        model.addAttribute("author", data);

        return "admin/authorEdit";
    }

    @PostMapping("/author/edit/{id}")
    public String editPost(@ModelAttribute("author") authorModel author, @PathVariable("id") Integer id, @RequestParam("file") MultipartFile file) {
        authorModel authorExist = this.authorService.findById(id);
        if (!file.isEmpty()) {
            // Xóa ảnh cũ nếu có
            String oldImagePath = authorExist.getImage();
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
            author.setImage(file.getOriginalFilename());
        } else {
            author.setImage(authorExist.getImage());
        }
        if (this.authorService.update(author)) {
            return "redirect:/admin/author";
        } else {
            return "redirect:/admin/author/edit/" + id;
        }
    }

    @PostMapping("/author/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        authorModel author = this.authorService.findById(id);
        if (author != null) {
            author.setIs_exist(false);
            this.authorService.update(author);
        }
        return "redirect:/admin/author";
    }
}
