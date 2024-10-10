/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOP_Project.example.OOP_Project.repository;

import OOP_Project.example.OOP_Project.models.categoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author admin 
 */


public interface categoryRepository extends JpaRepository<categoryModel, Integer> {

}
