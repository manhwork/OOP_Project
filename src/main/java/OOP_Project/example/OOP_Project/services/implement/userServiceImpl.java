package OOP_Project.example.OOP_Project.services.implement;

import OOP_Project.example.OOP_Project.models.categoryModel;
import OOP_Project.example.OOP_Project.models.userModel;
import OOP_Project.example.OOP_Project.repository.userRepository;
import OOP_Project.example.OOP_Project.services.userService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @user admin
 */
@Service
public class userServiceImpl implements userService {

    @Autowired
    private userRepository userRepository;

    @Override
    public List<userModel> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public List<userModel> getItem() {
        return this.userRepository.find();
    }

    @Override
    public Boolean create(userModel user) {
        try {
            this.userRepository.save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public userModel findById(Integer id) {
        return this.userRepository.findById(id).get();
    }

    @Override
    public Boolean update(userModel user) {
        try {
            this.userRepository.save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delete(userModel user) {
        try {
            user.setIs_exist(Boolean.FALSE);
            this.userRepository.save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
