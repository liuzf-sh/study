package com.newtouch.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.InputStream;

/**
 * @author : init yo
 * @Description:
 * @E-mail 1023747751@qq.com
 * @Date: 2021/6/28 16:15
 */
public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory;
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();//1652

    static {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSession openSession() {
        SqlSession sqlSession = threadLocal.get();
        if(sqlSession==null){
            if(sqlSessionFactory != null){
               threadLocal.set(sqlSessionFactory.openSession());
            }
        }
        System.out.println(threadLocal.get().toString());//3270d194
        return threadLocal.get();
    }

    public static Object getMapper(Class clazz){
        return openSession().getMapper(clazz);
    }

    public static void close(){
        SqlSession sqlSession = threadLocal.get();
        System.out.println(sqlSession.toString());//3270d194
        if(sqlSession!=null){
            sqlSession.close();
        }
        threadLocal.set(null);
    }
}
