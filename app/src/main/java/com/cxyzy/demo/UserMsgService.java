package com.cxyzy.demo;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserMsgService {

    @GET("data.json")
    Observable<UserInfoModel> query();
}