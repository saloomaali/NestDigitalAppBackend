package com.Nest.NestDigitalApp.Controller;

import com.Nest.NestDigitalApp.Dao.LogEmployeeDao;
import com.Nest.NestDigitalApp.Dao.LogVisiitorsDao;
import com.Nest.NestDigitalApp.model.LogEmployee;
import com.Nest.NestDigitalApp.model.LogVisitors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class LogController {

    @Autowired
    private LogEmployeeDao daoe;

    @Autowired
    private LogVisiitorsDao daov;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addLogEmployee", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> addLogEmployee(@RequestBody LogEmployee e){

        daoe.save(e);
        HashMap<String, String> map = new HashMap<>();
        map.put("status", "success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewLog")
    public List<LogEmployee> viewLogEmployee(){
        return (List<LogEmployee>) daoe.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewLogDate", consumes = "application/json", produces = "application/json")
    public List<LogEmployee> viewByDate(@RequestBody LogEmployee e){

        return daoe.getLog(e.getDate());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addLogVisitors", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> addLogVisitors(@RequestBody LogVisitors v){

        daov.save(v);
        HashMap<String, String> map = new HashMap<>();
        map.put("status", "success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/viewLogVisitors")
    public List<LogVisitors> viewLogVisitors(){
        return (List<LogVisitors>) daov.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewLogDateVisitors", consumes = "application/json", produces = "application/json")
    public List<LogVisitors> viewByDate(@RequestBody LogVisitors e){

        return daov.getLog(e.getDate());
    }



}
