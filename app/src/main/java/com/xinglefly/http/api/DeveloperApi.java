package com.xinglefly.http.api;

import com.xinglefly.entity.DevelopResult;
import com.xinglefly.entity.DeveloperInfo;
import retrofit2.http.GET;
import rx.Observable;

public interface DeveloperApi {

    @GET("v2/dailies/latest?app_key=u1ntgkc99st7sdhqjo5p&timestamp=1473838625&signature=604c954569dd6f5ebc7495d022015a7c615bb865")
    Observable<DevelopResult<DeveloperInfo>> getToArtciles();
}