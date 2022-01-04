package lv.unversityManagementSystem.login;

import lv.unversityManagementSystem.model.Employee;
import lv.unversityManagementSystem.model.Student;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

public class UsernameGeneration {

    public static String getEmployeeUsername(Employee employee) {
        return employee.getFirstName().substring(0, 3)
                + employee.getLastName().substring(0, 3) + getRandomNumberString();
    }

    public static String getStudentUsername(Student student) {
        return student.getFirstName().substring(0, 3)
                + student.getLastName().substring(0, 3) + getRandomNumberString();
    }

    public static String getRandomNumberString() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%04d", number);
    }
}
