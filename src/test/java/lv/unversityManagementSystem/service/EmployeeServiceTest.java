//package lv.unversityManagementSystem.service;
//
//import lv.unversityManagementSystem.repository.EmployeeRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.mockito.Mockito.verify;
//
//@ExtendWith(MockitoExtension.class)
//class EmployeeServiceTest {
//
//    @Mock
//    private EmployeeRepository employeeRepositoryTest;
//    private EmployeeService employeeServiceTest;
//
//    @BeforeEach
//    void setUp() {
//        employeeServiceTest = new EmployeeService(employeeRepositoryTest);
//    }
//
//
//    @Test
//    void getAllEmployees() {
//        //when
//        employeeServiceTest.getAllEmployees();
//        //then
//        verify(employeeRepositoryTest).findAll();
//    }
//
//    @Test
//    void updateEmployee() {
//    }
//
//    @Test
//    void findEmployeeById() {
//    }
//
//    @Test
//    void deleteEmployee() {
//    }
//
//    @Test
//    void save() {
//    }
//}