package com.frame.mvp.common.base

import android.content.Context
import androidx.annotation.Keep


/**
 *
 * Fragment的基类
 *
 * @author 张华洋
 * @name BaseFragment
 */
@Keep
abstract class BaseFragment : androidx.fragment.app.Fragment() {

    /**
     * 获取宿主Activity
     *
     * @return BaseActivity
     */
    var holdingActivity: BaseActivity? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        this.holdingActivity = context as BaseActivity?
    }

}
