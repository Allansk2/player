package com.allan.player.adapter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.allan.player.model.MvAreaBean
import com.allan.player.ui.fragment.MvPagerFragment

/**
 * Created by Regina on 2017-09-30.
 */
class MvPagerAdapter(val list: List<MvAreaBean>?, fm: FragmentManager?) : FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {
        val fragment = MvPagerFragment()
        val bundle = Bundle()
        bundle.putString("args", list?.get(position)?.name)
        fragment.arguments = bundle
        return fragment
    }

    override fun getCount(): Int {
        return list?.size?:0
    }

    override fun getPageTitle(position: Int): CharSequence {
        return list?.get(position)?.name?:""
    }
}