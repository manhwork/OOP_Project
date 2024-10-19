
package OOP_Project.example.OOP_Project.models;

import jakarta.persistence.*;
import java.util.Date;


@Entity
@Table(name = "blog")
public class BlogModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "slug")
    private String slug;
    @Column(name = "img")
    private String image;
    
    @Column(name = "createAt")
    private Date createAt = new Date() ;
    
    @Column(name = "updateAt")
    private Date updateAt = new Date();
    
    @Column(name = "is_active")
    private Boolean is_active = true;
    
    @Column(name = "is_exist")
    private Boolean is_exist = true;
    
    @ManyToOne
    @JoinColumn(name="blogCate_id",referencedColumnName="id", nullable = true) //đang xem trường hợp nullable = false
    private blogCategoryModel blogCategory;

    public BlogModel(String title, String description,String image, String slug) {
        this.title = title;
        this.description = description;
        this.slug = slug;
        this.image = image;
    }

    

    public BlogModel() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        generateSlug(); // Tạo Slug tự động
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public Boolean getIs_exist() {
        return is_exist;
    }

    public void setIs_exist(Boolean is_exist) {
        this.is_exist = is_exist;
    }

    public blogCategoryModel getBlogCategory() {
        return blogCategory;
    }

    public void setBlogCategory(blogCategoryModel blogCategory) {
        this.blogCategory = blogCategory;
    }
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
