package com.xinglefly.http;

import com.xinglefly.api.DeveloperApi;
import com.xinglefly.network.api.GankApi;
import com.xinglefly.network.api.TestApi;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitResult {

    private static GankApi gankApi;
    private static DeveloperApi developerApi;
    private static TestApi testApi;

    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static Converter.Factory gsonConvertFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();

    private static Retrofit getRetrofit(String url) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(url)
                .addConverterFactory(gsonConvertFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();
    }


    public static GankApi getGankApi() {
        if (gankApi == null)
            gankApi = getRetrofit("http://gank.io/api/").create(GankApi.class);
        return gankApi;
    }

    public static DeveloperApi getDeveloperApi(){
        if (developerApi ==null)
            developerApi = getRetrofit("http://api.toutiao.io/").create(DeveloperApi.class);
        return developerApi;
    }


    public static TestApi getTestApi(){
        if (testApi==null)
            testApi = getRetrofit("http://zhuangbi.info/").create(TestApi.class);
        return testApi;
    }
}