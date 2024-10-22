package OOP_Project.example.OOP_Project.repository;

import OOP_Project.example.OOP_Project.models.bookModel;
import OOP_Project.example.OOP_Project.models.userModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface userRepository extends JpaRepository<userModel, Integer> {

    @Query("SELECT b FROM userModel b WHERE b.is_exist = true")
    List<userModel> find();
}
