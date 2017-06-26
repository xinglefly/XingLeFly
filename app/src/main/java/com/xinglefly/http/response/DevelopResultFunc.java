package com.xinglefly.http.response;

import com.xinglefly.http.api.ApiException;
import com.xinglefly.entity.DevelopResult;

import rx.functions.Func1;


public class DevelopResultFunc<T> implements Func1<DevelopResult<T>, T>{

    @Override
    public T call(DevelopResult<T> httpResult) {
        if (httpResult.getRet() != 0) {
            throw new ApiException(httpResult.getMsg());
        }
        return httpResult.getData();
    }
}