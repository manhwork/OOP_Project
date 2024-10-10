/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package OOP_Project.example.OOP_Project.services;

import OOP_Project.example.OOP_Project.models.categoryModel;
import java.util.List;

/**
 *
 * @author admin
 */
public interface categoryService {

    List<categoryModel> getAll();

    Boolean create(categoryModel category);

    categoryModel findById(Integer id);

    Boolean update(categoryModel category);

    Boolean delete(categoryModel category);
}
