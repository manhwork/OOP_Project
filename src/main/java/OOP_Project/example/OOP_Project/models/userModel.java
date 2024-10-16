package OOP_Project.example.OOP_Project.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "user")

public class userModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "is_active")
    private Boolean is_active;
    @Column(name = "phone")
    private String phone;
    @Column(name = "is_exist")
    private Boolean is_exist;
    @Column(name = "createAt")
    private Date creatAt;
    @Column(name = "updateAt")
    private Date updateAt;

    public userModel() {
        // TODO Auto-generated constructor stub
    }

    public userModel(Integer id, String name, String email, Boolean is_active, String address, Boolean is_exist, Date creatAt, Date updateAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.is_active = is_active;
        this.phone = phone;
        this.is_exist = is_exist;
        this.creatAt = creatAt;
        this.updateAt = updateAt;
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

    public void setDescription(String description) {
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

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }


}
