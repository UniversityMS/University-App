package lv.unversityManagementSystem.repository;


import lv.unversityManagementSystem.domain.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
    Optional<Score> findScoreById(Long id);

    List<Score> findScoreBySubject(String subject);
}
