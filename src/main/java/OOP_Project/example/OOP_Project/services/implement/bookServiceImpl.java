/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOP_Project.example.OOP_Project.services.implement;

import OOP_Project.example.OOP_Project.models.bookModel;
import OOP_Project.example.OOP_Project.repository.bookRepository;
import OOP_Project.example.OOP_Project.services.bookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class bookServiceImpl implements bookService {
    
    @Autowired
    private bookRepository bookRepository;
    
    @Override
    public List<bookModel> getAll() {
        return this.bookRepository.findAll();
    }
    
    @Override
    public Boolean create(bookModel book) {
        try {
            this.bookRepository.save(book);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public bookModel findById(Integer id) {
        return this.bookRepository.findById(id).get();
    }
    
    @Override
    public Boolean update(bookModel book) {
        try {
            this.bookRepository.save(book);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public Boolean delete(bookModel book) {
        try {
            book.setIs_exist(Boolean.FALSE);
            this.bookRepository.save(book);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public List<bookModel> getItem() {
        return this.bookRepository.find();
    }
    
    @Override
    public bookModel getItemSlug(String slug) {
        return this.bookRepository.findBySlug(slug);
    }
}
