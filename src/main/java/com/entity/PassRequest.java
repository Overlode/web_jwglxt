package com.entity;

import java.util.Date;

public class PassRequest {
    private int confirm;
    private int sid;
    private int id;
    private String email;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getConfirm() {
        return confirm;
    }

    public void setConfirm(int confirm) {
        this.confirm = confirm;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PassRequest(int confirm, int sid, int id) {
        this.confirm = confirm;
        this.sid = sid;
        this.id = id;
    }
}
