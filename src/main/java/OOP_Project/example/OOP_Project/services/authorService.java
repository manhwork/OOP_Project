package OOP_Project.example.OOP_Project.services;

import OOP_Project.example.OOP_Project.models.authorModel;
import java.util.List;

public interface authorService {

    List<authorModel> getAll();

    Boolean create(authorModel author);

    authorModel findById(Integer id);

    Boolean update(authorModel author);

    Boolean delete(authorModel author);

    List<authorModel> getItem();
}