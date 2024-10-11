
package OOP_Project.example.OOP_Project.services.implement;
import org.springframework.beans.factory.annotation.Autowired;
import OOP_Project.example.OOP_Project.models.BlogModel;
import OOP_Project.example.OOP_Project.repository.blogRepository;
import OOP_Project.example.OOP_Project.services.blogService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class blogServiceImpl implements blogService {
    @Autowired
    private blogRepository blogRepository;
    
    @Override
    public List<BlogModel> getAllBlogs() {
        return blogRepository.findAll();
    }
    @Override
    public BlogModel getBlogById(int id) {
        return blogRepository.findById(id).orElse(null);
    }
    @Override
    public BlogModel saveBlog(BlogModel blog){
        return blogRepository.save(blog);
    }
    @Override
    public void deleteBlog(int id){
        blogRepository.deleteById(id);
    }
    @Override
    public Boolean create(BlogModel blog) {
        try {
            this.blogRepository.save(blog);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
