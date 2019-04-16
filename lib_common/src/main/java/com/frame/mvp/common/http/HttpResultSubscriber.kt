package com.frame.mvp.common.http

import com.frame.mvp.common.bean.ResponseVo
import org.reactivestreams.Subscriber
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.util.concurrent.TimeoutException


abstract class HttpResultSubscriber<T> : Subscriber<ResponseVo<T>> {

    override fun onNext(response: ResponseVo<T>) {
        if (response.isSuccess()) {
            onSuccess(response.data)
        } else {
//            _onError(t.getMsg().getCode())
        }
    }

    override fun onError(e: Throwable) {
        e.printStackTrace()
        //在这里做全局的错误处理
        if (e is ConnectException ||
            e is SocketTimeoutException ||
            e is TimeoutException
        ) {
            //网络错误
//            _onError(-9999)
        }
    }

    abstract fun onSuccess(t: T?)
}