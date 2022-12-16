package com.Nest.NestDigitalApp.Controller;


import com.Nest.NestDigitalApp.Dao.EmployeeDao;
import com.Nest.NestDigitalApp.Dao.LeaveCounterDao;
import com.Nest.NestDigitalApp.model.Employee;
import com.Nest.NestDigitalApp.model.LeaveCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.util.Elements;
import java.nio.file.Path;
import java.time.Year;
import java.util.HashMap;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao dao;

    @Autowired
    private LeaveCounterDao daoc;

    int year = Year.now().getValue();



    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addEmployee", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> addEmployee(@RequestBody Employee e){

        HashMap<String, String> map = new HashMap<>();


        dao.save(e);

            LeaveCounter c = new LeaveCounter();
            c.setEmpId(e.getId());
            c.setCasualLeave(20);
            c.setSickLeave(7);
            c.setSpecialLeave(3);
            c.setYear(String.valueOf(year));
            daoc.save(c);

            map.put("EmployeeId",String.valueOf(e.getId()));
            map.put("status", "success");





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
    @PostMapping(path = "/editEmployee", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> editEmployee(@RequestBody Employee e)
    {
        dao.editEmployee(e.getDesignation(),e.getEmail_Id(),e.getEmpId(),e.getName(),e.getSalary(), e.getId());
        HashMap<String, String> map = new HashMap<>();
        map.put("status", "success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/changePassword", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> changePassword(@RequestBody Employee e){

        dao.changePassword(e.getPassword(),e.getUsername(),e.getId());
        HashMap<String, String> map = new HashMap<>();
        map.put("status", "success");
        return map;
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
