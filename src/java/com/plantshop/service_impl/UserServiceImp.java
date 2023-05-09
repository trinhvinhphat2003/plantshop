package com.plantshop.service_impl;

import com.plantshop.constant.AuthenticationConst;
import com.plantshop.constant.StatusConst;
import com.plantshop.entity.User;
import com.plantshop.repository.UserRepo;
import com.plantshop.repository_impl.UserRepoImpl;
import com.plantshop.service.CartService;
import com.plantshop.service.UserService;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class UserServiceImp implements UserService {

    private UserRepo userRepo = new UserRepoImpl();

    private CartService cartService = new CartServiceImpl();

    @Override
    public ArrayList<User> findAll() {
        ArrayList<User> users = userRepo.findAll();
        return users.size() == 0 ? null : users;
    }

    @Override
    public User Authen(String email, String password, HttpServletRequest req) {
        User account = userRepo.findByEmail(email);

        if (account == null) {
            req.setAttribute("errorMsg", "404 Not found");
            return null;
        } else if (!password.equals(account.getPassword())) {
            req.setAttribute("errorMsg", "wrong password");
            return null;
        } else {
            return account;
        }
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return userRepo.findByEmailAndPassword(email, password);
    }

    @Override
    public Integer signup(String email, String password, String fullname) {
        User user = new User(null, email, password, fullname, "", StatusConst.ACTIVE, AuthenticationConst.MEMBER);
        Integer accID = userRepo.save(user);
        if (user != null) {
            Integer cartID = cartService.createCartByAccID(accID);
        }
        return accID;
    }

    @Override
    public User findByAccID(Integer AccID) {
        ArrayList<User> users = userRepo.findByAccID(AccID);
        return users.size() == 0 ? null : users.get(0);
    }

    @Override
    public Object findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public void changeFullnameAndPhone(String fullname, String phone, Integer accID) {
        userRepo.changeFullnameAndPhone(fullname, phone, accID);
    }

    @Override
    public void changeStatus(Integer id, Integer status) {
        userRepo.changeStatus(id, status);
    }

}
