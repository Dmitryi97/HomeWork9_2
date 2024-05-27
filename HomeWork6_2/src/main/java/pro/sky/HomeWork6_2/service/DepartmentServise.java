package pro.sky.HomeWork6_2.service;

import pro.sky.HomeWork6_2.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentServise {
    Employee searchMaxSalaryDepartment(int department);

    Employee searchMinSalaryDepartment(int department);

    Collection<Employee> employeesDepartment(int department);

    Map<Integer, List<Employee>> allEmployeesDepartments();
}