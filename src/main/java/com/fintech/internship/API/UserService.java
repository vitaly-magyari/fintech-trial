package com.fintech.internship.API;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserService {

    @GET("/api")
    public Call<Result> getUsers();
}
