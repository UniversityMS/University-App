package lv.unversityManagementSystem.security;

import lv.unversityManagementSystem.model.Employee;
import lv.unversityManagementSystem.model.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.Collections;
import java.util.Optional;


public class MyEmployeeUserDetails implements UserDetails {

    private String username;
    private String password;
    private Role role;
    private Optional<Employee> employee;

    public MyEmployeeUserDetails(Employee employeeUser) {
        this.username = employeeUser.getUsername();
        this.password = employeeUser.getPassword();
        this.role = employeeUser.getRole();
    }
//    public MyEmployeeUserDetails(Optional<Employee> employee){
//        this.employee = employee;
//    }

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

    public Optional<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = Optional.ofNullable(employee);
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
