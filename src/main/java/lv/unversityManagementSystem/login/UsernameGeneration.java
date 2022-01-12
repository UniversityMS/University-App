package lv.unversityManagementSystem.login;

import lv.unversityManagementSystem.domain.Employee;
import lv.unversityManagementSystem.domain.Student;
import lv.unversityManagementSystem.domain.User;

import java.util.Random;

public class UsernameGeneration {

    public static String getEmployeeUsername(Employee employee) {
        return employee.getName().substring(0, 3)
                + employee.getSurname().substring(0, 3) + getRandomNumberString();
    }

    public static String getStudentUsername(Student student) {
        return student.getName().substring(0, 3)
                + student.getSurname().substring(0, 3) + getRandomNumberString();
    }

    public static String getUserUsername(User user) {
        return user.getName().substring(0, 3)
                + user.getSurname().substring(0, 3) + getRandomNumberString();
    }

    public static String getRandomNumberString() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%04d", number);
    }
}
