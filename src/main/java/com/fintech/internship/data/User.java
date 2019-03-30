package com.fintech.internship.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fintech.internship.api.UserDeserializer;

import java.util.Date;
import java.util.List;

@JsonDeserialize(using = UserDeserializer.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
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


    private List<String> nameNode;

    @JsonSetter("name")
    public void setNameNode(List<String> nameNode) {
        this.nameNode = nameNode;
    }

    public List<String> getNameNode() {
        return nameNode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getiNN() {
        return iNN;
    }

    public void setiNN(String iNN) {
        this.iNN = iNN;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    public Integer getFlat() {
        return flat;
    }

    public void setFlat(Integer flat) {
        this.flat = flat;
    }


    public User() {
    }

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
