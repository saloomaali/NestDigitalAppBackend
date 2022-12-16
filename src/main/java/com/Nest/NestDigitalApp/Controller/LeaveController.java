package com.Nest.NestDigitalApp.Controller;


import com.Nest.NestDigitalApp.Dao.LeaveDao;
import com.Nest.NestDigitalApp.model.Employee;
import com.Nest.NestDigitalApp.model.LeaveApply;
import com.Nest.NestDigitalApp.model.LeaveCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LeaveController {

    @Autowired
    private LeaveDao dao;



    Date currentDate = new Date();



    @CrossOrigin(origins = "*")
    @PostMapping(path = "/applyLeave", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> applyLeave(@RequestBody LeaveApply l){


        l.setApplyDate(String.valueOf(currentDate));
        l.setStatus(0);

        dao.save(l);

        HashMap<String, String> map = new HashMap<>();
        map.put("status", "success");
        return map;

    }
    @CrossOrigin(origins = "*")
    @GetMapping("/viewLeave")
    public List<Map<String,String>> ViewAllLeave()
    {
        return  dao.ViewAllLeave();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/update",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> UpdateStatus(@RequestBody LeaveApply l)
    {


        dao.UpdateStatus(l.getEmpId(),l.getStatus());
        List<LeaveApply> l2 = dao.viewLeave(l.getEmpId());

        List<LeaveCounter> l1 = dao.getLeaveDetails(l.getEmpId());
        String leaveType = l.getLeaveType();
        LocalDate formDate = LocalDate.parse(l.getFromDate());
        LocalDate toDate = LocalDate.parse(l.getToDate());


        int noOfDays = (int) ChronoUnit.DAYS.between(formDate,toDate) + 1;
        if (leaveType == "casual_leave"){
            dao.acceptLeave((l1.get(0).getCasualLeave()-noOfDays),l1.get(0).getSickLeave(),l1.get(0).getSpecialLeave(), l.getEmpId());

        } else if (leaveType == "sick_leave") {

            dao.acceptLeave(l1.get(0).getCasualLeave(),(l1.get(0).getSickLeave()-noOfDays),l1.get(0).getSpecialLeave(), l.getEmpId());
            
        }
        else{
            dao.acceptLeave(l1.get(0).getCasualLeave(),l1.get(0).getSickLeave(),(l1.get(0).getSpecialLeave()-noOfDays), l.getEmpId());
        }


        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }

}

