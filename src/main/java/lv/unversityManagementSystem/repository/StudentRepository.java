package lv.unversityManagementSystem.repository;

import lv.unversityManagementSystem.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findStudentById(Long id);

    List<Student> findStudentByName(String name);

    List<Student> findStudentBySurname(String surname);
}
