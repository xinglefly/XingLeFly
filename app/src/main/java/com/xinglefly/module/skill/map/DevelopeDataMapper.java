package com.xinglefly.module.skill.map;

import com.xinglefly.model.DeveloperInfo;
import com.xinglefly.model.DeveloperItem;
import com.xinglefly.model.ResultData;

import java.util.List;

import rx.functions.Func1;

public class DevelopeDataMapper implements Func1<ResultData,DeveloperInfo>{

    private static DevelopeDataMapper instance = new DevelopeDataMapper();

    private DevelopeDataMapper() {
    }

    public static DevelopeDataMapper getInstance(){
        return instance;
    }

    @Override
    public DeveloperInfo call(ResultData resultData) {
         return resultData.getData;
    }
}