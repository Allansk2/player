package com.allan.player.util

import android.os.Handler
import android.os.Looper

/**
 * Created by Regina on 2017-09-30.
 */
object ThreadUtil {
    val handler = Handler(Looper.getMainLooper())

    /**
     * run runnable on main thread
     */
    fun runOnMainThread(runnable: Runnable) {
        handler.post(runnable)
    }

}