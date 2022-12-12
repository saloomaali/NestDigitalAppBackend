package com.Nest.NestDigitalApp.Controller;


import com.Nest.NestDigitalApp.Dao.EmployeeDao;
import com.Nest.NestDigitalApp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.util.Elements;
import java.nio.file.Path;
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

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/deleteEmployee", consumes = "application/json", produces = "application/json")
    public HashMap<String,String> deleteEmployee(@RequestBody Employee e){

        dao.deleteEmployee(e.getId());
        HashMap<String, String> map = new HashMap<>();
        map.put("status", "success");

        return map;

    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/employeeLogin", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> employeeLogin(@RequestBody Employee e){

        List<Employee> result = dao.employeeLogin(e.getUsername(), e.getPassword());
        HashMap<String, String> map = new HashMap<>();
        if (result.size()==0){
            map.put("status", "failed");
        }
        else {
            map.put("status", "success");
            int id = result.get(0).getId();
            map.put("employee_Id", String.valueOf(id));
        }
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewProfileEmp",consumes = "application/json", produces = "application/json")
    public List<Employee> viewProfile(@RequestBody Employee e){

        return dao.viewProfile(e.getId());

    }
}
