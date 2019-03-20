package com.frame.mvp

import android.app.Application

/**
 * Created by jsx on 2019/2/1.
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
//        if (Utils.isAppDebug()) {
//            //开启InstantRun之后，一定要在ARouter.init之前调用openDebug
//            ARouter.openDebug()
//            ARouter.openLog()
//        }
//        ARouter.init(this)
//        //崩溃日志记录初始化
//        ACRA.init(this)
//        ACRA.getErrorReporter().removeAllReportSenders()
//        ACRA.getErrorReporter().setReportSender(CrashReportSender())
    }
}