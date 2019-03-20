package com.frame.mvp.common.base

import androidx.annotation.Keep

/**
 *
 * 数据回调接口
 *
 * @author 张华洋 2017/3/22 13:36
 * @version V1.2.0
 * @name InfoCallback
 */
@Keep
interface InfoCallback<T> {

    fun onSuccess(info: T)

    fun onError(code: Int, message: String)

}
