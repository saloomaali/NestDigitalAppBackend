package com.Nest.NestDigitalApp.Dao;

import com.Nest.NestDigitalApp.model.LeaveApply;
import com.Nest.NestDigitalApp.model.LeaveCounter;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface LeaveDao extends CrudRepository<LeaveApply, Integer> {

    @Query(value = "SELECT  e.`emp_id`, e.`name`,l.apply_date,l.from_date,l.to_date,l.leave_type,l.status FROM `employee` e JOIN leave_apply l ON e.id = l.emp_id",nativeQuery = true)
    List<Map<String,String>> ViewAllLeave();
    @Modifying
    @Transactional
    @Query(value = "UPDATE `leave_apply` SET `status`= :status WHERE `emp_id` = :emp_id",nativeQuery = true)
    void UpdateStatus(int emp_id, int status);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `leave_counter` SET `casual_leave`= :casual_leave,`sick_leave`= :sick_leave,`special_leave`= :special_leave WHERE `emp_id` = :emp_id",nativeQuery = true)
    void acceptLeave(int casual_leave,int sick_leave,int special_leave , int emp_id);

    @Query(value = "SELECT `casual_leave`, `sick_leave`, `special_leave` FROM `leave_counter` WHERE `emp_id` = :emp_id", nativeQuery = true)
    List<LeaveCounter> getLeaveDetails(int emp_id);

    @Query(value = "SELECT `apply_date`, `emp_id`, `from_date`, `leave_type`, `remarks`, `status`, `to_date` FROM `leave_apply` WHERE `emp_id` = :emp_id ", nativeQuery = true)
    List<LeaveApply> viewLeave(int emp_id);


}
