package cn.ol.demo.domain;

import java.util.Date;

public class User {
    private int id; //用户id
    private String username; //用户名
    private String password; //密码
    private String gender; //性别
    private String telephone; //电话
    private String email; //邮箱
    private String introduction; //简介
    private String state; //状态[激活/非激活]
    private String activeCode; //激活码
    private String role; //用户角色[0:读者,1:作者]
    private Date registerationTime; //注册时间
    private String lastLoginTime; //最后登录时间

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getRegisterationTime() {
        return registerationTime;
    }

    public void setRegisterationTime(Date registerationTime) {
        this.registerationTime = registerationTime;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
