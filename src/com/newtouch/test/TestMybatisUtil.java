package com.newtouch.test;

import com.newtouch.util.MybatisUtil;
import com.newtouch.dao.UserDao;
import com.newtouch.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author : init yo
 * @Description:
 * @E-mail 1023747751@qq.com
 * @Date: 2021/6/28 16:28
 */
public class TestMybatisUtil {
    @Test
    public void findByUsername(){
        SqlSession sqlSession = MybatisUtil.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.findByUsername("lzf");
        System.out.println(user.toString());
        sqlSession.close();
    }

    @Test
    public void findAll(){
        SqlSession sqlSession = MybatisUtil.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void findAll1(){
        UserDao userDao = (UserDao)MybatisUtil.getMapper(UserDao.class);//sqlSession
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        MybatisUtil.close();//sqlSession
    }
}
