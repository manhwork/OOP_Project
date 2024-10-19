package OOP_Project.example.OOP_Project.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.Random;

@Entity
@Table(name = "authur")

public class authorModel {

    @Id
    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id= new Random().nextInt(Integer.MAX_VALUE);;

    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;
    @Column(name = "is_active")
    private Boolean is_active = true;
    @Column(name = "address")
    private String address;
    @Column(name = "is_exist")
    private Boolean is_exist = true;
    @Column(name = "createAt")
    private Date creatAt = new Date();
    @Column(name = "updateAt")
    private Date updateAt = new Date();

    public authorModel() {
        // TODO Auto-generated constructor stub
    }

    public authorModel(Integer id, String name, Integer age, Boolean is_active, String address, Boolean is_exist, Date creatAt, Date updateAt) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.is_active = is_active;
        this.address = address;
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

    public Integer getAge() {
        return age;
    }

    public void setDescription(String description) {
        this.age = age;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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



