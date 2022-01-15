package lv.unversityManagementSystem.service;


import lv.unversityManagementSystem.exception.DataWithThisIdNotFoundException;
import lv.unversityManagementSystem.domain.Score;
import lv.unversityManagementSystem.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ScoreService {
    private final ScoreRepository scoreRepository;

    @Autowired
    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }

    public Score updateScore(Score score) {
        return scoreRepository.save(score);
    }

    public Score findScoreById(Long id) {
        return scoreRepository.findScoreById(id).orElseThrow(() -> new DataWithThisIdNotFoundException("Score" +
                " by id " + id + " was not found!"));
    }

    public void deleteScore(Long id) {
        scoreRepository.deleteById(id);
    }

    public List<Score> findScoreBySubject(String subject){
        return scoreRepository.findScoreBySubject(subject);
    }

    public Score save(Score score) {
        return scoreRepository.save(score);
    }

}
