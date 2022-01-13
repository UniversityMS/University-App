package lv.unversityManagementSystem.controller;


import lv.unversityManagementSystem.login.PasswordGeneration;
import lv.unversityManagementSystem.login.UsernameGeneration;
import lv.unversityManagementSystem.domain.Employee;
import lv.unversityManagementSystem.domain.Role;
import lv.unversityManagementSystem.service.EmployeeService;
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
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public String getAllEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);

        return "employee/employeeList.html";
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
        employee.setRole(Role.LECTURER);
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
