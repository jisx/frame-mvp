package com.frame.mvp.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.frame.mvp.common.bean.FragmentBean
import kotlinx.android.synthetic.main.activity_main.*

@Route(path = "/main/main")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabFragmentName = resources.getStringArray(R.array.main_tab_fragment)
        val tabFragmentTitle = resources.getStringArray(R.array.main_tab_title)

        val fragmentList: MutableList<FragmentBean> = mutableListOf()

        for (index in tabFragmentName.indices) {
            try {
                var fragmentClass = Class.forName(tabFragmentName[index])
                var newInstance = fragmentClass.getDeclaredConstructor().newInstance()
                if (newInstance is Fragment) {
                    fragmentList.add(FragmentBean(tabFragmentTitle[index], newInstance))
                }
            } catch (e: Exception) {
                continue
            }
        }

        viewPager.adapter = FragmentAdapter(supportFragmentManager, fragmentList)
        tabLayout.setupWithViewPager(viewPager)

    }

}
