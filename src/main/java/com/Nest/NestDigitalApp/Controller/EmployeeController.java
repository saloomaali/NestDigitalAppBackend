package com.Nest.NestDigitalApp.Controller;


import com.Nest.NestDigitalApp.Dao.EmployeeDao;
import com.Nest.NestDigitalApp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addEmployee", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> addEmployee(@RequestBody Employee e){

        HashMap<String, String> map = new HashMap<>();
        map.put("status", "success");
        dao.save(e);
        return map;

    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewEmployee")
    public List<Employee> viewEmployee(){
        return (List<Employee>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchEmployee", consumes = "application/json", produces = "application/json")
    public List<Employee> searchEmployee(@RequestBody Employee e){

        return dao.searchEmployee(e.getEmpId());

    }


}
