/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOP_Project.example.OOP_Project.controllers.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author MTQV
 */
@Controller
public class homeController {

    @GetMapping("/")
    public String index(ModelMap model) {
        model.addAttribute("pageTitle","Home");
        return "client/home";
    }
     
}
