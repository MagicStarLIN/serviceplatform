package com.lcl.serviceplatform.pojo;

public class User {
    private Integer id;
    private String name;
    private String password;
    private Integer age;
    private Dic gender;
    private Dic nation;
    private Dic job;
    private Dic politics;
    private Org org;
    private String dept;
    private String phone;
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Dic getGender() {
        return gender;
    }

    public void setGender(Dic gender) {
        this.gender = gender;
    }

    public Dic getNation() {
        return nation;
    }

    public void setNation(Dic nation) {
        this.nation = nation;
    }

    public Dic getJob() {
        return job;
    }

    public void setJob(Dic job) {
        this.job = job;
    }

    public Dic getPolitics() {
        return politics;
    }

    public void setPolitics(Dic politics) {
        this.politics = politics;
    }

    public Org getOrg() {
        return org;
    }

    public void setOrg(Org org) {
        this.org = org;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", nation=" + nation +
                ", job=" + job +
                ", politics=" + politics +
                ", org=" + org +
                ", dept='" + dept + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
