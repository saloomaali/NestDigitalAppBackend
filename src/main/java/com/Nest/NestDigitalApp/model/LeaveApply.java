package com.Nest.NestDigitalApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "LeaveApply")
public class LeaveApply {

    @Id
    @GeneratedValue
    private int id;
    private int empId;

    private String leaveType;
    private String remarks;
    private String fromDate;
    private String toDate;
    private String applyDate;
    private int status;

    public LeaveApply() {
    }

    public LeaveApply(int id, int empId, String date, String leaveType, String remarks, String fromDate, String toDate, String applyDate, int status) {
        this.id = id;
        this.empId = empId;

        this.leaveType = leaveType;
        this.remarks = remarks;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.applyDate = applyDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }



    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getApplyDate(Date currentDate) {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
