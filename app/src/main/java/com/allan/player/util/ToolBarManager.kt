package com.allan.player.util

import android.content.Intent
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.Toast
import com.allan.player.R
import com.allan.player.ui.activity.SettingActivity


/**
 * tool bar manager for all views
 * Created by Regina on 2017-09-24.
 */
interface ToolBarManager {
    val toolBar: Toolbar

    /**
     * initilize main activity tool bar
     */
    fun initMainToolBar(){
        toolBar.setTitle("万能影音")
        toolBar.inflateMenu(R.menu.main)
        toolBar.setOnMenuItemClickListener {
            toolBar.context.startActivity(Intent(toolBar.context, SettingActivity::class.java))
            true
        }

//        toolBar.setOnMenuItemClickListener(object :Toolbar.OnMenuItemClickListener{
//            override fun onMenuItemClick(item: MenuItem?): Boolean {
//                when(item?.itemId){
//                    R.id.setting -> {
//                        // go to setting activity
//                        toolBar.context.startActivity(Intent(toolBar.context, SettingActivity::class.java))
//                    }
//                }
//                return true
//            }
//
//        })
    }

    /**
     * initilize setting activity tool bar
     */
    fun initSettingToolBar(){
        toolBar.setTitle("设置")
    }


}