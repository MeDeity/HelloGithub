package com.deity.github.data.net.api;

import com.deity.github.common.constant.Params;
import com.deity.github.data.net.api.base.BaseRetrofit;

import okhttp3.OkHttpClient;

/**
 * 仓库
 * Created by deity on 18-4-10.
 */

public class GithubRepoRetrofit extends BaseRetrofit{

    @Override
    protected String obtainBaseUrl() {
        return Params.BASE_GITHUB_URL;
    }

    @Override
    protected OkHttpClient getHttpClient() {
        return null;
    }
}
