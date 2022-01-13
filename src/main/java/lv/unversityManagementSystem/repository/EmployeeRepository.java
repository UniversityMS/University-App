package lv.unversityManagementSystem.repository;


import lv.unversityManagementSystem.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(Long id);
    Optional<Employee> findByUsername(String username);

    Optional<Employee> findEmployeeById(Long id);  //optional for situations if we don't have employee with such id
    Optional<Employee> findEmployeeByName(String name);
}
