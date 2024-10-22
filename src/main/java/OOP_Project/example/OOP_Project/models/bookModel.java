/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOP_Project.example.OOP_Project.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "books")
public class bookModel {

    @Id
    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id = new Random().nextInt(Integer.MAX_VALUE);

    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "is_active")
    private Boolean is_active = true;
    @Column(name = "slug")
    private String slug;
    @Column(name = "is_exist")
    private Boolean is_exist = true;
    @Column(name = "createAt")
    private Date creatAt = new Date();
    @Column(name = "updateAt")
    private Date updateAt = new Date();
    @Column(name = "price")
    private Double price = (double) 0;
    @Column(name = "discount")
    private Double discount = (double) 0;
    @Column(name = "stock")
    private Integer stock = 0;
    @Column(name = "image")
    private String image;
    @Column(name = "is_outstanding")
    private Boolean is_outstanding = false;

    @ManyToOne
    @JoinColumn(name = "category", referencedColumnName = "id")
    private categoryModel category;

    public bookModel() {
    }

    public bookModel(String title, String description, String slug, String image, categoryModel category) {
        this.title = title;
        this.description = description;
        this.slug = slug;
        this.image = image;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public categoryModel getCategory() {
        return category;
    }

    public void setCategory(categoryModel category) {
        this.category = category;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        generateSlug();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Boolean getIs_exist() {
        return is_exist;
    }

    public void setIs_exist(Boolean is_exist) {
        this.is_exist = is_exist;
    }

    public Date getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(Date creatAt) {
        this.creatAt = creatAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getIs_outstanding() {
        return is_outstanding;
    }

    public void setIs_outstanding(Boolean is_outstanding) {
        this.is_outstanding = is_outstanding;
    }

    //    hàm tạo slug tự động
    public void generateSlug() {
        if (this.title != null) {
            this.slug = this.title.trim().toLowerCase().replaceAll("\\s+", "-");
        }
    }

    @PrePersist
    protected void createOn() {
        generateSlug();
    }

}
