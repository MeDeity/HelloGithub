package com.deity.github.data.net.api.base;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 基础工具类
 * Created by deity on 18-4-10.
 */

public abstract class BaseRetrofit {

    public Retrofit obtainRetrofit(){
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(obtainBaseUrl())
               .client(getHttpClient())
               .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
               .addConverterFactory(GsonConverterFactory.create());
        return builder.build();
    }

    protected abstract String obtainBaseUrl();
    protected abstract OkHttpClient getHttpClient();
}
