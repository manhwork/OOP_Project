
package OOP_Project.example.OOP_Project.repository;

import OOP_Project.example.OOP_Project.models.BlogModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface blogRepository  extends JpaRepository<BlogModel, Integer>{
    @Query("SELECT c FROM BlogModel c WHERE c.is_exist = true")
    List<BlogModel> find();
}
