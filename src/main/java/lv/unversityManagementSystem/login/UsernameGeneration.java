package lv.unversityManagementSystem.login;

import lv.unversityManagementSystem.model.Employee;

public class UsernameGeneration {

    public static String getUsername(Employee employee){
        //Employee employee = new Employee();

        return employee.getFirstName().substring(0, 3)
                + employee.getLastName().substring(0,3) + employee.getId();
    }
}
