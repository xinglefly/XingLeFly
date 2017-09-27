package com.xinglefly.module.skill.presenter;

import com.xinglefly.entity.DeveloperInfo;
import com.xinglefly.http.ApiResult;
import com.xinglefly.http.SubscribeProxy;
import com.xinglefly.http.response.DevelopResultFunc;
import com.xinglefly.module.skill.DeveloperFragment;

import rx.Observable;
import rx.Subscriber;

public class DevelopPresenter {

    DeveloperFragment developerFragment;

    public DevelopPresenter(DeveloperFragment developerFragment) {
        this.developerFragment = developerFragment;
    }

    public void getDevelopInfo(Subscriber<DeveloperInfo> subscriber){
        Observable<DeveloperInfo> observable = ApiResult
                .getDeveloperApi()
                .getToArtciles()
                .map(new DevelopResultFunc<DeveloperInfo>());
        SubscribeProxy.toSubscribe(observable,subscriber);

    }

}