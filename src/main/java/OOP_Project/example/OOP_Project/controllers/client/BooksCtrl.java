package OOP_Project.example.OOP_Project.controllers.client;

import OOP_Project.example.OOP_Project.models.bookModel;
import OOP_Project.example.OOP_Project.services.bookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class BooksCtrl {

    @Autowired
    private bookService bookService;

    @GetMapping("/books")
    public String book(ModelMap model) {
        String pageTitle = "Books";
        model.addAttribute("pageTitle", pageTitle);
        List<bookModel> records = this.bookService.getItem();
        model.addAttribute("records", records);
        model.addAttribute("pageTitle", "Books");
        List<bookModel> booksNew = this.bookService.getNewProduct();
        model.addAttribute("booksNew", booksNew);
        return "client/books.html";
    }

    @GetMapping("/books/{slug}")
    public String detail(ModelMap model, @PathVariable("slug") String slug) {
        bookModel book = this.bookService.getItemSlug(slug);
        model.addAttribute("book", book);
        String pageTitle = book.getSlug();
        model.addAttribute("pageTitle", pageTitle);
        return "client/detailBook";
    }

    @GetMapping("/books/search")
    public String search(ModelMap model, @RequestParam("keyword") String keyword) {
        if (keyword != null) {
            List<bookModel> books = this.bookService.search(keyword);
            model.addAttribute("records", books);
            model.addAttribute("keyword", keyword);
            return "client/searchBook";
        } else {
            return "redirect:/books";
        }
    }
}
