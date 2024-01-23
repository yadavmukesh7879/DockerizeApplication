package com.RestApi.controller;

import com.RestApi.model.Employee;
import com.RestApi.service.EmployeeService;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @MutationMapping("createEmployee")
    public Employee addEmployee(@Valid @Argument EmployeeInput employee) {
        Employee emp = new Employee();
        emp.setAge(employee.getAge());
        emp.setDepartment(employee.getDepartment());
        emp.setName(employee.getName());
        emp.setEmail(employee.getEmail());
        emp.setLocation(employee.getLocation());
        return employeeService.createEmployee(emp);
    }

    @QueryMapping("getAllEmployee")
    public List<Employee> getAllEmployee() {
        return employeeService.getEmployees();
    }

    @QueryMapping("getEmployeeById")
    public Employee employeeById(@Argument Long id) {
        return employeeService.getEmployeeByID(id);
    }

    @MutationMapping("updateEmployee")
    public Employee updateEmployee(@Argument EmployeeInput employee, @Argument Long id) {
        Employee emp = new Employee();
        emp.setId(id);
        emp.setAge(employee.getAge());
        emp.setDepartment(employee.getDepartment());
        emp.setName(employee.getName());
        emp.setEmail(employee.getEmail());
        emp.setLocation(employee.getLocation());
        return employeeService.updateEmployee(emp);
    }

    @MutationMapping("deleteEmployee")
    public DeleteResponse deleteEmployee(@Argument Long id) {
        employeeService.deleteEmployee(id);
        return new DeleteResponse(true, "Data Deleted successfully");
    }

    @GetMapping("/employee/filterByName")
    public ResponseEntity<List<Employee>> getEmployeeByName(@RequestParam String name) {
        return new ResponseEntity<List<Employee>>(employeeService.getByName(name), HttpStatus.OK);
    }

    @GetMapping("/employee/filterByNameAndLocation")
    public ResponseEntity<List<Employee>> getEmployeeByNameAndLocation(@RequestParam String name, @RequestParam String location) {
        return new ResponseEntity<List<Employee>>(employeeService.getByNameAndLocation(name, location), HttpStatus.OK);
    }
}

@Getter
@Setter
class EmployeeInput {
    private String name;
    private Long age = 0L;
    private String location;
    private String email;
    private String department;
}


@AllArgsConstructor
@NoArgsConstructor
class DeleteResponse {
    private boolean success;
    private String message;
}