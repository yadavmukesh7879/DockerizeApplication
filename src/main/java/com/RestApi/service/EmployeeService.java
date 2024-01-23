package com.RestApi.service;

import com.RestApi.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public List<Employee> getEmployees();

    public Employee createEmployee(Employee employee);

    public Employee getEmployeeByID(Long id);

    public Employee updateEmployee(Employee employee);

    public void deleteEmployee(Long Id);
    public List<Employee> getByName(String name);

    public List<Employee> getByNameAndLocation(String name, String location);
}
