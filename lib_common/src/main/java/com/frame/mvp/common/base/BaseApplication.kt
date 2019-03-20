package com.frame.mvp.common.base

import android.app.Application
import android.content.Context
import com.frame.mvp.common.utils.ClassUtils
import androidx.multidex.MultiDex



/**
 * 要想使用BaseApplication，必须在组件中实现自己的Application，并且继承BaseApplication；
 * 组件中实现的Application必须在debug包中的AndroidManifest.xml中注册，否则无法使用；
 * 组件的Application需置于java/debug文件夹中，不得放于主代码；
 * 组件中获取Context的方法必须为:Utils.getContext()，不允许其他写法；
 *
 * @author 2016/12/2 17:02
 * @name BaseApplication
 */
open class BaseApplication : Application() {

    private var mAppDelegateList: List<IApplicationDelegate>? = null

    override fun onCreate() {
        super.onCreate()
        mAppDelegateList = ClassUtils.getObjectsWithInterface(this, IApplicationDelegate::class.java, ROOT_PACKAGE)
        for (delegate in mAppDelegateList!!) {
            delegate.onCreate()
        }

    }

    override fun onTerminate() {
        super.onTerminate()
        for (delegate in mAppDelegateList!!) {
            delegate.onTerminate()
        }
    }


    override fun onLowMemory() {
        super.onLowMemory()
        for (delegate in mAppDelegateList!!) {
            delegate.onLowMemory()
        }
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        for (delegate in mAppDelegateList!!) {
            delegate.onTrimMemory(level)
        }
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    companion object {
        const val ROOT_PACKAGE = "com.frame.mvp"
    }
}
