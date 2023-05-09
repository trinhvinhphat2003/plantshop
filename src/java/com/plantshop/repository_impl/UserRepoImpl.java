package com.plantshop.repository_impl;

import com.plantshop.entity.User;
import com.plantshop.repository.UserRepo;
import java.util.ArrayList;
import mapperEntity.AccountMapper;


public class UserRepoImpl extends GenericRepoImpl<User> implements UserRepo {

	@Override
	public ArrayList<User> findAll() {
		StringBuilder queryBuilder = new StringBuilder("select * from accounts");
		return query(queryBuilder.toString(), new AccountMapper());
	}

	@Override
	public User findByEmailAndPassword(String email, String password) {
		StringBuilder queryBuilder = new StringBuilder("select * from accounts where email=? and password=?");
		ArrayList<User> accounts = query(queryBuilder.toString(), new AccountMapper(), email, password);
		return accounts.size() == 0 ? null : accounts.get(0);
	}

	@Override
	public User findByEmail(String email) {
		StringBuilder queryBuilder = new StringBuilder("select * from accounts where email=?");
		ArrayList<User> accounts = query(queryBuilder.toString(), new AccountMapper(), email);
		return accounts.size() == 0 ? null : accounts.get(0);
	}

	@Override
	public Integer save(User account) {
		StringBuilder query = new StringBuilder("insert into accounts(email, fullname, password, phone, role, status)");
		query.append("values(?, ?, ?, ?, ?, ?)");
		return insert(query.toString(), account.getEmail(), account.getFullname(), account.getPassword(), account.getPhone(), account.getRole(), account.getStatus());
		
	}

    @Override
    public ArrayList<User> findByAccID(Integer AccID) {
        StringBuilder query = new StringBuilder("select * from accounts where accID = ?");
        return query(query.toString(), new AccountMapper(), AccID);
    }

    @Override
    public void changeFullnameAndPhone(String fullname, String phone, Integer accID) {
        StringBuilder query = new StringBuilder("update Accounts set fullname = ? and phone = ? where accid = ?");
        update(query.toString(), fullname, phone, accID);
    }

    @Override
    public void changeStatus(Integer id, Integer status) {
        StringBuilder query = new StringBuilder("update Accounts set status = ? where accid = ?");
        update(query.toString(), status, id);
    }

}
