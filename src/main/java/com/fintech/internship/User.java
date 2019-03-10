package com.fintech.internship;

import java.util.Date;

public class User {
    public String firstName;
    public String secondName;
    public String lastName;
    public Integer age;
    public String gender;
    public Date dateOfBirth;
    public String iNN;
    public Integer zipcode;
    public String country;
    public String area;
    public String city;
    public String street;
    public Integer house;
    public Integer flat;

    public User(String firstName, String secondName, String lastName,
                Integer age, String gender, Date dateOfBirth, String iNN,
                Integer zipcode, String country, String area,
                String city, String street, Integer house, Integer flat) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.iNN = iNN;
        this.zipcode = zipcode;
        this.country = country;
        this.area = area;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
    }
}
