package com.frame.mvp.common.base

import android.os.Bundle
import androidx.annotation.Keep
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.frame.mvp.common.R
import com.frame.mvp.common.utils.setupActionBar

/**
 * [ViewManager] 管理所有的activity,主要是方便销毁
 * 统一设置toolbar
 * @author jsx
 *
 */
@Keep
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewManager.addActivity(this)
        setContentView(layoutId())

        setupActionBar(R.id.toolbar){
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setDisplayShowTitleEnabled(false)//隐藏标题
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        ViewManager.finishActivity(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    @LayoutRes
    protected abstract fun layoutId(): Int

    protected abstract fun initView(savedInstanceState: Bundle?)

}
