package com.Nest.NestDigitalApp.Controller;


import com.Nest.NestDigitalApp.Dao.EmployeeDao;
import com.Nest.NestDigitalApp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao dao;

    @CrossOrigin("*")
    @PostMapping(path = "/addEmployee", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> addEmployee(@RequestBody Employee e){

        HashMap<String, String> map = new HashMap<>();
        map.put("status", "success");
        dao.save(e);
        return map;

    }
}
