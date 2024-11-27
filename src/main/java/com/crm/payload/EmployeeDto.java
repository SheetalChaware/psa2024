package com.crm.payload;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EmployeeDto {
    private Long id;
    private String name;
    private String emailId;
    private String mobile;
    private Date date;

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setId(Long id) {
        this.id = id;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public long getId() {
        return id;
    }

    public void setdate(Date date) {
        this.date = date;

    }
}










