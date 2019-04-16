package com.frame.mvp.common.base

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Keep
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

@Keep
abstract class BaseMvpFragment<P : IPresenter<V>, V> : BaseFragment() {

    var mPresenter: P? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mPresenter = createPresenter()
        mPresenter?.attachView(this as V)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId(), container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView(savedInstanceState)
        mPresenter?.start()
    }

    override fun onDetach() {
        mPresenter?.detachView()
        super.onDetach()
    }

    protected abstract fun createPresenter(): P

}
