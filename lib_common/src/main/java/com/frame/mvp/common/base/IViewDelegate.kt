package com.frame.mvp.common.base


import androidx.annotation.Keep
import android.view.View

/**
 *
 * 类说明
 *
 * @author 张华洋 2018/1/4 22:10
 * @version V2.8.3
 * @name IFragmentDelegate
 */
@Keep
interface IViewDelegate {

    fun getFragment(name: String): BaseFragment

    fun getView(name: String): View

}
