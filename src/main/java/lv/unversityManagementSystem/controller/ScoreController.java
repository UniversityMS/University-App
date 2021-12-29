package lv.unversityManagementSystem.controller;


import lv.unversityManagementSystem.model.Score;
import lv.unversityManagementSystem.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/scores")
public class ScoreController {
    private final ScoreService scoreService;

    @Autowired
    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Score>> gelAllScores() {
        List<Score> scores = scoreService.getAllScores();
        return new ResponseEntity<>(scores, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Score> getScoreById(@PathVariable("id") Long id) {
        Score score = scoreService.findScoreById(id);
        return new ResponseEntity<>(score, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Score> addScore(@RequestBody Score score) {
        Score newScore = scoreService.addScore(score);
        return new ResponseEntity<>(newScore, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Score> updateScore(@RequestBody Score score) {
        Score updateScore = scoreService.updateScore(score);
        return new ResponseEntity<>(updateScore, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteScore(@PathVariable("id") Long id) {
        scoreService.deleteScore(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
