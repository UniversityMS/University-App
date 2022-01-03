package lv.unversityManagementSystem.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "students")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "faculty")
    private String faculty;

    @Column(name = "group_id")
    private String groupId;

    @Column(name = "date_of_birth")
    private String studentDateOfBirth;

    @Column(name = "student_img_url")
    private String studentImgUrl;

    @Column(name = "username")
    private long username;

    @Column(name = "password")
    private long password;

    @Column(name = "role")
    private long role;


    public Student(long id, String firstName, String lastName, String faculty, String groupId, String studentDateOfBirth, String studentImgUrl, long username, long password, long role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.faculty = faculty;
        this.groupId = groupId;
        this.studentDateOfBirth = studentDateOfBirth;
        this.studentImgUrl = studentImgUrl;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Student() {
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

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getStudentDateOfBirth() {
        return studentDateOfBirth;
    }

    public void setStudentDateOfBirth(String studentDateOfBirth) {
        this.studentDateOfBirth = studentDateOfBirth;
    }

    public String getStudentImgUrl() {
        return studentImgUrl;
    }

    public void setStudentImgUrl(String studentImgUrl) {
        this.studentImgUrl = studentImgUrl;
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
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", faculty='" + faculty + '\'' +
                ", groupId='" + groupId + '\'' +
                ", studentDateOfBirth='" + studentDateOfBirth + '\'' +
                ", studentImgUrl='" + studentImgUrl + '\'' +
                ", username=" + username +
                ", password=" + password +
                ", role=" + role +
                '}';
    }
}
