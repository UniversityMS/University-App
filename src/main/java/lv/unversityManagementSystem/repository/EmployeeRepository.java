package lv.unversityManagementSystem.repository;


import lv.unversityManagementSystem.model.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(Long id);
    Optional<Employee> findByUsername(String username);

    Optional<Employee> findEmployeeById(Long id);  //optional for situations if we don't have employee with such id
}
