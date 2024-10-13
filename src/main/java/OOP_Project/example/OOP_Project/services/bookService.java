/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOP_Project.example.OOP_Project.services;

import OOP_Project.example.OOP_Project.models.bookModel;
import java.util.List;

/**
 *
 * @author admin
 */
public interface bookService {

    List<bookModel> getAll();

    Boolean create(bookModel book);

    bookModel findById(Integer id);

    Boolean update(bookModel book);

    Boolean delete(bookModel book);

    List<bookModel> getItem();
}
