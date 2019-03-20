package com.frame.mvp.common.base

import androidx.annotation.Keep

/**
 *
 * 类说明
 *
 * @author 张华洋 2017/9/20 22:23
 * @version V2.8.3
 * @name ApplicationDelegate
 */
@Keep
interface IApplicationDelegate {

    fun onCreate()

    fun onTerminate()

    fun onLowMemory()

    fun onTrimMemory(level: Int)

}
