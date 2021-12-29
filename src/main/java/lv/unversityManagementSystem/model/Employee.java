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

    @Column(name = "user_id")
    private long userId;

    @Column(name = "date_of_birth")
    private String employeeDateOfBirth;

    @Column(name = "employee_img_url")
    private String employeeImgUrl;

    @Column(nullable = false, updatable = false)
    private String employeeCode;

    public Employee() {

    }

    public Employee(long id, String firstName, String lastName, String position, long userId,
                    String employeeDateOfBirth, String employeeImgUrl, String employeeCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.userId = userId;
        this.employeeDateOfBirth = employeeDateOfBirth;
        this.employeeImgUrl = employeeImgUrl;
        this.employeeCode = employeeCode;
    }

    public long getEmployeeId() {
        return id;
    }

    public void setEmployeeId(long id) {
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", userId=" + userId +
                ", employeeDateOfBirth='" + employeeDateOfBirth + '\'' +
                ", employeeImgUrl='" + employeeImgUrl + '\'' +
                ", employeeCode='" + employeeCode + '\'' +
                '}';
    }
}
