package com.newtouch.dao;

import com.newtouch.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : init yo
 * @Description:
 * @E-mail 1023747751@qq.com
 * @Date: 2021/6/28 10:35
 */
public interface UserDao {

    //findAll
    List<User> findAll();
    //通过名字获取User对象
    User findByUsername(@Param(value="username") String username);
    //根据username获取User对象设置其birthday字段值
    int updateSetBirthday(@Param(value="birthday")String birthday,@Param(value="username")String username);
}
