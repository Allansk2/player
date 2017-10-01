package com.allan.player.adapter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.allan.player.ui.fragment.DefaultFragment
import com.allan.player.ui.fragment.MvPagerFragment

/**
 * Created by Regina on 2017-10-01.
 */
class VideoPagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return DefaultFragment()
    }

    override fun getCount(): Int {
        return 3
    }
}