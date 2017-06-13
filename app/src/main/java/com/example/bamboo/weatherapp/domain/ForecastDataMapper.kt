package com.example.bamboo.weatherapp.domain

import com.example.bamboo.weatherapp.data.Forecast
import com.example.bamboo.weatherapp.data.ForecastResult
import java.text.DateFormat
import java.util.*
import com.example.bamboo.weatherapp.domain.Forecast as ModelForecast

/**
 * Created by baozhiyuan on 17/6/8.
 */
public class ForecastDataMapper {

    fun converFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country,
                converForecastListToDomain(forecast.list))
    }

    private fun converForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.map { converForecastItemToDomain(it) }
    }

    private fun converForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt),
                forecast.weather[0].description,
                forecast.temp.max.toInt(),
                forecast.temp.min.toInt(),
                generateIconUrl(forecast.weather[0].icon))
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }

    private fun generateIconUrl(iconCode: String): String = "http://openweathermap.org/img/w/$iconCode.png"
}