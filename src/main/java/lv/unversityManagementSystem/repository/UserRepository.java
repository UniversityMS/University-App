package lv.unversityManagementSystem.repository;

import lv.unversityManagementSystem.model.Score;
import lv.unversityManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    void deleteUserById(Long id);
    Optional<User> findUserById(Long id);
}