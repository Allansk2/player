package com.allan.player.ui.fragment

import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.allan.player.R
import com.allan.player.adapter.HomeAdapter
import com.allan.player.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by Regina on 2017-09-24.
 */
class HomeFragment: BaseFragment() {

    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_home, null)
    }

    override fun initListner() {
        recycleView.layoutManager = LinearLayoutManager(context)
        // set adapter
        val adapter = HomeAdapter()
        recycleView.adapter = adapter
    }

}