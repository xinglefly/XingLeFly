package com.xinglefly.http;

import com.xinglefly.http.api.*;


public class ApiResult {

    private static GankApi gankApi;
    private static DeveloperApi developerApi;
    private static TestApi testApi;


    public static GankApi getGankApi() {
        if (gankApi == null)
            gankApi = HttpMethods.getInstance("http://gank.io/api/").create(GankApi.class);
        return gankApi;
    }

    public static DeveloperApi getDeveloperApi(){
        if (developerApi ==null)
            developerApi = HttpMethods.getInstance("http://api.toutiao.io/").create(DeveloperApi.class);
        return developerApi;
    }


    public static TestApi getTestApi(){
        if (testApi==null)
            testApi = HttpMethods.getInstance("http://zhuangbi.info/").create(TestApi.class);
        return testApi;
    }
}