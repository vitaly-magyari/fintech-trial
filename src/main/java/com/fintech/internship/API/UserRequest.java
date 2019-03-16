package com.fintech.internship.API;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

import static okhttp3.OkHttpClient.Builder;

public class UserRequest {
    Builder httpClient;
    Retrofit retrofit;
    UserService service;

    public UserRequest() {
        httpClient = new Builder();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        service = retrofit.create(UserService.class);
    }

    public Result getResult() {
        Call<Result> callSync = service.getUsers();
        try {
            Response<Result> response = callSync.execute();
            return response.body();
        }
        catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
