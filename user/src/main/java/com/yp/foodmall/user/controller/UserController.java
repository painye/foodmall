package com.yp.foodmall.user.controller;

import com.yp.foodmall.common.entity.User;
import com.yp.foodmall.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/user")
@Api(tags = "user模块的测试")
public class UserController {
    @Autowired
    private UserService userService;

    @PutMapping("/register.do")
    @ApiOperation("用户注册")
    public void registerUser(@RequestBody User user){
        System.out.println(user);
        userService.registerUser(user);
    }

    @GetMapping("/logon.do")
    @ApiOperation("用户登录")
    public User logonUser(String userName, String userPassword){
        User user = userService.logonUser(userName, userPassword);
        System.out.println(user);
        return user;
    }

    @DeleteMapping("/logout.do")
    @ApiOperation("注销用户")
    public void logoutUser(int userId){
        userService.logoutUser(userId);
    }

    @PostMapping("/updateUser.do")
    @ApiOperation("修改用户基本信息")
    public void updateUser(User user){
        userService.updateUser(user);
    }

    @GetMapping("/selectUserById.do")
    @ApiOperation("根据用户的id查找用户")
    public User selectUserById(int userId){
        User user = userService.selectOneById(userId);
        return user;
    }

}
