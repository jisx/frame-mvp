package com.frame.mvp.common.base

import androidx.annotation.Keep
import java.lang.ref.Reference
import java.lang.ref.WeakReference

@Keep
abstract class BasePresenter<V> : IPresenter<V> {

    private var mViewRef: Reference<V>? = null

    override fun attachView(view: V) {
        //建立关系
        mViewRef = WeakReference<V>(view)
    }

    fun getView(): V {
        return mViewRef?.get()!!
    }

    override fun isViewAttached(): Boolean {
        return mViewRef != null && mViewRef?.get() != null;
    }

    override fun detachView() {
        mViewRef?.clear()
    }
}
