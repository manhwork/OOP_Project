package OOP_Project.example.OOP_Project.controllers.admin;

import OOP_Project.example.OOP_Project.models.userModel;
import OOP_Project.example.OOP_Project.services.userService;
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
public class userController {

    @Autowired
    private userService userService;

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
    public String addPost(@ModelAttribute("user") userModel user) {
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
    public String editPost(@ModelAttribute("user") userModel user, @PathVariable("id") Integer id) {
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
