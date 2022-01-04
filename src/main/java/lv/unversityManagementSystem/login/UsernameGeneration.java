package lv.unversityManagementSystem.login;

import lv.unversityManagementSystem.model.Employee;

public class UsernameGeneration {

    public static String getUsername(Employee employee) {
        return employee.getFirstName().substring(0, 3)
                + employee.getLastName().substring(0, 3) + employee.getId();
    }
}
