package com.xinglefly.util;

import com.xinglefly.model.GankBeauty;
import com.xinglefly.model.GankBeautyResult;
import com.xinglefly.model.PictureItem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import rx.functions.Func1;

public class GankBeautyResultToItemsMapper implements Func1<GankBeautyResult, List<PictureItem>> {

    private static GankBeautyResultToItemsMapper INSTANCE = new GankBeautyResultToItemsMapper();

    private GankBeautyResultToItemsMapper() {
    }

    public static GankBeautyResultToItemsMapper getInstance(){
        return INSTANCE;
    }

    @Override
    public List<PictureItem> call(GankBeautyResult gankBeautyResult) {
        List<GankBeauty> gankBeauties = gankBeautyResult.beauties;
        List<PictureItem> items = new ArrayList<PictureItem>(gankBeauties.size());
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS'Z'");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yy/MM/dd HH:mm:ss");

        for (GankBeauty gankBeauty : gankBeauties){
            PictureItem item = new PictureItem();
            try {
                Date date = inputFormat.parse(gankBeauty.createdAt);
                item.description = outputFormat.format(date);
            } catch (ParseException e) {
                e.printStackTrace();
                item.description = "unknow date";
            }
            item.imageUrl = gankBeauty.url;
            items.add(item);
        }

        return items;
    }
}