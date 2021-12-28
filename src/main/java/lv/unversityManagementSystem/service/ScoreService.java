package lv.unversityManagementSystem.service;


import lv.unversityManagementSystem.exception.DataWithThisIdNotFoundException;
import lv.unversityManagementSystem.model.Score;
import lv.unversityManagementSystem.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;


@Service
public class ScoreService {
    private final ScoreRepository scoreRepository;

    @Autowired
    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    public Score addScore(Score score){
        score.setScoreCode(UUID.randomUUID().toString());
        return scoreRepository.save(score);
    }
    public List<Score> getAllScores(){
        return scoreRepository.findAll();
    }

    public Score updateScore(Score score){
        return scoreRepository.save(score);
    }

    public Score findScoreById(Long id){
        return scoreRepository.findScoreById(id).orElseThrow(() -> new DataWithThisIdNotFoundException("Score" +
                " by id " + id + " was not found!"));
    }

    public void deleteScore(Long id){
        scoreRepository.deleteScoreById(id);
    }

}
