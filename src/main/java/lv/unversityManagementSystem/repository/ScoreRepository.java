package lv.unversityManagementSystem.repository;


import lv.unversityManagementSystem.model.Employee;
import lv.unversityManagementSystem.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
    void deleteScoreById(Long id);

    Optional<Score> findScoreById(Long id);
}
