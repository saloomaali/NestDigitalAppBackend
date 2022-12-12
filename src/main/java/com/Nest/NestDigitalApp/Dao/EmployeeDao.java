package com.Nest.NestDigitalApp.Dao;

import com.Nest.NestDigitalApp.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {


    @Query(value = "SELECT `id`, `designation`, `email_id`, `emp_id`, `name`, `password`, `salary`, `username` FROM `employee` WHERE `emp_id` = :emp_id", nativeQuery = true)
    List<Employee> searchEmployee(int emp_id);
}
