package com.frame.mvp.common.base

import android.app.Activity
import android.content.Context
import androidx.annotation.Keep

import java.util.Stack

/**
 * 单例模式，记录所有activity,方便退出应用
 * @author jsx
 * @since V1.0
 */
@Keep
object ViewManager {

    private var activityStack: Stack<Activity>? = null

    /**
     * 添加指定Activity到堆栈
     */
    fun addActivity(activity: Activity) {
        if (activityStack == null) {
            activityStack = Stack()
        }
        activityStack!!.add(activity)
    }


    /**
     * 获取当前Activity
     */
    fun currentActivity(): Activity {
        return activityStack!!.lastElement()
    }


    /**
     * 结束当前Activity
     */
    fun finishActivity() {
        val activity = activityStack!!.lastElement()
        finishActivity(activity)
    }


    /**
     * 结束指定的Activity
     */
    fun finishActivity(activity: Activity) {
        activity.finish()
        activityStack!!.remove(activity)
    }


    /**
     * 结束指定Class的Activity
     */
    fun finishActivity(cls: Class<*>) {
        for (activity in activityStack!!) {
            if (activity.javaClass == cls) {
                finishActivity(activity)
                return
            }
        }
    }


    /**
     * 结束全部的Activity
     */
    fun finishAllActivity() {
        var i = 0
        val size = activityStack!!.size
        while (i < size) {
            if (null != activityStack!![i]) {
                activityStack!![i].finish()
            }
            i++
        }
        activityStack!!.clear()
    }


    /**
     * 退出应用程序
     */
    fun exitApp(context: Context) {
        finishAllActivity()
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as android.app.ActivityManager
        activityManager.killBackgroundProcesses(context.packageName)
    }
}
