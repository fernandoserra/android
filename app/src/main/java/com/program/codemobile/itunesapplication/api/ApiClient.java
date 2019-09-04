package com.program.codemobile.itunesapplication.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String TAG = "ApiClient";
    private static Retrofit retrofit;
    public static Retrofit  getClient(){
        OkHttpClient client =  new OkHttpClient();
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.ROOT_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return  retrofit;
    }
}
