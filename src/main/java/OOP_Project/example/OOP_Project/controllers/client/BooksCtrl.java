package OOP_Project.example.OOP_Project.controllers.client;

import OOP_Project.example.OOP_Project.models.bookModel;
import OOP_Project.example.OOP_Project.services.bookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BooksCtrl {

    @Autowired
    private bookService bookService;

    @GetMapping("/books")
    public String book(ModelMap model) {
        List<bookModel> records = this.bookService.getItem();
        model.addAttribute("records", records);
        model.addAttribute("pageTitle", "Books");
        return "client/books.html";
    }

}
