package lv.unversityManagementSystem.controller;


import lv.unversityManagementSystem.domain.Employee;
import lv.unversityManagementSystem.domain.Role;
import lv.unversityManagementSystem.domain.Student;
import lv.unversityManagementSystem.login.PasswordGeneration;
import lv.unversityManagementSystem.login.UsernameGeneration;
import lv.unversityManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;



    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
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

    @PostMapping("/add")
    public List<Student> addStudent(@RequestBody Student student){
        student.setUsername(UsernameGeneration.getStudentUsername(student));
        student.setPassword(PasswordGeneration.generateRandomPassword(10));
        student.setRole(Role.STUDENT);
        studentService.save(student);
        List<Student> lst = new ArrayList<>();
        lst.add(student);
        return lst;
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable long id, Model model) {
        Student student= studentService.findStudentById(id);
//        student = studentService.editStudent(student);
        model.addAttribute("student", student);

        return "student/editStudent.html";
    }
    @PutMapping("/update")
    public String updateStudent(@RequestBody Student student, Model model) {
        Student updateStudent = studentService.updateStudent(student);
        model.addAttribute("student", student);

        return "student/editStudent";}

    @Transactional
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
