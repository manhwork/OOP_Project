package OOP_Project.example.OOP_Project.repository;


import OOP_Project.example.OOP_Project.models.userModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface userRepository  extends JpaRepository<userModel, Integer> {
    List<userModel> find();
}
