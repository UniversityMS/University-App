package lv.unversityManagementSystem.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "scores")
public class Score implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long scoreId;

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

    @Column(nullable = false, updatable = false)
    private String scoreCode;

    public Score(long scoreId, String subject, long lecturerId, String studentId, int score, String submittedDate,
                 String scoreCode) {
        this.scoreId = scoreId;
        this.subject = subject;
        this.lecturerId = lecturerId;
        this.studentId = studentId;
        this.score = score;
        this.submittedDate = submittedDate;
        this.scoreCode = scoreCode;
    }

    public Score() {
    }

    public long getScoreId() {
        return scoreId;
    }

    public void setScoreId(long scoreId) {
        this.scoreId = scoreId;
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

    public String getScoreCode() {
        return scoreCode;
    }

    public void setScoreCode(String scoreCode) {
        this.scoreCode = scoreCode;
    }

    @Override
    public String toString() {
        return "Score{" +
                "scoreId=" + scoreId +
                ", subject='" + subject + '\'' +
                ", lecturerId=" + lecturerId +
                ", studentId='" + studentId + '\'' +
                ", score=" + score +
                ", submittedDate='" + submittedDate + '\'' +
                ", scoreCode='" + scoreCode + '\'' +
                '}';
    }
}
