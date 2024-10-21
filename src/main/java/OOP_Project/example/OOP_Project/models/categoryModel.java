package OOP_Project.example.OOP_Project.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.Random;
import java.util.Set;

@Entity
@Table(name = "categories")
public class categoryModel {

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
    @Column(name = "image")
    private String image;
    @OneToMany(mappedBy = "category")
    private Set<bookModel> books;

    public categoryModel() {
    }

    public categoryModel(String title, String description, String slug, String image, Set<bookModel> books) {
        this.title = title;
        this.description = description;
        this.slug = slug;
        this.image = image;
        this.books = books;
    }

    public Set<bookModel> getBooks() {
        return books;
    }

    public void setBooks(Set<bookModel> books) {
        this.books = books;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
//        thêm slug khi update 
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
