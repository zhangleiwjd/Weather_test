package com.example.zhanglei.weather_test.util;

/**
 * Created by zhanglei on 2016-08-22.
 */
public interface HttpCallbackListener {
    void onFinish(String response);

    void onError(Exception e);
}
