package com.frame.mvp.common.http

import java.io.InputStream

/**
 * Created by jsx on 2017/6/20.
 */

object OkHttpService {

    private val httpServiceMap = mutableMapOf<Class<*>, Any>()

    private val httpsServiceMap = mutableMapOf<Class<*>, Any>()

    fun <T> getHttpService(serviceClass: Class<T>): T {
        return getHttpService(serviceClass, BaseUrlEnum.DEFAULT)
    }

    fun <T> getHttpService(serviceClass: Class<T>, baseUrlEnum: BaseUrlEnum): T {
        val callApi: T?
        if (httpServiceMap.containsKey(serviceClass) && httpServiceMap[serviceClass] != null) {
            val service = httpServiceMap[serviceClass]
            callApi = if (serviceClass.isInstance(service)) serviceClass.cast(service) else null
        } else {
            callApi = OkHttpFactory.httpRetrofit(baseUrlEnum).create(serviceClass)
            httpServiceMap[serviceClass] = callApi!! as Any
        }
        return callApi!!
    }

    fun <T> getHttpsService(serviceClass: Class<T>, inputStream: InputStream): T {
        return getHttpsService(serviceClass, inputStream, BaseUrlEnum.DEFAULT)
    }

    fun <T> getHttpsService(serviceClass: Class<T>, inputStream: InputStream, baseUrlEnum: BaseUrlEnum): T {
        val callApi: T?
        if (httpsServiceMap.containsKey(serviceClass) && httpsServiceMap[serviceClass] != null) {
            val service = httpsServiceMap[serviceClass]
            callApi = if (serviceClass.isInstance(service)) serviceClass.cast(service) else null
        } else {
            callApi = OkHttpFactory.httpsRetrofit(inputStream, baseUrlEnum).create(serviceClass)
            httpsServiceMap[serviceClass] = callApi!! as Any
        }

        return callApi!!
    }

}
