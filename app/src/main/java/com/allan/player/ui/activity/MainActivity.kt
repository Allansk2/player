package com.allan.player.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.allan.player.R
import com.allan.player.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutId(): Int {
        return  R.layout.activity_main
    }

}
