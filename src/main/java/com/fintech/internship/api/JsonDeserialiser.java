package com.fintech.internship.api;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;

import java.lang.reflect.Type;

public interface JsonDeserialiser <T>{
    T deserialise(JsonElement json, Type typeOfSrc, JsonDeserializationContext context);
}
