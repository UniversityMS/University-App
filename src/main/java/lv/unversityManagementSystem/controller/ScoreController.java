package lv.unversityManagementSystem.controller;


import lv.unversityManagementSystem.domain.Employee;
import lv.unversityManagementSystem.domain.Score;
import lv.unversityManagementSystem.domain.Student;
import lv.unversityManagementSystem.repository.EmployeeRepository;
import lv.unversityManagementSystem.repository.ScoreRepository;
import lv.unversityManagementSystem.service.EmployeeService;
import lv.unversityManagementSystem.service.ScoreService;
import lv.unversityManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/scores")
public class ScoreController {
    private final ScoreService scoreService;
    private final ScoreRepository scoreRepository;
    private final StudentService studentService;
    private final EmployeeRepository employeeRepository;
    private final EmployeeService employeeService;
    private final Score score;

    @Autowired
    public ScoreController(ScoreService scoreService, ScoreRepository scoreRepository, StudentService studentService,
                           EmployeeRepository employeeRepository, EmployeeService employeeService,Score score) {
        this.scoreService = scoreService;
        this.scoreRepository = scoreRepository;
        this.studentService = studentService;
        this.employeeRepository = employeeRepository;
        this.employeeService = employeeService;
        this.score = score;
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

    @GetMapping("/add/{id}")
    public String addScore(@PathVariable long id, Model model) {
        Student student = studentService.findStudentById(id);
        Score score = new Score();
        score.setStudent(student);
        model.addAttribute("score", score);

        return "score/addScore.html";
    }

    @GetMapping("/edit/{id}")
    public String editScore(@PathVariable long id, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Employee employee = employeeService.findEmployeeByUsername(currentPrincipalName);
        if (currentPrincipalName.equals(score.getEmployee().getUsername())) {
            Score score = scoreService.findScoreById(id);
            model.addAttribute("score", score);
        } else {
            return "error/error-403.html";
        }

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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Employee employee = employeeService.findEmployeeByUsername(currentPrincipalName);
        score.setEmployee(employee);
        scoreRepository.save(score);
        model.addAttribute("score", score);

        return "redirect:/students/{id}/";
    }

    @GetMapping("/delete/{id}")
    public String deleteScore(@PathVariable Long id, Model model) {
        scoreService.deleteScore(id);
        List<Score> scores = scoreService.getAllScores();
        model.addAttribute("scores", scores);

        return "redirect:/scores/";
    }
}
