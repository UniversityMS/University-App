package lv.unversityManagementSystem.domain;

import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false, updatable = false)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    @ColumnTransformer(read = "UPPER(role)", write = "LOWER(?)")
    private Role role;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "img_url")
    private String imgUrl;


    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
