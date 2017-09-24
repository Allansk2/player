package com.allan.player.ui.activity

import android.support.v4.view.ViewCompat
import android.support.v4.view.ViewPropertyAnimatorListener
import android.view.View
import com.allan.player.R
import com.allan.player.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.startActivity

/**
 * Created by Regina on 2017-09-24.
 */
class SplashActivity: BaseActivity(), ViewPropertyAnimatorListener {


    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun initData() {
        ViewCompat.animate(iv).scaleX(1.0f).scaleY(1.0f).setDuration(3000).setListener(this)
    }

    override fun onAnimationEnd(view: View?) {
        // go to main activity
        startActivityAndFinish<MainActivity>()
    }

    override fun onAnimationCancel(view: View?) {
    }

    override fun onAnimationStart(view: View?) {

    }

}