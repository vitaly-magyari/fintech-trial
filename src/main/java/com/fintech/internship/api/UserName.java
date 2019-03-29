package com.fintech.internship.api;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class UserName implements JsonDeserialiser<UserName>{

    @Override
    public UserName deserialise(JsonElement json, Type typeOfSrc, JsonDeserializationContext context) {
        UserName userName = new UserName();
        String data = json.getAsString();
        List<String> parts = Arrays.asList(data.split(" "));

        if(parts.contains("first")) userName.setFirstName()

        return userName;
    }
}
