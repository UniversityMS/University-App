package lv.unversityManagementSystem.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "scores")
public class Score implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "score_id", nullable = false, updatable = false)
    private long id;

    @Column(name = "subject")
    private String subject;

    @Column(name = "employee_id")
    private long employee;

    @Column(name = "student_id")
    private String student;

    @Column(name = "score")
    private int score;

    @Column(name = "date")
    private String date;

    public Score() {
    }

    public Score(long id, String subject, long employee, String student, int score, String date) {
        this.id = id;
        this.subject = subject;
        this.employee = employee;
        this.student = student;
        this.score = score;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public long getEmployee() {
        return employee;
    }

    public void setEmployee(long employee) {
        this.employee = employee;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", employee=" + employee +
                ", student='" + student + '\'' +
                ", score=" + score +
                ", date='" + date + '\'' +
                '}';
    }
}
