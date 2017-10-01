package com.allan.player.ui.fragment

import android.graphics.Color
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.allan.player.R
import com.allan.player.adapter.MvPagerAdapter
import com.allan.player.base.BaseFragment
import com.allan.player.model.MvAreaBean
import com.allan.player.presenter.impl.MvPresenterImpl
import com.allan.player.view.MvView
import kotlinx.android.synthetic.main.fragment_mv.*

/**
 * Created by Regina on 2017-09-24.
 */
class MvFragment: BaseFragment(), MvView {

    val presenter by lazy { MvPresenterImpl(this) }

    override fun initView(): View? {
       return View.inflate(context, R.layout.fragment_mv, null)
    }

    override fun initListner() {


    }

    override fun initData() {
        // load area data
        presenter.loadData()
    }

    override fun onError(message: String?) {
        myToast("Load data fail")
    }

    override fun loadSuccess(list: List<MvAreaBean>?) {
        val adapter = MvPagerAdapter(context, list, childFragmentManager)
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }

}