package com.allan.player.ui.activity

import android.preference.PreferenceManager
import android.support.v7.widget.Toolbar
import com.allan.player.R
import com.allan.player.base.BaseActivity
import com.allan.player.util.ToolBarManager
import org.jetbrains.anko.find

/**
 * Created by Regina on 2017-09-24.
 */
class SettingActivity: BaseActivity(), ToolBarManager {
    override val toolBar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun getLayoutId(): Int {

        return R.layout.activity_setting
    }

    override fun initView() {
        initSettingToolBar()
    }


    override fun initData() {
        val sp = PreferenceManager.getDefaultSharedPreferences(this)
        val push = sp.getBoolean("push", false)
        println("push = ${push}")
    }

}