package com.frame.mvp.category.presenter

import com.frame.mvp.category.WeatherService
import com.frame.mvp.category.contract.CategoryContract
import com.frame.mvp.common.base.BasePresenter
import com.frame.mvp.common.http.*

class CategoryPresenter : BasePresenter<CategoryContract.View>(),CategoryContract.Presenter{
    override fun start() {
        OkHttpService.getHttpService(WeatherService::class.java,BaseUrlEnum.WEATHER)
            .getWeather("wuxi", "df646dd7f90544399eb822b3f1fa84a8").before {
                getView().showToast()
            }.attemptGetResponseBody().subscribe()
    }

}
