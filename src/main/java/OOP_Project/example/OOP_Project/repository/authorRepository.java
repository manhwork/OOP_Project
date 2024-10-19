package OOP_Project.example.OOP_Project.repository;

import OOP_Project.example.OOP_Project.models.authorModel;
import OOP_Project.example.OOP_Project.models.bookModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface authorRepository extends JpaRepository<authorModel, Integer> {

    @Query("SELECT b FROM authorModel b WHERE b.is_exist = true")
    List<bookModel> find();
}
