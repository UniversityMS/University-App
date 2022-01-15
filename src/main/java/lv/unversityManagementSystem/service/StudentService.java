package lv.unversityManagementSystem.service;


import lv.unversityManagementSystem.exception.DataWithThisIdNotFoundException;
import lv.unversityManagementSystem.domain.Student;
import lv.unversityManagementSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudentById(Long id) {
        return studentRepository.findStudentById(id).orElseThrow(() -> new DataWithThisIdNotFoundException("Student" +
                " by id " + id + " was not found!"));
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> findStudentByName(String name) {
        return studentRepository.findStudentByName(name);
    }

    public List<Student> findStudentBySurname(String surname) {
        return studentRepository.findStudentBySurname(surname);
    }
}

