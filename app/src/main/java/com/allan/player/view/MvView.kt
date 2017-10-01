package com.allan.player.view

import com.allan.player.model.MvAreaBean

/**
 * Created by Regina on 2017-09-30.
 */
interface MvView {
    // get data fail
    fun onError(message: String?)
    // get data success
    fun loadSuccess(list: List<MvAreaBean>?)
}