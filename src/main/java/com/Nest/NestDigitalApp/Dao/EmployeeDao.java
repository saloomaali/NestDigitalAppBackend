package com.Nest.NestDigitalApp.Dao;

import com.Nest.NestDigitalApp.model.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {


    @Query(value = "SELECT `id`, `designation`, `email_id`, `emp_id`, `name`, `password`, `salary`, `username` FROM `employee` WHERE `emp_id` = :emp_id", nativeQuery = true)
    List<Employee> searchEmployee(int emp_id);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `employee` WHERE `id` = :id", nativeQuery = true)
    void deleteEmployee(int id);

    @Query(value = "SELECT `id`, `designation`, `email_id`, `emp_id`, `name`, `password`, `salary`, `username` FROM `employee` WHERE `username` = :username AND `password` = :password", nativeQuery = true)
    List<Employee> employeeLogin(String username, String password);

    @Query(value = "SELECT `id`, `designation`, `email_id`, `emp_id`, `name`, `password`, `salary`, `username` FROM `employee` WHERE `id` = :id", nativeQuery = true)
    List<Employee> viewProfile(int id);


//
//    @Query(value = "SELECT `id`, `designation`, `email_id`, `emp_id`, `name`, `password`, `salary`, `username` FROM `employee` WHERE `emp_id` = :emp_id", nativeQuery = true)
//    List<Employee> userId(int emp_id);
}


