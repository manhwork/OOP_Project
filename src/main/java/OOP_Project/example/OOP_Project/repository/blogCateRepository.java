
package OOP_Project.example.OOP_Project.repository;

import OOP_Project.example.OOP_Project.models.blogCategoryModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface blogCateRepository  extends JpaRepository<blogCategoryModel, Integer>{
    @Query("SELECT c FROM blogCategoryModel c WHERE c.is_exist = true")
    List<blogCategoryModel> find();
}
