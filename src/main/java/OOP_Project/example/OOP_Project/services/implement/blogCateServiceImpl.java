package OOP_Project.example.OOP_Project.services.implement;

import OOP_Project.example.OOP_Project.models.blogCategoryModel;
import OOP_Project.example.OOP_Project.repository.blogCateRepository;
import OOP_Project.example.OOP_Project.services.blogCateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class blogCateServiceImpl implements blogCateService {
   @Autowired
   private blogCateRepository blogCateRepository;
   
   @Override
   public List<blogCategoryModel> getAllCategories() {
       return blogCateRepository.findAll();
   }

   @Override
   public blogCategoryModel getCategoryById(int id) {
       return blogCateRepository.findById(id).orElse(null);
   }

   @Override
   public blogCategoryModel saveCategory(blogCategoryModel blogCategory) {
       return blogCateRepository.save(blogCategory); // Đảm bảo phương thức lưu dữ liệu
   }

   @Override
   public void deleteCategory(int id) {
       blogCateRepository.deleteById(id);
   }
   @Override
    public Boolean create(blogCategoryModel blogCategory) {
        try {
            this.blogCateRepository.save(blogCategory);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
