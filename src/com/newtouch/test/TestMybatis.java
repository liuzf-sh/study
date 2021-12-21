package com.newtouch.test;

import com.newtouch.dao.StudentDao;
import com.newtouch.dao.UserDao;
import com.newtouch.entity.Student;
import com.newtouch.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import sun.misc.FloatingDecimal;

import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

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
    StudentDao studentMapper;

    @Before
    public void getMapper() throws Exception {
        resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");//加载Mybatis的核心配置文件
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);// 构建SqlSessionFactory工厂
        sqlSession = sqlSessionFactory.openSession();//通过SqlSessionFactory工厂构建sqlSession对象
//        userMapper = sqlSession.getMapper(UserDao.class);//通过dao接口获取实现类对象
        studentMapper = sqlSession.getMapper(StudentDao.class);//通过dao接口获取实现类对象
    }

    @Test
    public void testFindByUsername() {
        User user = userMapper.findByUsername("lzf");
        System.out.println(user.toString());
        sqlSession.close();
    }

    @Test
    public void testUpdateSetBirhtday() {
        int isUpdateSuccess = userMapper.updateSetBirthday("1997-08-06", "lzf");
        if (isUpdateSuccess != 0) {
            testFindByUsername();
        }
        sqlSession.commit();//Mybatis不集成Spring的话，对于增删改是不会提交的。可以通过openSession(true)开启自动提交。也可以通过sqlSession.commit()手动提交
        sqlSession.close();//关闭资源
    }

    @Test
    public void test1() {
        List<Student> students = studentMapper.selectAll1();
        for (Student student : students) {
            System.out.println(student.toString());
        }
        sqlSession.close();//关闭资源
    }

    /**
     * mybatis  多对一
     */
    @Test
    public void testMoreToOne() {
        List<Student> students = studentMapper.selectAll();
        for (Student student : students) {
            System.out.println(student.toString());
        }
        sqlSession.close();//关闭资源
    }

    @Test
    public void testPercent() {
        String s = precent((float) 0.00057);
        System.out.println(s);
    }

    public static String precent(Float value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.toString();
    }

    public static String precent1(Float value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.toString();
    }

    @Test
    public void testDecimal(){
        float f = 0.00003535f;
        DecimalFormat decimalFormat=new DecimalFormat("0.##E0");//格式化设置
        String result =decimalFormat.format(f);
        System.out.println("result="+result);
    }

    @Test
    public void t1(){
        double a=1.23456D;
        System.out.printf("%1.2e\r\n", a);
        a=12.3456D;
        System.out.printf("%1.1e\r\n", a);
        a=123456D;
        System.out.printf("%1.1e\r\n", a);
    }
}
