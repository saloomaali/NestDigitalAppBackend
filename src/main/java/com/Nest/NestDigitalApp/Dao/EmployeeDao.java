package com.Nest.NestDigitalApp.Dao;

import com.Nest.NestDigitalApp.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
}
