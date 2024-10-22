package OOP_Project.example.OOP_Project.loginAdmin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryAdmin extends JpaRepository<User, Long > {
    User findByUserName(String userName);
}
