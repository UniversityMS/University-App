package lv.unversityManagementSystem.controller;


import lv.unversityManagementSystem.domain.Score;
import lv.unversityManagementSystem.repository.ScoreRepository;
import lv.unversityManagementSystem.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@RequestMapping("/scores")
public class ScoreController {
    private final ScoreService scoreService;
    private final ScoreRepository scoreRepository;

    @Autowired
    public ScoreController(ScoreService scoreService, ScoreRepository scoreRepository) {
        this.scoreService = scoreService;
        this.scoreRepository = scoreRepository;
    }

    @GetMapping("/")
    public String getAllScores(Model model) {
        List<Score> scores = scoreService.getAllScores();
        model.addAttribute("scores", scores);

        return "score/scoreList.html";
    }

    @GetMapping("/{id}")
    public String getScoreById(@PathVariable long id, Model model) {
        Score score = scoreService.findScoreById(id);
        model.addAttribute("score", score);

        return "score/viewScore.html";
    }

    @GetMapping("/find")
    public String getScoreBySubject(@RequestParam String subject, Model model) {
        List<Score> scores = scoreService.findScoreBySubject(subject);

        if (scores.isEmpty()) {
            return "redirect:/scores/";
        }

        model.addAttribute("scores", scores);

        return "score/scoreList.html";
    }

    @GetMapping("/add")
    public String addScore(Model model) {
        Score score = new Score();
        model.addAttribute("score", score);

        return "score/addScore.html";
    }

    @GetMapping("/edit/{id}")
    public String editScore(@PathVariable long id, Model model) {
        Score score = scoreService.findScoreById(id);
        model.addAttribute("score", score);

        return "score/editScore.html";
    }

    @PostMapping("/update")
    public String updateScore(Score score, Model model) {
        Score updateScore = scoreService.updateScore(score);
        score = scoreService.findScoreById(updateScore.getId());
        model.addAttribute("score", score);

        return "redirect:/scores/";
    }

    @PostMapping("/save")
    public String saveScore(Score score, Model model) {
        scoreRepository.save(score);
        model.addAttribute("score", score);

        return "score/newScore.html";
    }

    @GetMapping("/delete/{id}")
    public String deleteScore(@PathVariable Long id, Model model) {
        scoreService.deleteScore(id);
        List<Score> scores = scoreService.getAllScores();
        model.addAttribute("scores", scores);

        return "redirect:/scores/";
    }
}
