package OOP_Project.example.OOP_Project.loginAdmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceAdminImpl implements UserServiceAdmin {
    @Autowired
    private UserRepositoryAdmin userRepositoryAdmin;

    @Override
    public User findByUserName(String userName) {
        return userRepositoryAdmin.findByUserName(userName);
    }
}
