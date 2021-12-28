package lv.unversityManagementSystem.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "students")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long studentId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "faculty")
    private String faculty;

    @Column(name = "group_id")
    private long groupId;

    @Column(name = "date_of_birth")
    private String studentDateOfBirth;

    @Column(name = "student_img_url")
    private String studentImgUrl;

    @Column(nullable = false, updatable = false)
    private String studentCode;

    public Student(long studentId, String firstName, String lastName, long userId, String faculty, long groupId,
                   String studentDateOfBirth, String studentImgUrl, String studentCode) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
        this.faculty = faculty;
        this.groupId = groupId;
        this.studentDateOfBirth = studentDateOfBirth;
        this.studentImgUrl = studentImgUrl;
        this.studentCode = studentCode;
    }

    public Student() {
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
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

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userId=" + userId +
                ", faculty='" + faculty + '\'' +
                ", groupId=" + groupId +
                ", studentDateOfBirth='" + studentDateOfBirth + '\'' +
                ", studentImgUrl='" + studentImgUrl + '\'' +
                ", studentCode='" + studentCode + '\'' +
                '}';
    }
}
