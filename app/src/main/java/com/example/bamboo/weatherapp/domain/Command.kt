package com.example.bamboo.weatherapp.domain

/**
 * Created by baozhiyuan on 17/6/8.
 */
interface Command<T> {
    fun execute(): T
}