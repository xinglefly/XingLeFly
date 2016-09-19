package com.xinglefly.http;

import com.xinglefly.api.DeveloperApi;
import com.xinglefly.api.response.DevelopResultFunc;
import com.xinglefly.entity.DeveloperInfo;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HttpMethods {

    private static final int DEFAULT_TIMEOUT = 10;
    private Retrofit retrofit;

    private DeveloperApi developerApi;

    public HttpMethods() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .client(okHttpClient.build())
                .baseUrl("http://api.toutiao.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        developerApi = retrofit.create(DeveloperApi.class);
    }


    private static class SingleToneHolder{
        private static final HttpMethods INSTANCE = new HttpMethods();
    }

    public static HttpMethods getInstance(){
        return SingleToneHolder.INSTANCE;
    }


    public void getDevelopInfo(Subscriber<DeveloperInfo> subscriber){
        developerApi.getToArtciles()
                .map(new DevelopResultFunc<DeveloperInfo>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    private <T> void toSubscribe(Observable<T> o, Subscriber<T> s){
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }
}