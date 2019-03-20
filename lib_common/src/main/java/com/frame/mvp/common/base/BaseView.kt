package com.frame.mvp.common.base


import androidx.annotation.Keep

/**
 *
 * View接口的基类
 *
 * @author 张华洋
 * @name BaseView
 */
@Keep
interface BaseView<T> {

    fun setPresenter(presenter: T)

}
