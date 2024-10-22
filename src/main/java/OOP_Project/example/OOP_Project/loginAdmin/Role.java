package OOP_Project.example.OOP_Project.loginAdmin;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "role")

public class Role {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "role")
    private Set<UserRole> roleUsers;

    public Role() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Role(Long id, String name, Set<UserRole> roleUsers) {
        super();
        this.id = id;
        this.name = name;
        this.roleUsers = roleUsers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserRole> getRoleUsers() {
        return roleUsers;
    }

    public void setRoleUsers(Set<UserRole> roleUsers) {
        this.roleUsers = roleUsers;
    }
}