package com.allan.player.util

import com.allan.player.R
import com.allan.player.base.BaseFragment
import com.allan.player.ui.fragment.HomeFragment
import com.allan.player.ui.fragment.MvFragment
import com.allan.player.ui.fragment.VBangFragment
import com.allan.player.ui.fragment.YueDanFragment

/**
 * manager fragment util
 * Created by Regina on 2017-09-24.
 */
class FragmentUtil private constructor(){
    companion object {
        val fragmentUtil by lazy { FragmentUtil() }
    }

    val homeFragment by lazy { HomeFragment() }
    val mvFragment by lazy { MvFragment() }
    val vbangFragment by lazy { VBangFragment() }
    val yuedanFragment by lazy { YueDanFragment() }

    /**
     * get fragment by tab id
     */
    fun getFragment(tabId: Int):BaseFragment? {
        when(tabId) {
            R.id.tab_home -> return homeFragment
            R.id.tab_mv -> return mvFragment
            R.id.tab_vbang -> return vbangFragment
            R.id.tab_yuedan -> return yuedanFragment
        }
        return null
    }
}