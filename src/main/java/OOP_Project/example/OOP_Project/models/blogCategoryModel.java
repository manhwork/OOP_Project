
package OOP_Project.example.OOP_Project.models;

import jakarta.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
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
    
  
     @Column(name = "createAt")
    private Date createAt = new Date() ;
    
    @Column(name = "updateAt")
    private Date updateAt = new Date();
    
    @Column(name = "is_active")
    private Boolean is_active = true;
    
    @Column(name = "is_exist")
    private Boolean is_exist = true;
    
    @OneToMany(mappedBy = "blogCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BlogModel> blogs = new HashSet<>();

    public blogCategoryModel() {
    }

    public blogCategoryModel(String title, String description, String slug) {
        this.title = title;
        this.description = description;
        this.slug = slug;
    }

    public Set<BlogModel> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<BlogModel> blogs) {
        this.blogs = blogs;
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
        generateSlug();
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
    
    public void generateSlug() {
        if (this.title != null) {
            this.slug = this.title.trim().toLowerCase().replaceAll("\\s+", "-");
        }
    }

    @PrePersist
    protected void createOn() {
        generateSlug();
       
    }
    
    public void addBlog(BlogModel blog) {
        blogs.add(blog);
        blog.setBlogCategory(this);
    }
    
    

}