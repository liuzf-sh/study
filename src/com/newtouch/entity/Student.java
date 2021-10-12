package com.newtouch.entity;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    private Teacher teacher;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
