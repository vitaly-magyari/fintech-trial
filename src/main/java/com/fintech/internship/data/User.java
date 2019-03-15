package com.fintech.internship.data;

import java.util.Date;

public class User {
    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getiNN() {
        return iNN;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public String getCountry() {
        return country;
    }

    public String getArea() {
        return area;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public Integer getHouse() {
        return house;
    }

    public Integer getFlat() {
        return flat;
    }

    private String firstName;
    private String secondName;
    private String lastName;
    private Integer age;
    private String gender;
    private Date dateOfBirth;
    private String iNN;
    private Integer zipcode;
    private String country;
    private String area;
    private String city;
    private String street;
    private Integer house;
    private Integer flat;

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
