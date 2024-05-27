package pro.sky.HomeWork6_2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.HomeWork6_2.model.Employee;
import pro.sky.HomeWork6_2.service.DepartmentServiseimpl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentServiseimpl departmentServise;

    public DepartmentController(DepartmentServiseimpl departmentServise) {
        this.departmentServise = departmentServise;
    }

    @GetMapping("/max-salary")
    public Employee maxSalaryDepartment(@RequestParam int department) {
        return departmentServise.searchMaxSalaryDepartment(department);
    }

    @GetMapping("/min-salary")
    public Employee minSalaryDepartment(@RequestParam int departmeny) {
        return departmentServise.searchMinSalaryDepartment(departmeny);
    }

    @GetMapping(value = "/all", params = {"departmen"})
    public Collection<Employee> allDepartment(@RequestParam int departmen) {
        return departmentServise.employeesDepartment(departmen);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> all() {
        return departmentServise.allEmployeesDepartments();
    }
}