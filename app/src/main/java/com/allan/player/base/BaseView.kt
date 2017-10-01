package com.allan.player.base

/**
 * Created by Regina on 2017-09-30.
 */
interface BaseView<T> {
    // get data fail
    fun onError(message: String?)
    // get data success or refresh data success
    fun loadSuccess(list: T?)
    // load more data success
    fun loadMoreSuccess(list: T?)
}