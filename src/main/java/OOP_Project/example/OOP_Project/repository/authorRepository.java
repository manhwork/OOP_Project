package OOP_Project.example.OOP_Project.repository;

import OOP_Project.example.OOP_Project.models.authorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface authorRepository  extends JpaRepository<authorModel, Integer> {
    List<authorModel> find();
}
