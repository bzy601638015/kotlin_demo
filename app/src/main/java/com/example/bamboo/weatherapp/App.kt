package com.example.bamboo.weatherapp

import android.app.Application
import com.example.bamboo.weatherapp.extensions.DelegatesExt

/**
 * Created by baozhiyuan on 17/6/9.
 */
class App : Application() {
    companion object {
        //        private var instance: Application? = null
//        fun instance() = instance!!
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}