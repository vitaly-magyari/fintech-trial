package com.fintech.internship.API;

import com.google.gson.annotations.SerializedName;

public class UserFromAPI {
    @SerializedName("gender")
    private String gender;

    @SerializedName("name")
    private Name name;

    @SerializedName("dateOfBirth")
    private DateOfBirth dateOfBirth;

    @SerializedName("location")
    private Location location;

    public String getGender() {return gender;}
    public void setGender(String gender) {this.gender = gender;}

    public Name getName() {return name;}
    public void setName(Name name) {this.name = name;}

    public DateOfBirth getDateOfBirth() {return dateOfBirth;}
    public void setDateOfBirth(DateOfBirth dateOfBirth) {this.dateOfBirth = dateOfBirth;}

    public Location getLocation() {return location;}
    public void setLocation(Location location) {this.location = location;}
}

