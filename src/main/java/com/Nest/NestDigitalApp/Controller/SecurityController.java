package com.Nest.NestDigitalApp.Controller;


import com.Nest.NestDigitalApp.Dao.SecurityDao;
import com.Nest.NestDigitalApp.model.Employee;
import com.Nest.NestDigitalApp.model.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class SecurityController {

    @Autowired
    private SecurityDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addSecurity", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> addSecurity(@RequestBody Security s){

        dao.save(s);
        HashMap<String, String> map = new HashMap<>();
        map.put("status", "success");
        return map;

    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/securityLogin", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> securityLogin(@RequestBody Security s){

        List<Security> result =  dao.securityLogin(s.getUsername(), s.getPassword());
        HashMap<String, String> map = new HashMap<>();

        if (result.size() == 0){
            map.put("status","failed");
        }
        else {
            map.put("status", "success");
            map.put("security_id", String.valueOf(result.get(0).getId()));

        }

        return map;

    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewProfileSec",consumes = "application/json", produces = "application/json")
    public List<Security> viewProfile(@RequestBody Security s){

        return dao.viewProfileSec(s.getId());

    }
}
