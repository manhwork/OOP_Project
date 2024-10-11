
package OOP_Project.example.OOP_Project.repository;

import OOP_Project.example.OOP_Project.models.BlogModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface blogRepository  extends JpaRepository<BlogModel, Integer>{
    
}
