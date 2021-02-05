package com.yp.foodmall.user.service.impl;

import com.yp.foodmall.common.entity.User;
import com.yp.foodmall.user.mapper.IUserMapper;
import com.yp.foodmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Service
public class IUserServiceImpl implements UserService {
    @Autowired
    private IUserMapper iUserMapper;

    @Override
    public void registerUser(User user) {
        Date date = new Date();
        user.setCreateTime(date);
        user.setDeleteEnable(0);
        iUserMapper.insertUser(user);
    }

    @Override
    public void logoutUser(int userId) {
        iUserMapper.deleteUser(userId);
    }

    @Override
    public void updateUser(User user) {
        iUserMapper.updateUser(user);
    }

    @Override
    public User logonUser(String userName, String userPassword) {
        return iUserMapper.selectOneByUserNameAndPassword(userName, userPassword);
    }

    @Override
    public User selectOneById(int userId) {
        return iUserMapper.selectOneById(userId);
    }

    @Override
    public List<User> selectList(User user) {
        return null;
    }
}
