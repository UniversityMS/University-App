package lv.unversityManagementSystem.controller;


import lv.unversityManagementSystem.login.PasswordGeneration;
import lv.unversityManagementSystem.login.UsernameGeneration;
import lv.unversityManagementSystem.model.Employee;
import lv.unversityManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> gelAllEmployees() {  //ResponseEntity and List are generic, need to specify what type of data is going to be.
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);  //http status for users let to know that everything is OK
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public List<Employee> addEmployee(@RequestBody Employee employee) {
        employee.setUsername(UsernameGeneration.getEmployeeUsername(employee));
        employee.setPassword(PasswordGeneration.generateRandomPassword(10));
        employee.setRole("lecturer");
        employeeService.save(employee);
        List<Employee> lst = new ArrayList<>();
        lst.add(employee);
        return lst;
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {  //void method doesn't return anything< reason why placing question mark
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
