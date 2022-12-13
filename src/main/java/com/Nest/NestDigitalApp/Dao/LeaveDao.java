package com.Nest.NestDigitalApp.Dao;

import com.Nest.NestDigitalApp.model.LeaveApply;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface LeaveDao extends CrudRepository<LeaveApply, Integer> {

    @Query(value = "SELECT  e.`emp_id`, e.`name` l.leave_type, l.from_date, l.to_date, l.apply_date, l.status FROM `employee` JOIN leave_apply l ON e.id = l.emp_id",nativeQuery = true)
    List<Map<String,String>> ViewAllLeave();
    @Modifying
    @Transactional
    @Query(value = "UPDATE `leave_apply` SET `status`= :status WHERE `emp_id` = :emp_id",nativeQuery = true)
    void UpdateStatus(int emp_id, int status);
}
