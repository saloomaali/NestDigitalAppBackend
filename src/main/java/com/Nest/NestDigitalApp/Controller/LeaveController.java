package com.Nest.NestDigitalApp.Controller;


import com.Nest.NestDigitalApp.Dao.LeaveDao;
import com.Nest.NestDigitalApp.model.LeaveApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LeaveController {

    @Autowired
    private LeaveDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/applyLeave", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> applyLeave(@RequestBody LeaveApply l){

        dao.save(l);


        l.setStatus(0);

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
    public Map<String,String> UpdateStatus(@RequestBody LeaveApply l)
    {

        dao.UpdateStatus(l.getEmpId(),l.getStatus());

        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }

}

