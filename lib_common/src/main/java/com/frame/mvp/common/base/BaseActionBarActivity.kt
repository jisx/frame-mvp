package com.frame.mvp.common.base

import android.os.Bundle
import androidx.annotation.Keep
import androidx.annotation.StringRes
import androidx.appcompat.app.ActionBar
import com.frame.mvp.common.R

/**
 * BaseActionBarActivity继承于BaseActivity，封装了actionBar的逻辑；
 * 继承于ActionBarBaseActivity的Activity都将默认带有ActionBar，并且只能使用AppTheme主题；
 * 只有那些ActionBar只带有Title和返回按钮的Activity方可继承
 *
 * @author 张华洋 2017/3/7 18:36
 * @version V1.2.0
 * @name BaseActionBarActivity
 */
@Keep
abstract class BaseActionBarActivity : BaseActivity() {

    /*默认的ActionBar*/
    protected var mActionBar: ActionBar? = null

    /**
     * 设置默认标题id
     *
     * @return 标题id
     */
    @StringRes
    protected abstract fun setTitleId(): Int


    /**
     * 更新标题
     *
     * @param title String标题
     */
    protected fun setTitle(title: String) {
        if (mActionBar != null) {
            mActionBar!!.title = title
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //标题栏设置
        mActionBar = supportActionBar
        if (mActionBar != null) {
            mActionBar!!.setHomeAsUpIndicator(R.drawable.ic_arrow_back)
            mActionBar!!.setDisplayHomeAsUpEnabled(true)
            mActionBar!!.setHomeButtonEnabled(true)
            mActionBar!!.setTitle(setTitleId())
        }
    }

}
