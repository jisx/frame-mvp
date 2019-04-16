package com.frame.mvp.common.base

import android.os.Bundle
import androidx.annotation.Keep

/**
 * mvp的基类
 *
 * @author jsx
 *
 */
@Keep
abstract class BaseMvpActivity<P : IPresenter<V>, V> : BaseActivity() {

    var mPresenter: P? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView(savedInstanceState)
        mPresenter = createPresenter()
        mPresenter?.attachView(this as V)
        mPresenter?.start()
    }

    override fun onDestroy() {
        mPresenter?.detachView()
        super.onDestroy()
    }

    protected abstract fun createPresenter(): P
}
