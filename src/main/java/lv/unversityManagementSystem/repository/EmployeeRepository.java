package lv.unversityManagementSystem.repository;


import lv.unversityManagementSystem.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findEmployeeById(Long id);  //optional for situations if we don't have employee with such id

    Optional<Employee> findByUsername(String username);

    List<Employee> findEmployeeByName(String name);

    List<Employee> findEmployeeBySurname(String surname);
}
