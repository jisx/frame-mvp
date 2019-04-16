package com.frame.mvp.common.base

import android.app.Application
import android.content.Context
import androidx.annotation.Keep
import androidx.multidex.MultiDex

@Keep
open class BaseApplication : Application() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}
