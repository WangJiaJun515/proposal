package com.example.demo.entity;
import lombok.Data;
@Data
public class Member {
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

    public void setId(int id){
        this.id = id;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setSex(String sex){
        this.sex=sex;
    }
    public void setBirthday(String birthday){
        this.birthday=birthday;
    }
    public void setNumber(String number){
        this.number=number;
    }
    public void setUnits(String units){
        this.units=units;
    }
};
