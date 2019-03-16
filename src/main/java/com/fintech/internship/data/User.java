package com.fintech.internship.data;

import com.fintech.internship.API.UserFromAPI;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getSecondName() {
        return secondName;
    }
    public void setSecondName(String secondName) {this.secondName = secondName;}

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {this.lastName = lastName;}

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {this.age = age;}

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {this.gender = gender;}

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {this.dateOfBirth = dateOfBirth;}

    public String getiNN() {
        return iNN;
    }
    public void setiNN(String iNN) {this.iNN = iNN;}

    public Integer getZipcode() {
        return zipcode;
    }
    public void setZipcode(Integer zipcode) {this.zipcode = zipcode;}

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {this.country = country;}

    public String getArea() {
        return area;
    }
    public void setArea(String area) {this.area = area;}

    public String getCity() {
        return city;
    }
    public void setCity(String city) {this.city = city;}

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {this.street = street;}

    public Integer getHouse() {
        return house;
    }
    public void setHouse(Integer house) {this.house = house;}

    public Integer getFlat() {
        return flat;
    }
    public void setFlat(Integer flat) {this.flat = flat;}


    private List<UserFromAPI> usersAPI = new ArrayList<>();

    public static void setUsersData(List<UserFromAPI> userData, User[] users) {
        if(userData !=null){
            for (int i = 0; i < users.length; i++) {
                users[i] = new User();
                users[i].setDataFromAPI();
            }
        }else{
            for (int i = 0; i < users.length; i++) {
                users[i] = new User();
                users[i].setDataFromTxt();
            }
        }
    }

    private void setDataFromAPI() {
        try {
            UserFromAPI newUserAPI = new UserFromAPI();
            newUserAPI.getGender();
            newUserAPI.getName().getFirstName();
            newUserAPI.getName().getLastName();
            newUserAPI.getDateOfBirth();
            newUserAPI.getLocation().getArea();
            newUserAPI.getLocation().getCity();
            newUserAPI.getLocation().getStreet();
            usersAPI.add(newUserAPI);
        }finally {
        }
    }

    private void setDataFromTxt() {
        try {
            UserGenerator newUserTxt = new UserGenerator();
                newUserTxt.fillUsers(30);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

