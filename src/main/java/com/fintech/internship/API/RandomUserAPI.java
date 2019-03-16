package com.fintech.internship.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface RandomUserAPI {
    @GET("/api/get")
    Call<List<UserFromAPI>> getData(@Query("results") int number, @Query("nat") String nat);
}
