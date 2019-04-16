package com.frame.mvp.common.base


import androidx.annotation.Keep

@Keep
interface IPresenter<V> {
    fun start()
    fun attachView(view: V)
    fun isViewAttached(): Boolean
    fun detachView()
}
