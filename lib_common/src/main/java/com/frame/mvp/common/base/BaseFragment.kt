package com.frame.mvp.common.base

import android.content.Context
import android.os.Bundle
import androidx.annotation.Keep
import androidx.annotation.LayoutRes

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

    @LayoutRes
    protected abstract fun layoutId(): Int
    protected abstract fun initView(savedInstanceState: Bundle?)

}
