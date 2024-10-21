/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOP_Project.example.OOP_Project.controllers.client;

import OOP_Project.example.OOP_Project.models.bookModel;
import OOP_Project.example.OOP_Project.services.bookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author MTQV
 */
@Controller

public class homeController {

    @Autowired
    private bookService bookService;

    @GetMapping("/")
    public String home(ModelMap model) {
        List<bookModel> books = this.bookService.getItemOS();
        model.addAttribute("books", books);
        model.addAttribute("pageTitle", "Home");
        return "client/home.html";
    }

}
