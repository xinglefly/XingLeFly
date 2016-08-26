package com.xinglefly.network;

import com.xinglefly.network.api.GankApi;
import com.xinglefly.network.api.TestApi;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {

    private static TestApi testApi;
    private static GankApi gankApi;
    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static Converter.Factory gsonConvertFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();


    public static GankApi getGankApi() {
        if (gankApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("http://gank.io/api/")
                    .addConverterFactory(gsonConvertFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            gankApi = retrofit.create(GankApi.class);
        }
        return gankApi;
    }


    public static TestApi getTestApi(){
        if (testApi==null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://zhuangbi.info/")
                    .client(okHttpClient)
                    .addConverterFactory(gsonConvertFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            testApi = retrofit.create(TestApi.class);
        }
        return testApi;
    }
}