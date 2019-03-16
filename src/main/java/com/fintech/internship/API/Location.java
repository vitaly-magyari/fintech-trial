package com.fintech.internship.API;

import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("state")
    private String area;

    @SerializedName("city")
    private String city;

    @SerializedName("street")
    private String street;

    public String getArea() {return area;}
    public void setArea(String area) {this.area = area;}

    public String getCity() {return city;}
    public void setCity(String city) {this.city = city;}

    public String getStreet() {return street;}
    public void setStreet(String street) {this.street = street;}
}
