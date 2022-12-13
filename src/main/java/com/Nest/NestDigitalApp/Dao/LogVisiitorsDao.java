package com.Nest.NestDigitalApp.Dao;


import com.Nest.NestDigitalApp.model.LogEmployee;
import com.Nest.NestDigitalApp.model.LogVisitors;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LogVisiitorsDao extends CrudRepository<LogVisitors, Integer> {

    @Query(value = "SELECT `id`, `date`, `entry_time`, `exit_time`, `name`, `purpose`, `whom_to_meet` FROM `log_visitors` WHERE `date` = :date", nativeQuery = true)
    List<LogVisitors> getLog(String date);
}
