package com.RestApi.repository;

import com.RestApi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    public List<Employee> findByName(String name);

    //**   SELECT * FROM employee_management WHERE name="Mukesh" AND location="Noida";

    public List<Employee> findByNameAndLocation(String name,String location);
}
