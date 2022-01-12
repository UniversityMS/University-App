package lv.unversityManagementSystem.security;

import lv.unversityManagementSystem.model.Employee;
import lv.unversityManagementSystem.model.User;
import lv.unversityManagementSystem.repository.EmployeeRepository;
import lv.unversityManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        user.orElseThrow(() -> new UsernameNotFoundException("Invalid username: " + username));

        return user.map(MyUserDetails::new).get();
        //new MyEmployeeUserDetails(employee);
    }
}
