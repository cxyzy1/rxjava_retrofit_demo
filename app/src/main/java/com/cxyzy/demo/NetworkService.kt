package com.cxyzy.demo

import io.reactivex.Observable
import retrofit2.http.GET

interface NetworkService {

    @GET("cxyzy1/rxjava_retrofit_demo/master/data.json")
    fun query(): Observable<Task>
}