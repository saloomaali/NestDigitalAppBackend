package com.Nest.NestDigitalApp.Dao;

import com.Nest.NestDigitalApp.model.Employee;
import com.Nest.NestDigitalApp.model.Security;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SecurityDao extends CrudRepository<Security, Integer> {


    @Query(value = "SELECT `id`, `emp_code`, `name`, `password`, `username` FROM `security` WHERE `username` = :username AND `password` = :password",nativeQuery = true)
    List<Security> securityLogin(String username, String password);

    @Query(value = "SELECT `id`, `emp_code`, `name`, `password`, `username` FROM `security` WHERE `id` = :id", nativeQuery = true)
    List<Security> viewProfileSec(int id);
}
