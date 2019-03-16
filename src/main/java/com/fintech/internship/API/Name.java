package com.fintech.internship.API;

import com.google.gson.annotations.SerializedName;

public class Name {

    @SerializedName("first")
    private String firstName;

    @SerializedName("last")
    private String lastName;

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = lastName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
}
