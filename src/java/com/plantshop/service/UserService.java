package com.plantshop.service;

import com.plantshop.entity.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public interface UserService {

    public ArrayList<User> findAll();

    public User Authen(String email, String password, HttpServletRequest req);

    public User findByEmailAndPassword(String email, String password);

    public Integer signup(String email, String password, String fullname);

    public User findByAccID(Integer AccID);

    public Object findByEmail(String email);

    public void changeFullnameAndPhone(String fullname, String phone, Integer accID);

    public void changeStatus(Integer id, Integer status);
}
