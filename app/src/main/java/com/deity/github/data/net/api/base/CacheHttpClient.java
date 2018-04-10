package com.deity.github.data.net.api.base;

import okhttp3.OkHttpClient;

/**
 * 带缓存策略的httpClient
 * Created by deity on 18-4-10.
 */

public class CacheHttpClient extends BaseOkHttpClient {

    @Override
    protected OkHttpClient.Builder deepCustomHttpClient(OkHttpClient.Builder builder) {
        return null;
    }
}
