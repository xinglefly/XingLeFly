package com.xinglefly.network.api;

import com.xinglefly.model.ResultData;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

public interface DeveloperApi {
    @GET("v2/team_subjects?f=latest&app_key=u1ntgkc99st7sdhqjo5p&timestamp=1473315793&signature=cbd9687065962667e98cdce76bc7006ce6235e34&page={num}")
    Observable<List<ResultData>> load();
}