package com.example.zhanglei.weather_test.db;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by zhanglei on 2016-08-22.
 */
public class WeatherDb {
    public static final String DB_NAME = "weather";
    public static final int VERSION = 1;
    public static WeatherDb weatherDb;
    private SQLiteDatabase db;

}
