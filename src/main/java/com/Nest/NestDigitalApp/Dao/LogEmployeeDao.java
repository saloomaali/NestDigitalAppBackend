package com.Nest.NestDigitalApp.Dao;


import com.Nest.NestDigitalApp.model.LogEmployee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LogEmployeeDao extends CrudRepository<LogEmployee, Integer> {


    @Query(value = "SELECT `id`, `date`, `emp_id`, `entry_time`, `exit_time` FROM `log_employee` WHERE `date` = :date", nativeQuery = true)
    List<LogEmployee> getLog(String date);
}
