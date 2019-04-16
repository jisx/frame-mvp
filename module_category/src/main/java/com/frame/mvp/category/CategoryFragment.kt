package com.frame.mvp.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.alibaba.android.arouter.launcher.ARouter
import com.frame.mvp.category.contract.CategoryContract
import com.frame.mvp.category.presenter.CategoryPresenter
import com.frame.mvp.common.base.BaseFragment
import com.frame.mvp.common.base.BaseMvpFragment
import kotlinx.android.synthetic.main.fragment_category.*

class CategoryFragment : BaseMvpFragment<CategoryPresenter, CategoryContract.View>(), CategoryContract.View {
    override fun layoutId(): Int {
        return R.layout.fragment_category
    }

    override fun initView(savedInstanceState: Bundle?) {
        tv_test.setOnClickListener { ARouter.getInstance().build("/main/category").navigation(); }
    }

    override fun createPresenter(): CategoryPresenter {
        return CategoryPresenter()
    }

    override fun showToast() {
        Toast.makeText(context,"adf",Toast.LENGTH_LONG).show()
    }
}
