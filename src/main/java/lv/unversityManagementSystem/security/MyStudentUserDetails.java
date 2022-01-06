package lv.unversityManagementSystem.security;

import lv.unversityManagementSystem.model.Employee;
import lv.unversityManagementSystem.model.Role;
import lv.unversityManagementSystem.model.Student;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class MyStudentUserDetails implements UserDetails {
    private String username;
    private String password;
    private Role role;
    private Optional<Student> student;

    public MyStudentUserDetails(Student studentUser) {
        this.username = studentUser.getUsername();
        this.password = studentUser.getPassword();
        this.role = studentUser.getRole();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.name());
        return Collections.singletonList(authority);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Optional<Student> getStudent() {
        return student;
    }

    public void setEmployee(Student student) {
        this.student = Optional.ofNullable(student);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
