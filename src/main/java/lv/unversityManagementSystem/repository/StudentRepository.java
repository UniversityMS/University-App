package lv.unversityManagementSystem.repository;

import lv.unversityManagementSystem.model.Score;
import lv.unversityManagementSystem.model.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface StudentRepository extends JpaRepository<Student, Long> {
    void deleteStudentById(Long id);

    Optional<Student> findByUsername(String username);

    Optional<Student> findStudentById(Long id);
}
