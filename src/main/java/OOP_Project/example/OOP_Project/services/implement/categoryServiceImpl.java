/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOP_Project.example.OOP_Project.services.implement;

import OOP_Project.example.OOP_Project.models.categoryModel;
import OOP_Project.example.OOP_Project.repository.categoryRepository;
import OOP_Project.example.OOP_Project.services.categoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class categoryServiceImpl implements categoryService {

    @Autowired
    private categoryRepository categoryRepository;

    @Override
    public List<categoryModel> getAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public List<categoryModel> getItem() {
        return this.categoryRepository.find();
    }

    @Override
    public Boolean create(categoryModel category) {
        try {
            this.categoryRepository.save(category);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public categoryModel findById(Integer id) {
        return this.categoryRepository.findById(id).get();
    }

    @Override
    public Boolean update(categoryModel category) {
        try {
            this.categoryRepository.save(category);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delete(categoryModel category) {
        try {
            category.setIs_exist(Boolean.FALSE);
            this.categoryRepository.save(category);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
