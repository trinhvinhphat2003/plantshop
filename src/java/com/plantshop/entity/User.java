package com.plantshop.entity;

public class User {

    private Integer accID;
    private String email;
    private String password;
    private String fullname;
    private String phone;
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    private Integer role;

    public User(Integer accID, String email, String password, String fullname, String phone, Integer status,
            Integer role) {
        super();
        this.accID = accID;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.phone = phone;
        this.status = status;
        this.role = role;
    }

    public User() {
    }

    public Integer getAccID() {
        return accID;
    }

    public void setAccID(Integer accID) {
        this.accID = accID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.fullname + ", " + this.email + ", " + this.password;
    }
}
