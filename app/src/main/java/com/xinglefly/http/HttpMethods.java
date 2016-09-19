package com.xinglefly.http;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpMethods {

    private static final int DEFAULT_TIMEOUT = 10;
    private static OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
    private static Converter.Factory gsonConvertFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();

    public HttpMethods() {
        okHttpClient.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
    }

    private Retrofit getRetrofit(String baseUrl){
        return new Retrofit.Builder()
                .client(okHttpClient.build())
                .baseUrl(baseUrl)
                .addConverterFactory(gsonConvertFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();
    }


    private static class SingleToneHolder{
        private static final HttpMethods INSTANCE = new HttpMethods();
    }

    public static Retrofit getInstance(String baseUrl){
        return SingleToneHolder.INSTANCE.getRetrofit(baseUrl);
    }

}