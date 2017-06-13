package com.example.bamboo.weatherapp

import android.util.Log
import java.net.URL

/**
 * Created by baozhiyuan on 17/6/7.
 */
public class Request(val url: String) {
    public fun run() {
        val forecastJsonStr = URL(url).readText()
        Log.d("bzy", javaClass.simpleName + forecastJsonStr)
    }
}
