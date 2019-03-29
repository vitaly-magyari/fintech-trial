package com.fintech.internship.api;

import com.fintech.internship.data.User;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class UserFromAPI {



    OkHttpClient userAPI = new OkHttpClient();

    String doGetRequest(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = userAPI.newCall(request).execute();
        return response.body().string();
    }

    public static User createUserFromApi () throws IOException {
        UserFromAPI userFromAPI = new UserFromAPI();
        String getResponse = userFromAPI.doGetRequest("https://randomuser.me/api/");
        return new User();
    }

    public static void main(String[] args) throws IOException {
        UserFromAPI userFromAPI = new UserFromAPI();
//        try {
        String getResponse = userFromAPI.doGetRequest("https://randomuser.me/api/");
//            ...
//
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//            User user = new User();
//        }

        System.out.println(getResponse);
    }
}