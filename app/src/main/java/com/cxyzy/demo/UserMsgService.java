package com.cxyzy.demo;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserMsgService {

    /**
     * 请求登陆的方法，需要两个参数，用的是POST方式
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @POST("BackStageSystem/servlet/LoginServlet")
    Observable<UserInfoModel> login(@Query("username") String username, @Query("password") String password);
}