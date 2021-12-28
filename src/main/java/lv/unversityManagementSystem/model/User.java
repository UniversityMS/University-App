package lv.unversityManagementSystem.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "access")
    private String access;

    @Column(nullable = false, updatable = false)
    private String userCode;

    public User() {
    }

    public User(long userId, String username, String password, String access, String userCode) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.access = access;
        this.userCode = userCode;
    }

    public User(long userId, String username, String password, String access) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.access = access;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", access='" + access + '\'' +
                ", userCode='" + userCode + '\'' +
                '}';
    }
}
