package lv.unversityManagementSystem.security;

import lv.unversityManagementSystem.domain.Employee;
import lv.unversityManagementSystem.domain.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeDetails implements UserDetails {
    private Long id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private List<GrantedAuthority> role;

    public EmployeeDetails(Employee employee){
        this.id = employee.getId();
        this.name = employee.getName();
        this.surname = employee.getSurname();
        this.username = employee.getUsername();
        this.password = employee.getPassword();
        List<String> roleAsString = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toList());

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return role;
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