package com.xinglefly.network.api;

import com.xinglefly.entity.TestItem;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface TestApi {

    @GET("search")
    Observable<List<TestItem>> query (@Query("q") String query);
}