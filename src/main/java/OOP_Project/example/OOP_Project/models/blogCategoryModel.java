
package OOP_Project.example.OOP_Project.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Table(name="blog_category")
public class blogCategoryModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
    @Column(name ="title")
    private String title;
    @Column(name ="description")
    private String description;
    @Column(name ="slug")
    private String slug;
    
//   @Temporal(TemporalType.TIMESTAMP)
//@Column(name = "create_at")
//private Date creatAt;
//
//@Temporal(TemporalType.TIMESTAMP)
//@Column(name = "update_at")
//private Date updateAt;

    
    @Column(name = "is_active")
    private boolean is_active;
    
    @Column(name = "is_exist")
    private boolean is_exist;

    public blogCategoryModel() {
    }

    public blogCategoryModel(int id, String title, String description, String slug, Date creatAt, Date updateAt, boolean is_active, boolean is_exist) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.slug = slug;
//        this.creatAt = creatAt;
//        this.updateAt = updateAt;
        this.is_active = is_active;
        this.is_exist = is_exist;
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

//    public Date getCreatAt() {
//        return creatAt;
//    }
//
//    public void setCreatAt(Date creatAt) {
//        this.creatAt = creatAt;
//    }
//
//    public Date getUpdateAt() {
//        return updateAt;
//    }
//
//    public void setUpdateAt(Date updateAt) {
//        this.updateAt = updateAt;
//    }

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

    
    
    
}
