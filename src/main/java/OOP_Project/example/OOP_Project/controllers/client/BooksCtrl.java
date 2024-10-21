
package OOP_Project.example.OOP_Project.controllers.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BooksCtrl {

    @GetMapping("/books")
    public String book(ModelMap model) {
        model.addAttribute("pageTitle","Books");
        return "client/books.html";
    }
     
    
    
}
