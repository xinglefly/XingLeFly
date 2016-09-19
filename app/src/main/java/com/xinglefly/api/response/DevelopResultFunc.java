package com.xinglefly.api.response;

import com.xinglefly.api.ApiException;
import com.xinglefly.entity.DevelopResult;
import com.xinglefly.entity.DeveloperInfo;
import com.xinglefly.entity.HttpResult;

import rx.functions.Func1;


public class DevelopResultFunc<T> implements Func1<DevelopResult<T>, T>{

    @Override
    public T call(DevelopResult<T> httpResult) {
        if (httpResult.getRet() != 0) {
            throw new ApiException(httpResult.getErrcode());
        }
        return httpResult.getData();
    }
}