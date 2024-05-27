package pro.sky.HomeWork6_2.service;

import org.springframework.stereotype.Service;
import pro.sky.HomeWork6_2.exeption.EmployeeNotFoundExeption;
import pro.sky.HomeWork6_2.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;

@Service
public class DepartmentServiseimpl implements DepartmentServise {
    private EmployeeService employeeService;

    public DepartmentServiseimpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee searchMaxSalaryDepartment(int department) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .max(comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundExeption::new);
    }

    @Override
    public Employee searchMinSalaryDepartment(int department) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .min(comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundExeption::new);
    }

    @Override
    public Collection<Employee> employeesDepartment(int department) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> allEmployeesDepartments() {
        return employeeService.findAll().stream()
                .collect(groupingBy(Employee::getDepartment));
    }
}
