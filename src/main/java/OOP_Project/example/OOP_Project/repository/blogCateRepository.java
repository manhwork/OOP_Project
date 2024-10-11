
package OOP_Project.example.OOP_Project.repository;

import OOP_Project.example.OOP_Project.models.blogCategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface blogCateRepository  extends JpaRepository<blogCategoryModel, Integer>{
    
}
