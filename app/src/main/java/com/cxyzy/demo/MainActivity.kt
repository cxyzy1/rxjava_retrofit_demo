package com.cxyzy.demo

import android.os.Bundle
import android.util.Log

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

import androidx.appcompat.app.AppCompatActivity
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        queryData()
    }

    private fun queryData() {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        val networkService = retrofit.create(NetworkService::class.java)

        networkService.query()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Task> {
                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onNext(task: Task) {
                        contentTv.text = task.toString()
                    }

                    override fun onError(e: Throwable) {
                        Log.v("", e.message)
                    }

                    override fun onComplete() {
                    }
                })
    }
}