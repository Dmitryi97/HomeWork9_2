package pro.sky.HomeWork6_2.service;

import pro.sky.HomeWork6_2.exeption.EmployeeAlreadyAddedException;
import pro.sky.HomeWork6_2.exeption.EmployeeNotFoundExeption;
import pro.sky.HomeWork6_2.exeption.EmployeeStorageIsFullException;
import pro.sky.HomeWork6_2.model.Employee;


import java.util.*;

public class EmployeeServiceimpl implements EmployeService {
    private final int maxEmployee = 15;
    private final Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        String key = buildKey(firstName, lastName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() >= maxEmployee) {
            throw new EmployeeStorageIsFullException();
        }
        Employee employee = new Employee(firstName, lastName);
        employees.put(key, employee);
        return employee;
    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) {
        String key = buildKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundExeption();
        }
        return employees.remove(key);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        String key = buildKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundExeption();
        }
        return employees.get(key);
    }

    private String buildKey(String firstName, String lastName) {
        return firstName + lastName;
    }

    public List<Employee> findALL() {
        return List.copyOf(employees.values());
    }
}
