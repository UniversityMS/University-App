package lv.unversityManagementSystem.security;

import lv.unversityManagementSystem.model.Employee;
import lv.unversityManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
public class MyEmployeeUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> employee = employeeRepository.findByUsername(username);

        employee.orElseThrow(() -> new UsernameNotFoundException("Invalid username: " + username));

        return employee.map(MyEmployeeUserDetails::new).get();
        //new MyEmployeeUserDetails(employee);
    }
}
