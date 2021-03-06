package lv.unversityManagementSystem.controller;


import lv.unversityManagementSystem.login.PasswordGeneration;
import lv.unversityManagementSystem.login.UsernameGeneration;
import lv.unversityManagementSystem.domain.Employee;
import lv.unversityManagementSystem.domain.Role;
import lv.unversityManagementSystem.repository.EmployeeRepository;
import lv.unversityManagementSystem.repository.ScoreRepository;
import lv.unversityManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;
    private final ScoreRepository scoreRepository;

    @Autowired
    public EmployeeController(EmployeeService employeeService, EmployeeRepository employeeRepository, ScoreRepository scoreRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
        this.scoreRepository = scoreRepository;
    }

    @GetMapping("/")
    public String getAllEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);

        return "employee/employeeList.html";
    }

    @GetMapping("/{id}")
    public String getEmployeeById(@PathVariable long id, Model model) {
        Employee employee = employeeService.findEmployeeById(id);
        model.addAttribute("employee", employee);

        return "employee/viewEmployee.html";
    }

    @GetMapping("/find")
    public String getEmployeeByName(@RequestParam String name, Model model) {
        List<Employee> employees = employeeService.findEmployeeByName(name);

        if (employees.isEmpty()) {
            employees = employeeService.findEmployeeBySurname(name);
        }

        if (employees.isEmpty()) {
            return "redirect:/employees/";
        }

        model.addAttribute("employees", employees);

        return "employee/employeeList.html";
    }

    @GetMapping("/add")
    public String addEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employee/addEmployee.html";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable long id, Model model) {
        Employee employee = employeeService.findEmployeeById(id);
        model.addAttribute("employee", employee);

        return "employee/editEmployee.html";
    }

    @PostMapping("/update")
    public String updateEmployee(Employee employee, Model model) {
        Employee updateEmployee = employeeService.updateEmployee(employee);
        employee = employeeService.findEmployeeById(updateEmployee.getId());
        model.addAttribute("employee", employee);

        return "redirect:/employees/";
    }

    @PostMapping("/save")
    public String saveEmployee(Employee employee, Model model) {
        employee.setUsername(UsernameGeneration.getEmployeeUsername(employee));
        employee.setPassword(PasswordGeneration.generateRandomPassword(10));
        employee.setRole(Role.LECTURER);  //maybe delete this row
        employeeRepository.save(employee);
        model.addAttribute("employee", employee);

        return "employee/newEmployee.html";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id, Model model) {
        employeeService.deleteEmployee(id);
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);

        return "redirect:/employees/";
    }

}
