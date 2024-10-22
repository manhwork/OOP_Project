
package OOP_Project.example.OOP_Project.controllers.admin;

import OOP_Project.example.OOP_Project.models.BlogModel;
import OOP_Project.example.OOP_Project.services.blogService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/api/blogs")
public class BlogApiController {
    @Autowired
    private blogService blogService;

    // Lấy danh sách tất cả các blog
    @GetMapping
    public ResponseEntity<List<BlogModel>> getAllBlogs() {
        List<BlogModel> blogs = blogService.getAllBlogs();
        if (blogs.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(blogs);
    }

    // Lấy blog theo ID
    @GetMapping("/{id}")
    public ResponseEntity<BlogModel> getBlogById(@PathVariable Integer id) {
        BlogModel blog = blogService.getBlogById(id);
        if (blog != null) {
            return ResponseEntity.ok(blog);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Tạo mới blog
    @PostMapping
    public ResponseEntity<BlogModel> createBlog(@RequestBody BlogModel blog) {
        try {
            BlogModel createdBlog = blogService.saveBlog(blog);
            return ResponseEntity.ok(createdBlog);
        } catch (Exception e) {
            return ResponseEntity.status(500).build(); // Phản hồi lỗi nếu không tạo được blog
        }
    }

    // Cập nhật blog theo ID
    @PutMapping("/{id}")
    public ResponseEntity<BlogModel> updateBlog(@PathVariable Integer id, @RequestBody BlogModel blogDetails) {
        BlogModel existingBlog = blogService.getBlogById(id);
        if (existingBlog != null) {
            existingBlog.setTitle(blogDetails.getTitle());
            //existingBlog.setContent(blogDetails.getContent());
            existingBlog.setImage(blogDetails.getImage());
            // Cập nhật các trường khác nếu cần
            blogService.update(existingBlog);
            return ResponseEntity.ok(existingBlog);
        } else {
            return ResponseEntity.notFound().build(); // Phản hồi lỗi nếu không tìm thấy blog
        }
    }

    // Xóa blog theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable Integer id) {
        BlogModel existingBlog = blogService.getBlogById(id);
        if (existingBlog != null) {
            blogService.delete(existingBlog);
            return ResponseEntity.ok().build(); // Phản hồi thành công khi đã xóa blog
        } else {
            return ResponseEntity.notFound().build(); // Phản hồi lỗi nếu không tìm thấy blog
        }
    }

}
