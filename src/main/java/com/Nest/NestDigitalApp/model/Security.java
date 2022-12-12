package com.Nest.NestDigitalApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Security")
public class Security {

    @Id
    @GeneratedValue
    private int id;
    private String emp_Code;
    private String name;
    private String username;
    private String password;

    public Security() {
    }

    public Security(int id, String emp_Code, String name, String username, String password) {
        this.id = id;
        this.emp_Code = emp_Code;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmp_Code() {
        return emp_Code;
    }

    public void setEmp_Code(String emp_Code) {
        this.emp_Code = emp_Code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
