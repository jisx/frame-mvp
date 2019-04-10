package com.frame.mvp

import com.alibaba.android.arouter.launcher.ARouter
import com.frame.mvp.common.base.BaseApplication

/**
 * Created by jsx on 2019/2/1.
 */
class MyApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            //开启InstantRun之后，一定要在ARouter.init之前调用openDebug
            ARouter.openDebug()
            ARouter.openLog()
        }
        ARouter.init(this)
    }
}