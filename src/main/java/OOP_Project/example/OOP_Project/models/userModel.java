package OOP_Project.example.OOP_Project.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.Random;

@Entity
@Table(name = "user")

public class userModel {

    @Id
    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id = new Random().nextInt(Integer.MAX_VALUE);
    ;

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "is_active")
    private Boolean is_active = true;
    @Column(name = "phone")
    private String phone;
    @Column(name = "is_exist")
    private Boolean is_exist = true;
    @Column(name = "createAt")
    private Date creatAt = new Date();
    @Column(name = "updateAt")
    private Date updateAt = new Date();
    @Column(name = "image")
    private String image;

    public userModel() {
        // TODO Auto-generated constructor stub
    }

    public userModel(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

}
