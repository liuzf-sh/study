package com.newtouch.entity;

import lombok.Data;

/**
 * @author : init yo
 * @Description:
 * @E-mail 1023747751@qq.com
 * @Date: 2021/6/28 10:24
 */
@Data
public class User {
    private int id;
    private String username;
    private int u_age;
    private String birthday;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getU_age() {
        return u_age;
    }

    public void setU_age(int u_age) {
        this.u_age = u_age;
    }
// public int getAge() {
    //     return age;
    // }
    //
    // public void setAge(int age) {
    //     this.age = age;
    // }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    // @Override
    // public String toString() {
    //     return "User{" +
    //             "id=" + id +
    //             ", username='" + username + '\'' +
    //             ", age=" + age +
    //             ", birthday='" + birthday + '\'' +
    //             '}';
    // }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", u_age=" + u_age +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
