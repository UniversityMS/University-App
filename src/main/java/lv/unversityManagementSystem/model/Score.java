package lv.unversityManagementSystem.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "scores")
public class Score implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(name = "subject")
    private String subject;

    @Column(name = "lecturer_id")
    private long lecturerId;

    @Column(name = "student_id")
    private String studentId;

    @Column(name = "score")
    private int score;

    @Column(name = "submitted")
    private String submittedDate;



    public Score(long id, String subject, long lecturerId, String studentId, int score, String submittedDate) {
        this.id = id;
        this.subject = subject;
        this.lecturerId = lecturerId;
        this.studentId = studentId;
        this.score = score;
        this.submittedDate = submittedDate;
    }

    public Score() {
    }

    public long getScoreId() {
        return id;
    }

    public void setScoreId(long id) {
        this.id = id;
    }
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public long getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(long lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(String submittedDate) {
        this.submittedDate = submittedDate;
    }


    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", lecturerId=" + lecturerId +
                ", studentId='" + studentId + '\'' +
                ", score=" + score +
                ", submittedDate='" + submittedDate + '\'' +
                '}';
    }
}
