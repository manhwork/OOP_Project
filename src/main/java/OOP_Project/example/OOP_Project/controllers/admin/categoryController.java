/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOP_Project.example.OOP_Project.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author admin
 */
@Controller
public class categoryController {

    @GetMapping("/admin/category")
    public String index() {
        return "admin/category.html";
    }

    @GetMapping("/admin/category/add")
    public String add() {
        return "admin/categoryAdd";
    }
}
