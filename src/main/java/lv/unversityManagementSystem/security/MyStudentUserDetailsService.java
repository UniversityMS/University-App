package lv.unversityManagementSystem.security;

import lv.unversityManagementSystem.model.Employee;
import lv.unversityManagementSystem.model.Student;
import lv.unversityManagementSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//@Primary
public class MyStudentUserDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Student> student = studentRepository.findByUsername(username);

        student.orElseThrow(() -> new UsernameNotFoundException("Invalid username: " + username));

        return student.map(MyStudentUserDetails::new).get();
    }
}
