package com.example.bamboo.weatherapp.domain

import com.example.bamboo.weatherapp.ForecastRequest

/**
 * Created by baozhiyuan on 17/6/8.
 */
class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().converFromDataModel(forecastRequest.execute())
    }

}