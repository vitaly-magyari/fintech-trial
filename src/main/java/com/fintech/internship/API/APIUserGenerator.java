package com.fintech.internship.API;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class APIUserGenerator {

//    private static UserFromAPI userFromAPI;
    private static final String url = "https://randomuser.me/api/";

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    public static <UserFromAPI> UserFromAPI createUserFromAPI(
            Class<UserFromAPI> userFromAPIClass) {
        return retrofit.create(userFromAPIClass);
    }

    public void catchResponse(int number) {
        RandomUserAPI randomUserAPI = retrofit.create(RandomUserAPI.class);
        Call <List<UserFromAPI>> listCall = randomUserAPI.getData(number, "nat");

        try {
            Response<List<UserFromAPI>> response = listCall.execute();
            UserFromAPI userFromAPI = (UserFromAPI) response.body();
        } catch (IOException e) {System.out.println("Ошибка запроса" +
                e.getMessage() + "Данные будут сгенерированы из папки 'resources'");}
    }
}
