package com.yp.foodmall.user.service;

import com.yp.foodmall.common.entity.User;

import java.util.List;

public interface UserService {
    public void registerUser(User user);
    public void logoutUser(int userId);
    public void updateUser(User user);
    public User logonUser(String userName, String userPassword);
    public User selectOneById(int userId);
    public List<User> selectList(User user);
}
