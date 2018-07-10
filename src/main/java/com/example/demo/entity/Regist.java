package com.example.demo.entity;
import lombok.Data;
@Data
public class Regist {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String sex;
    private String birthday;
    private String number;
    private String units;

    public Integer getId(){
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getNumber() {
        return number;
    }

    public String getUnits() {
        return units;
    }
};
