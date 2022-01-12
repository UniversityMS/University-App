package lv.unversityManagementSystem.security;

import lv.unversityManagementSystem.domain.Employee;
import lv.unversityManagementSystem.domain.User;
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
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> employee = employeeRepository.findByUsername(username);

        employee.orElseThrow(() -> new UsernameNotFoundException("Invalid username: " + username));

        employee.map(MyUserDetails::new).get();
        return employee.map(MyUserDetails::new).get();
    }
}
