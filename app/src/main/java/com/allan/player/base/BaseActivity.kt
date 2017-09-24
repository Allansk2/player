package com.allan.player.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.toast

/**
 * Base activity for all activities in this app
 * Created by Regina on 2017-09-24.
 */
abstract class BaseActivity: AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initView()
        initListner()
        initData()

    }

    /**
     * get layout id
     */
    protected abstract fun getLayoutId(): Int

    /**
     * initial views
     */
    protected fun initView() {

    }

    /**
     * initial list data
     */
    protected fun initData() {

    }

    /**
     * init adapter listner
     */
    protected fun initListner() {
    }


    /**
     * show a toast with anko toast fun
     * anko toast doesn't necessary make a toast on UI
     */
    protected fun myToast(message: String) {
        runOnUiThread {  toast(message) }
    }

}