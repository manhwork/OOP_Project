package OOP_Project.example.OOP_Project.controllers.admin;

import OOP_Project.example.OOP_Project.models.categoryModel;
import OOP_Project.example.OOP_Project.models.userModel;
import OOP_Project.example.OOP_Project.services.StorageService;
import OOP_Project.example.OOP_Project.services.userService;
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
public class userController {

    @Autowired
    private userService userService;

    @Autowired
    private StorageService storageService;

    @GetMapping("/user")
    public String index(Model model) {
        List<userModel> records = this.userService.getItem();
        String title = "Quản lý người dùng";
        model.addAttribute("title", title);
        model.addAttribute("records", records);

        return "admin/user.html";
    }

    @GetMapping("/user/add")
    public String add(Model model) {
        String title = "Thêm mới người dùng";
        model.addAttribute("title", title);
        model.addAttribute("user", new userModel());
        return "admin/userAdd";
    }

    @PostMapping("/user/add")
    public String addPost(@ModelAttribute("user") userModel user, @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            this.storageService.store(file);
            System.out.println(file);
            user.setImage(file.getOriginalFilename());
        }
        if (this.userService.create(user)) {
            return "redirect:/admin/user";
        } else {
            return "redirect:/admin/user/add";
        }
    }

    @GetMapping("/user/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        String title = "Chỉnh sửa người dùng";
        model.addAttribute("title", title);
        userModel data = this.userService.findById(id);
        model.addAttribute("user", data);

        return "admin/userEdit";
    }

    @PostMapping("/user/edit/{id}")
    public String editPost(@ModelAttribute("user") userModel user, @PathVariable("id") Integer id, @RequestParam("file") MultipartFile file) {
        userModel userExist = this.userService.findById(id);
        if (!file.isEmpty()) {
            // Xóa ảnh cũ nếu có
            String oldImagePath = userExist.getImage();
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
            user.setImage(file.getOriginalFilename());
        } else {
            user.setImage(userExist.getImage());
        }
        if (this.userService.update(user)) {
            return "redirect:/admin/user";
        } else {
            return "redirect:/admin/user/edit/" + id;
        }
    }

    @PostMapping("/user/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        userModel user = this.userService.findById(id);
        if (user != null) {
            user.setIs_exist(false);
            this.userService.update(user);
        }
        return "redirect:/admin/user";
    }
}
