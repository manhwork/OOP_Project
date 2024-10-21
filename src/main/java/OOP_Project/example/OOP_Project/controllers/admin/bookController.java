package OOP_Project.example.OOP_Project.controllers.admin;

import OOP_Project.example.OOP_Project.models.bookModel;
import OOP_Project.example.OOP_Project.models.categoryModel;
import OOP_Project.example.OOP_Project.services.StorageService;
import OOP_Project.example.OOP_Project.services.bookService;
import OOP_Project.example.OOP_Project.services.categoryService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class bookController {

    @Autowired
    private bookService bookService;

    @Autowired
    private StorageService storageService;

    @Autowired
    private categoryService categoryService;

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
        List<categoryModel> categories = categoryService.getItem();
        model.addAttribute("categories", categories);
        model.addAttribute("books", new bookModel());
        return "admin/booksAdd";
    }

    @PostMapping("/books/add")
    public String addPost(@ModelAttribute("books") bookModel books, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        if (!file.isEmpty()) {
            storageService.store(file);
            books.setImage(file.getOriginalFilename());
        }
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
        List<categoryModel> categories = categoryService.getItem();
        model.addAttribute("categories", categories);

        return "admin/booksEdit";
    }

    @PostMapping("/books/edit/{id}")
    public String editPost(@ModelAttribute("books") bookModel books, @PathVariable("id") Integer id, @RequestParam("file") MultipartFile file) {
        bookModel existingBook = this.bookService.findById(id);

        if (!file.isEmpty()) {
            // Xóa ảnh cũ nếu có
            String oldImagePath = existingBook.getImage();
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
            books.setImage(file.getOriginalFilename());
        } else {
            books.setImage(existingBook.getImage());
        }

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
