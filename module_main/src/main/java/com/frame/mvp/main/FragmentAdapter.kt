package com.frame.mvp.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.frame.mvp.common.bean.FragmentBean

class FragmentAdapter(fm: FragmentManager, private val fragmentList: MutableList<FragmentBean>) :
    FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItem(position: Int): Fragment? {
        return fragmentList[position].fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentList[position].title
    }
}
