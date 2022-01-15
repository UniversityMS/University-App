package lv.unversityManagementSystem.domain;

import org.hibernate.annotations.ColumnTransformer;

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
    @Enumerated(EnumType.STRING)
    @ColumnTransformer(read = "UPPER(subject)", write = "LOWER(?)")
    private Subject subject;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Student student;

    @Column(name = "score")
    private int score;

    @Column(name = "date")
    private String date;

    public Score() {
    }

    public Score(long id, Subject subject, Employee employee, Student student, int score, String date) {
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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
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
