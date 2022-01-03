package lv.unversityManagementSystem.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {   //serializable helps to transform this java class into different
    // type of stream.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "position")
    private String position;

    @Column(name = "date_of_birth")
    private String employeeDateOfBirth;

    @Column(name = "employee_img_url")
    private String employeeImgUrl;

    @Column(name = "username")
    private long username;

    @Column(name = "password")
    private long password;

    @Column(name = "role")
    private long role;


    public Employee() {

    }

    public Employee(long id, String firstName, String lastName, String position, String employeeDateOfBirth, String employeeImgUrl, long username, long password, long role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.employeeDateOfBirth = employeeDateOfBirth;
        this.employeeImgUrl = employeeImgUrl;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmployeeDateOfBirth() {
        return employeeDateOfBirth;
    }

    public void setEmployeeDateOfBirth(String employeeDateOfBirth) {
        this.employeeDateOfBirth = employeeDateOfBirth;
    }

    public String getEmployeeImgUrl() {
        return employeeImgUrl;
    }

    public void setEmployeeImgUrl(String employeeImgUrl) {
        this.employeeImgUrl = employeeImgUrl;
    }

    public long getUsername() {
        return username;
    }

    public void setUsername(long username) {
        this.username = username;
    }

    public long getPassword() {
        return password;
    }

    public void setPassword(long password) {
        this.password = password;
    }

    public long getRole() {
        return role;
    }

    public void setRole(long role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", employeeDateOfBirth='" + employeeDateOfBirth + '\'' +
                ", employeeImgUrl='" + employeeImgUrl + '\'' +
                ", username=" + username +
                ", password=" + password +
                ", role=" + role +
                '}';
    }
}
