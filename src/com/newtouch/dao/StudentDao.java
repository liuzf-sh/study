package com.newtouch.dao;

import com.newtouch.entity.Student;

import java.util.List;

public interface StudentDao {

    List<Student> selectAll();

    List<Student> selectAll1();
}
