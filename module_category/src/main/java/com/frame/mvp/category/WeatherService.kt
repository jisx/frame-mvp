package com.frame.mvp.category

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("s6/weather/forecast")
    fun getWeather(@Query("location") location: String, @Query("key") key: String): Single<Response<String>>

}