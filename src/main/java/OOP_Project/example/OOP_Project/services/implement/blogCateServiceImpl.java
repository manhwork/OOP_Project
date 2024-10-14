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
   public List<blogCategoryModel> getAllblogCategories() {
       return blogCateRepository.find();
   }

   @Override
   public blogCategoryModel getblogCategoryById(Integer id) {
       return blogCateRepository.findById(id).get();
   }

   @Override
   public blogCategoryModel saveblogCategory(blogCategoryModel blogCategory) {
       return blogCateRepository.save(blogCategory); // Đảm bảo phương thức lưu dữ liệu
   }

   @Override
    public Boolean delete(blogCategoryModel blogCategory) {
        try {
            blogCategory.setIs_exist(Boolean.FALSE);
            this.blogCateRepository.save(blogCategory);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public Boolean create(blogCategoryModel blogCategory) {
        try {
            if(!blogCateRepository.existsById(blogCategory.getId())){
                this.blogCateRepository.save(blogCategory);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public Boolean update(blogCategoryModel blogCategory) {
        try {
            this.blogCateRepository.save(blogCategory);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
