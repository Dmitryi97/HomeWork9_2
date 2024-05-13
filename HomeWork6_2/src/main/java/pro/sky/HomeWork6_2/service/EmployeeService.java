package pro.sky.HomeWork6_2.service;

import pro.sky.HomeWork6_2.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, int department, double salary);

    Employee deleteEmployee(String firstName, String lastName, int department, double salary);

    Employee findEmployee(String firstName, String lastName, int department, double salary);

    Collection<Employee> findAll();
}
