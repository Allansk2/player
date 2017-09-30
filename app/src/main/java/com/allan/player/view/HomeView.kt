package com.allan.player.view

import com.allan.player.model.HomeItemBean

/**
 * Created by Regina on 2017-09-30.
 */
interface HomeView {
    // get data fail
    fun onError(message: String?)
    // get data success or refresh data success
    fun loadSuccess(list: List<HomeItemBean>?)
    // load more data success
    fun loadMoreSuccess(list: List<HomeItemBean>?)

}