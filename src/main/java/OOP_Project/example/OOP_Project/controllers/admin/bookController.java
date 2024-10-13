package OOP_Project.example.OOP_Project.controllers.admin;

import OOP_Project.example.OOP_Project.models.bookModel;
import OOP_Project.example.OOP_Project.services.bookService;
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
public class bookController {

    @Autowired
    private bookService bookService;

    @GetMapping("/books")
    public String index(Model model) {
        List<bookModel> records = this.bookService.getItem();
        String title = "Quản lý danh mục sản phẩm";
        model.addAttribute("title", title);
        model.addAttribute("records", records);

        return "admin/books.html";
    }

    @GetMapping("/books/add")
    public String add(Model model) {
        String title = "Thêm mới danh mục sản phẩm";
        model.addAttribute("title", title);
        model.addAttribute("books", new bookModel());
        return "admin/booksAdd";
    }

    @PostMapping("/books/add")
    public String addPost(@ModelAttribute("books") bookModel books) {
        if (this.bookService.create(books)) {
            return "redirect:/admin/books";
        } else {
            return "redirect:/admin/books/add";
        }
    }

    @GetMapping("/books/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        String title = "Chỉnh sửa danh mục sản phẩm";
        model.addAttribute("title", title);
        bookModel data = this.bookService.findById(id);
        model.addAttribute("books", data);

        return "admin/booksEdit";
    }

    @PostMapping("/books/edit/{id}")
    public String editPost(@ModelAttribute("books") bookModel books, @PathVariable("id") Integer id) {
        if (this.bookService.update(books)) {
            return "redirect:/admin/books";
        } else {
            return "redirect:/admin/books/edit/" + id;
        }
    }

    @PostMapping("/books/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        bookModel books = this.bookService.findById(id);
        if (books != null) {
            books.setIs_exist(false);
            this.bookService.update(books);
        }
        return "redirect:/admin/books";
    }
}
