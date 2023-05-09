package com.plantshop.repository;

import com.plantshop.entity.User;
import java.util.ArrayList;

public interface UserRepo {
	public ArrayList<User> findAll();

	public User findByEmailAndPassword(String email, String password);

	public User findByEmail(String email);

	public Integer save(User account);

    public ArrayList<User> findByAccID(Integer AccID);

    public void changeFullnameAndPhone(String fullname, String phone, Integer accID);

    public void changeStatus(Integer id, Integer status);

}
