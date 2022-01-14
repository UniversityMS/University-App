package lv.unversityManagementSystem.controller;

import lv.unversityManagementSystem.domain.Role;
import lv.unversityManagementSystem.domain.Student;
import lv.unversityManagementSystem.login.PasswordGeneration;
import lv.unversityManagementSystem.login.UsernameGeneration;
import lv.unversityManagementSystem.repository.StudentRepository;
import lv.unversityManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentService studentService, StudentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/")
    public String getAllStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);

        return "student/studentList.html";
    }

    @GetMapping("/{id}")
    public String getStudentById(@PathVariable long id, Model model) {
        Student student = studentService.findStudentById(id);
        model.addAttribute("student", student);

        return "student/viewStudent.html";
    }

    @GetMapping("/add")
    public String addStudent(Model model){
        Student student = new Student();
        model.addAttribute("student", student);

        return "student/addStudent.html";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable long id, Model model) {
        Student student= studentService.findStudentById(id);
        model.addAttribute("student", student);

        return "student/editStudent.html";
    }

    @PostMapping("/update")
    public String updateStudent(Student student, Model model) {
        Student updateStudent = studentService.updateStudent(student);
        student = studentService.findStudentById(updateStudent.getId());
        model.addAttribute("student", student);

        return "redirect:/students/";
    }

    @PostMapping("/save")
    public String saveStudent(Student student, Model model) {
        student.setUsername(UsernameGeneration.getStudentUsername(student));
        student.setPassword(PasswordGeneration.generateRandomPassword(10));
        student.setRole(Role.STUDENT);
        studentRepository.save(student);
        model.addAttribute("student", student);

        return "student/newStudent.html";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id, Model model) {
        studentService.deleteStudent(id);
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);

        return "redirect:/students/";
    }
}