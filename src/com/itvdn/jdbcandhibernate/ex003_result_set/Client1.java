package com.itvdn.jdbcandhibernate.ex003_result_set;

public class Client1 {
private int id;
private String name;
private int age;
private String phone;

public Client1(int id, String name, int age, String phone) {
    this.id = id;
    this.age = age;
    this.name = name;
    this.phone = phone;
}
public int getId() {
    return id;
}
public String getName() {
    return name;
}
    public int getAge() {
        return age;
    }
    public String getPhone() {
        return phone;
    }

}
