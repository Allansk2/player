package com.allan.player.ui.activity

import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.allan.player.R
import com.allan.player.base.BaseActivity
import com.allan.player.util.ToolBarManager
import org.jetbrains.anko.find

class MainActivity : BaseActivity(), ToolBarManager{

    override val toolBar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutId(): Int {
        return  R.layout.activity_main
    }


    override fun initView() {
        initMainToolBar()
    }

}
