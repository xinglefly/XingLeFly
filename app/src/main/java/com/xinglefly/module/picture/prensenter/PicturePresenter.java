package com.xinglefly.module.picture.prensenter;

import com.xinglefly.entity.PictureItem;
import com.xinglefly.http.ApiResult;
import com.xinglefly.http.SubscribeProxy;
import com.xinglefly.module.picture.PictureFragment;
import com.xinglefly.module.picture.GankBeautyResultToItemsMapper;
import java.util.List;
import rx.Observable;
import rx.Subscriber;

public class PicturePresenter {

    private PictureFragment pictureFragment;

    public PicturePresenter(PictureFragment pictureFragment) {
        this.pictureFragment = pictureFragment;
    }

    public void getPictrueInfo(int page, Subscriber<List<PictureItem>> subscribe){
        Observable<List<PictureItem>> observable = ApiResult.getGankApi()
                .getBeauties(10, page)
                .map(GankBeautyResultToItemsMapper.getInstance());
        SubscribeProxy.toSubscribe(observable,subscribe);
    }
}