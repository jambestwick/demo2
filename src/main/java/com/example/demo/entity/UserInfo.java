package com.example.demo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;

@TableName("tb_userInfo")
public class UserInfo implements Serializable{

    private static final long serialVersionUID = -6052808007209093300L;
    @TableId("user_Id")
    private int userId;
    @TableField("user_name")
    private String userName;
    @TableField("telephone")
    private String telephone;
    @TableField("email")
    private String email;
    @TableField("address")
    private String address;
    @TableField("age")
    private int age;

    public UserInfo() {
    }

    public UserInfo(String userName, String telephone, String email, String address, int age) {
        this.userName = userName;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
        this.age = age;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
