package com.deity.github.data.net.api.base;

import android.text.TextUtils;
import android.util.Base64;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 登录用ＨttpClient
 * Created by deity on 18-4-10.
 */

public class AuthHttpClient extends BaseOkHttpClient{
    private String userName;
    private String password;

    public AuthHttpClient(String userName,String password){
        this.userName = userName;
        this.password = password;
    }

    @Override
    protected OkHttpClient.Builder deepCustomHttpClient(OkHttpClient.Builder builder) {
        if (!TextUtils.isEmpty(userName)&&!TextUtils.isEmpty(password)) {
            builder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    String userCredentials = userName + ":" + password;
                    String basicAuth = "Basic " + new String(Base64.encode(userCredentials.getBytes(), Base64.DEFAULT));
                    Request original = chain.request();
                    Request.Builder requestBuilder = original.newBuilder().header("Authorization", basicAuth.trim());
                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            });
        }
        return builder;
    }
}
