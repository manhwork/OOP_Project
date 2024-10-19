
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
        return blogRepository.find();
    }
    @Override
    public BlogModel getBlogById(Integer id) {
        return blogRepository.findById(id).get();
    }
    @Override
    public BlogModel saveBlog(BlogModel blog){
        return blogRepository.save(blog);
    }
    
    @Override
    public List<BlogModel> getItem(){
        return this.blogRepository.find();
    }
    
    // Update
    @Override
    public Boolean update(BlogModel blog) {
        try {
            this.blogRepository.save(blog);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    // Xóa
    @Override
    public Boolean delete(BlogModel blog) {
        try {
            blog.setIs_exist(Boolean.FALSE);
            this.blogRepository.save(blog);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    // Tạo mới
    @Override
    public Boolean create(BlogModel blog) {
        try {
            if(!blogRepository.existsById(blog.getId())){
                this.blogRepository.save(blog);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
