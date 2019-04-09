package com.cxyzy.demo;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "https://raw.githubusercontent.com/cxyzy1/rxjava_retrofit_demo/master/";
    private TextView tv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_content = findViewById(R.id.tv_content);
        onAction();
    }

    public void onAction() {


        //创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        //获取UserMsgService对象
        UserMsgService userMsgService = retrofit.create(UserMsgService.class);

        userMsgService.query()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserInfoModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserInfoModel userInfoModel) {
                        tv_content.setText(userInfoModel.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.v("",e.getMessage());
                        int i = 0;
                        //请求失败的情况
                    }

                    @Override
                    public void onComplete() {
                        int i = 0;

                    }
                });

    }
}