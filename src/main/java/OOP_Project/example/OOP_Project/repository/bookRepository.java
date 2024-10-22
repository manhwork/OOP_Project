/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOP_Project.example.OOP_Project.repository;

import OOP_Project.example.OOP_Project.models.bookModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author admin
 */
public interface bookRepository extends JpaRepository<bookModel, Integer> {

    @Query("SELECT b FROM bookModel b WHERE b.is_exist = true")
    List<bookModel> find();

    bookModel findBySlug(String slug);

    @Query("SELECT b FROM bookModel b WHERE b.is_outstanding = true AND b.is_exist = true")
    List<bookModel> findOS();

    @Query("SELECT b from bookModel b where b.is_exist = true order by b.creatAt desc limit 6")
    List<bookModel> findNewProduct();

    @Query("select b from bookModel b where b.is_exist = true and b.title like %:keyword%")
    List<bookModel> search(String keyword);
}
