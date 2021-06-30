package com.newtouch.test;

import com.newtouch.dao.UserDao;
import com.newtouch.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * @author : init yo
 * @Description:
 * @E-mail 1023747751@qq.com
 * @Date: 2021/6/28 9:22
 */
public class TestMybatis {

    InputStream resourceAsStream;
    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;
    UserDao userMapper;

    @Before
    public void getMapper() throws Exception {
        resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");//加载Mybatis的核心配置文件
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);// 构建SqlSessionFactory工厂
        sqlSession = sqlSessionFactory.openSession();//通过SqlSessionFactory工厂构建sqlSession对象
        userMapper = sqlSession.getMapper(UserDao.class);//通过dao接口获取实现类对象
    }

    @Test
    public void testFindByUsername() {
        User user = userMapper.findByUsername("lzf");
        System.out.println(user.toString());
        sqlSession.close();
    }

    @Test
    public void testUpdateSetBirhtday(){
        int isUpdateSuccess = userMapper.updateSetBirthday("1997-08-06","lzf");
        if(isUpdateSuccess!=0){
            testFindByUsername();
        }
        sqlSession.commit();//Mybatis不集成Spring的话，对于增删改是不会提交的。可以通过openSession(true)开启自动提交。也可以通过sqlSession.commit()手动提交
        sqlSession.close();//关闭资源
    }
}
