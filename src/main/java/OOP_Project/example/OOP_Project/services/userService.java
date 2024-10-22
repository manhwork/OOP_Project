package OOP_Project.example.OOP_Project.services;

import OOP_Project.example.OOP_Project.models.userModel;
import java.util.List;

public interface userService {

    List<userModel> getAll();

    Boolean create(userModel user);

    userModel findById(Integer id);

    Boolean update(userModel user);

    Boolean delete(userModel user);

    List<userModel> getItem();

}
