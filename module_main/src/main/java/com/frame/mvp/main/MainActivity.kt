package com.frame.mvp.main

import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import com.frame.mvp.home.R

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabFragmentName = resources.getStringArray(R.array.main_tab)

        val fragmentList: MutableList<Fragment> = mutableListOf()
        for (s in tabFragmentName) {
            var fragmentClass = Class.forName(s)
            if (fragmentClass is Fragment) {
                fragmentList.add(fragmentClass)
            }
        }

        viewPager.adapter = object:PagerAdapter(){
            override fun isViewFromObject(view: View, `object`: Any): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun getCount(): Int {
                return fragmentList.size
            }

        }


    }

}
