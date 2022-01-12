package lv.unversityManagementSystem;

import lv.unversityManagementSystem.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = EmployeeRepository.class)
public class UniversityManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniversityManagementSystemApplication.class, args);
    }
}
