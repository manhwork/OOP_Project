/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOP_Project.example.OOP_Project.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author MTQV
 */
@Controller

public class adminController {

    @GetMapping("/admin/dashboard")
    public String index(Model model) {
        String title = "Trang quản trị";
        model.addAttribute("title", title);
        return "admin/dashboard.html";
    }
}
