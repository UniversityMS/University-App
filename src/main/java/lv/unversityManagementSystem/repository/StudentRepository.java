package lv.unversityManagementSystem.repository;

import lv.unversityManagementSystem.domain.Employee;
import lv.unversityManagementSystem.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findStudentById(Long id);
    Optional<Student> findStudentByName(String name);
    Optional<Student> findStudentBySurname(String surname);
}
