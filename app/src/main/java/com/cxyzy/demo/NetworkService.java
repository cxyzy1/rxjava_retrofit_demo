package com.cxyzy.demo;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface NetworkService {

    @GET("data.json")
    Observable<Task> query();
}