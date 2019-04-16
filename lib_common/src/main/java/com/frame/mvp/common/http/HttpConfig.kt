package com.frame.mvp.common.http

internal object HttpConfig {
    const val timeOut = 15L //单位秒

    const val retryCount = 5   //重试次数
    const val retryDelay = 1000  //多少秒后重试
}