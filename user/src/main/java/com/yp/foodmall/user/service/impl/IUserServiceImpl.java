package com.yp.foodmall.user.service.impl;

import com.yp.foodmall.common.entity.Commodity;
import com.yp.foodmall.common.entity.User;
import com.yp.foodmall.user.mapper.IUserMapper;
import com.yp.foodmall.user.service.UserService;
import io.swagger.models.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Service
public class IUserServiceImpl implements UserService {
    @Autowired
    private IUserMapper iUserMapper;
    @Autowired
    RestTemplate restTemplate;

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
        User user;

//        restTemplate.execute("http://localhost:8099/app/foodmall/registerr.do", );

        List<Commodity> commodity = restTemplate.getForObject("http://localhost:8099/app/food/commodity/findCommodityList.do?comName=三只松鼠坚果大礼包", List.class);
        System.out.println(commodity);
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
