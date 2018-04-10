package com.deity.github.data.net.api.base;

import com.deity.github.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * 定制httpclient
 * Created by deity on 18-4-10.
 */

public abstract class BaseOkHttpClient {
    /**10秒超时*/
    private final static int CONNECT_TIME_OUT=10*1000;

    /**日志记录*/
    private HttpLoggingInterceptor obtainInterceptor(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        HttpLoggingInterceptor.Level level = (BuildConfig.DEBUG ?HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        interceptor.setLevel(level);
        return interceptor;
    }

    /**
     * 基类中只对超时及日志方面进行了定制,其他相关定制可移动到子类中实现
     * @return
     */
    public OkHttpClient obtainOkHttpClient(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(obtainInterceptor());
        OkHttpClient.Builder deepHttpClientBuilder = deepCustomHttpClient(builder);
        return deepHttpClientBuilder.build();
    }

    /**通过该方法可进行深层次的定制*/
    protected abstract OkHttpClient.Builder deepCustomHttpClient(OkHttpClient.Builder builder);
}
