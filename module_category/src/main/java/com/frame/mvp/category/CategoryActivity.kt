package com.frame.mvp.category

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.alibaba.android.arouter.facade.annotation.Route
import com.frame.mvp.common.base.BaseActivity

@Route(path = "/main/category")
class CategoryActivity : BaseActivity() {
    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun layoutId():  Int {
        return R.layout.activity_category
    }

}
