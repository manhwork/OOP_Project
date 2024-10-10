package OOP_Project.example.OOP_Project.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class categoryModel {

    @Id
    @Column(name = "categoryId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    @Column(name = "categoryName")
    private String categoryName;
    @Column(name = "categoryStatus")
    private Boolean categoryStatus;

    public categoryModel() {
        // TODO Auto-generated constructor stub
    }

    public categoryModel(Integer categoryId, String categoryName, Boolean categoryStatus) {
        super();
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryStatus = categoryStatus;
    }

    public Integer getcategoryModelId() {
        return categoryId;
    }

    public void setcategoryModelId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getcategoryModelName() {
        return categoryName;
    }

    public void setcategoryModelName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Boolean getcategoryModelStatus() {
        return categoryStatus;
    }

    public void setcategoryModelStatus(Boolean categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

}
