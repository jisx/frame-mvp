package com.frame.mvp.common.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent

/**
 *
 * 可以禁止滑动翻页的ViewPager
 *
 * @author 张华洋 2017/9/27 10:10
 * @version V1.1
 * @name NoScrollViewPager
 */
class NoScrollViewPager : androidx.viewpager.widget.ViewPager {

    private var isPagingEnabled = true

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return this.isPagingEnabled && super.onTouchEvent(event)
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return this.isPagingEnabled && super.onInterceptTouchEvent(event)
    }

    fun setPagerEnabled(b: Boolean) {
        this.isPagingEnabled = b
    }

}
