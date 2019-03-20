package com.frame.mvp.common.base

import android.os.Bundle
import androidx.annotation.Keep
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.frame.mvp.common.R

/**
 *
 * Activity基类
 *
 * @author 2016/12/2 17:33
 * @version V1.0.0
 * @name BaseActivity
 */
@Keep
abstract class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewManager.INSTANCE.addActivity(this)
    }


    override fun onDestroy() {
        super.onDestroy()
        ViewManager.INSTANCE.finishActivity(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    /**
     * Setup the toolbar.
     *
     * @param toolbar   toolbar
     * @param hideTitle 是否隐藏Title
     */
    protected fun setupToolBar(toolbar: Toolbar, hideTitle: Boolean) {
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back)
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowHomeEnabled(true)
            if (hideTitle) {
                //隐藏Title
                actionBar.setDisplayShowTitleEnabled(false)
            }
        }
    }

}
