package com.projeto.integrador.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    //private String baseUrl = "http://10.0.2.2:8080/";  //10.0.2.2 ou http://127.0.0.1 - para local host
    private String baseUrl = "http://projetointegrador2.cfapps.io/";
    //private String baseUrl = "https://jsonplaceholder.typicode.com/";
    private static RetrofitService instancia;
    private InterfaceDeServicos api;


    private RetrofitService() {

        api = criaRetrofit().create(InterfaceDeServicos.class);
    }

    private Retrofit criaRetrofit() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .build();
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .client(client)
                .build();
    }

    public static synchronized InterfaceDeServicos getServico() {
        if (instancia == null)
            instancia = new RetrofitService();
        return instancia.api;
    }

}
