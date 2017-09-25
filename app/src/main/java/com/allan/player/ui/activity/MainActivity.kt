package com.allan.player.ui.activity

import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.allan.player.R
import com.allan.player.base.BaseActivity
import com.allan.player.base.BaseFragment
import com.allan.player.util.FragmentUtil
import com.allan.player.util.ToolBarManager
import kotlinx.android.synthetic.main.activity_main.*
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

    override fun initListner() {
        // set tab bar listner
        bottomBar.setOnTabSelectListener{

            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, FragmentUtil.fragmentUtil.getFragment(it), it.toString())
            transaction.commit()
        }

    }

}
