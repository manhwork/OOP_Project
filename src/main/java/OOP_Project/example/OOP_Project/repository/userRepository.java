package OOP_Project.example.OOP_Project.repository;

import OOP_Project.example.OOP_Project.models.userModel;
import org.springframework.data.jpa.repository.JpaRepository;



public interface userRepository  extends JpaRepository<userModel, Integer> {

}
