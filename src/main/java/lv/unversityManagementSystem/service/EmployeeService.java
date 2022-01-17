package lv.unversityManagementSystem.service;


import lv.unversityManagementSystem.exception.DataWithThisIdNotFoundException;
import lv.unversityManagementSystem.domain.Employee;
import lv.unversityManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id).orElseThrow(() -> new DataWithThisIdNotFoundException("Employee" +
                " by id " + id + " was not found!"));
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> findEmployeeByName(String name) {
        return employeeRepository.findEmployeeByName(name);
    }

    public List<Employee> findEmployeeBySurname(String surname) {
        return employeeRepository.findEmployeeBySurname(surname);
    }

    public Employee findEmployeeByUsername(String username) {
        return employeeRepository.findByUsername(username).orElseThrow(() -> new DataWithThisIdNotFoundException("Employee" +
                " by username " + username + " was not found!"));
    }
}
