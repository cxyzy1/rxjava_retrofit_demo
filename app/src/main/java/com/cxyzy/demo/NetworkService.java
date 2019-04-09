package com.cxyzy.demo;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface NetworkService {

    @GET("cxyzy1/rxjava_retrofit_demo/master/data.json")
    Observable<Task> query();
}