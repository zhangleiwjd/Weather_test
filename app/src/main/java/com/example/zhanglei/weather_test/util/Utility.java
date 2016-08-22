package com.example.zhanglei.weather_test.util;

import android.text.TextUtils;

import com.example.zhanglei.weather_test.db.WeatherDb;
import com.example.zhanglei.weather_test.model.City;
import com.example.zhanglei.weather_test.model.County;
import com.example.zhanglei.weather_test.model.Province;

/**
 * Created by zhanglei on 2016-08-22.
 */
public class Utility {
    public synchronized static boolean handleProvincesResponse(WeatherDb weatherDb, String response) {
        if (!TextUtils.isEmpty(response)) {
            String[] allProvinces = response.split(",");
            if (allProvinces != null && allProvinces.length > 0) {
                for (String p : allProvinces) {
                    String[] array = p.split("\\|");
                    Province province = new Province();
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1]);
                    weatherDb.saveProvince(province);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean handleCitiesResponse(WeatherDb weatherDb, String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            String[] allCities = response.split(",");
            if (allCities != null && allCities.length > 0) {
                for (String c : allCities) {
                    String[] array = c.split("\\|");
                    City city = new City();
                    city.setCityCode(array[0]);
                    city.setCityName(array[1]);
                    city.setProvinceId(provinceId);
                    weatherDb.saveCity(city);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean handleCountiesResponse(WeatherDb weatherDb, String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            String[] allCounties = response.split(",");
            if (allCounties != null && allCounties.length > 0) {
                for (String c : allCounties) {
                    String[] array = c.split("\\|");
                    County county = new County();
                    county.setCountyCode(array[0]);
                    county.setCountyName(array[1]);
                    county.setCityId(cityId);
                    weatherDb.saveCounty(county);
                }
                return true;
            }
        }
        return false;
    }

}
