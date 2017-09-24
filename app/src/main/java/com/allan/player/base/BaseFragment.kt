package com.allan.player.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.runOnUiThread
import org.jetbrains.anko.toast

/**
 * base fragment
 * Created by Regina on 2017-09-24.
 */
abstract class BaseFragment: Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return initView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initListner()
        initData()
    }


    /**
     * get layout view
     */
    abstract fun initView(): View?


    /**
     * initial in onCreate
     */
    protected fun init() {
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
        context.runOnUiThread { toast(message) }
    }

}