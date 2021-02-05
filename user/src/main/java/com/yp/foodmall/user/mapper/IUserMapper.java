package com.yp.foodmall.user.mapper;

import com.yp.foodmall.common.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IUserMapper {
    public int insertUser(User user);
    public int deleteUser(int userId);
    public int updateUser(User user);
    public User selectOneByUserNameAndPassword(@Param("userName") String userName, @Param("userPassword") String password);
    public User selectOneById(int userId);
    public List<User> selectList(User user);
}
