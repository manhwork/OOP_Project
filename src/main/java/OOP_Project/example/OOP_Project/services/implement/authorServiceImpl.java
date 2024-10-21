package OOP_Project.example.OOP_Project.services.implement;

import OOP_Project.example.OOP_Project.models.authorModel;
import OOP_Project.example.OOP_Project.repository.authorRepository;
import OOP_Project.example.OOP_Project.services.authorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class authorServiceImpl implements authorService {

    @Autowired
    private authorRepository authorRepository;

    @Override
    public List<authorModel> getAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public List<authorModel> getItem() {
        return this.authorRepository.find();
    }

    @Override
    public Boolean create(authorModel author) {
        try {
            this.authorRepository.save(author);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public authorModel findById(Integer id) {
        return this.authorRepository.findById(id).get();
    }

    @Override
    public Boolean update(authorModel author) {
        try {
            this.authorRepository.save(author);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delete(authorModel author) {
        try {
            author.setIs_exist(Boolean.FALSE);
            this.authorRepository.save(author);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
