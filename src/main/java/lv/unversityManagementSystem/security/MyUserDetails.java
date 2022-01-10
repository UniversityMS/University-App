package lv.unversityManagementSystem.security;


import lv.unversityManagementSystem.model.Role;
import lv.unversityManagementSystem.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.Collections;
import java.util.Optional;


public class MyUserDetails implements UserDetails {

    private String username;
    private String password;
    private Role role;
    private Optional<User> user;

    public MyUserDetails(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.role = user.getRole();
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

    public Optional<User> getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = Optional.ofNullable(user);
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
