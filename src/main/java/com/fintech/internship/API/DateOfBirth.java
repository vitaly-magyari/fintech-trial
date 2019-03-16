package com.fintech.internship.API;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class DateOfBirth {

    @SerializedName("date")
    public Date date;

    @SerializedName("age")
    public int age;

    public Date getDate() {return date;}
    public void setDate(Date date) {this.date = date;}

    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}
}
