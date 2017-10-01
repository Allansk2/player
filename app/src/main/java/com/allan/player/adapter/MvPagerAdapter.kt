package com.allan.player.adapter

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.allan.player.model.MvAreaBean
import com.allan.player.ui.fragment.MvPagerFragment

/**
 * Created by Regina on 2017-09-30.
 */
class MvPagerAdapter(val context: Context, val list: List<MvAreaBean>?, fm: FragmentManager?) : FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {
//        val fragment = MvPagerFragment()
        val bundle = Bundle()
        bundle.putString("name", list?.get(position)?.name)
        bundle.putString("code", list?.get(position)?.code)
//        fragment.arguments = bundle

        val fragment = Fragment.instantiate(context,MvPagerFragment::class.java.name,bundle)
        return fragment
    }

    override fun getCount(): Int {
        return list?.size?:0
    }

    override fun getPageTitle(position: Int): CharSequence {
        return list?.get(position)?.name?:""
    }
}