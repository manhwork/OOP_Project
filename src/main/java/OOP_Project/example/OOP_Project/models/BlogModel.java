
package OOP_Project.example.OOP_Project.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "blog")
public class BlogModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "slug")
    private String slug;
    @Column(name = "img")
    private String image;
    
    @Column(name = "createAt")
    private LocalDateTime createAt;
    
    @Column(name = "updateAt")
    private LocalDateTime updateAt;
    
    @Column(name = "is_active")
    private boolean is_active;
    
    @Column(name = "is_exist")
    private boolean is_exist;
    
    @ManyToOne
    @JoinColumn(name="blogCate_id",referencedColumnName="id")
    private blogCategoryModel blogCategory;

    public BlogModel(int id, String title, String description, String slug, String image, LocalDateTime createAt, LocalDateTime updateAt, boolean is_active, boolean is_exist, blogCategoryModel blogCategory) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.slug = slug;
        this.image = image;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.is_active = is_active;
        this.is_exist = is_exist;
        this.blogCategory = blogCategory;
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

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public boolean isIs_exist() {
        return is_exist;
    }

    public void setIs_exist(boolean is_exist) {
        this.is_exist = is_exist;
    }

    public blogCategoryModel getBlogCategory() {
        return blogCategory;
    }

    public void setBlogCategory(blogCategoryModel blogCategory) {
        this.blogCategory = blogCategory;
    }
    
 
}
