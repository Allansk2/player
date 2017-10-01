package com.allan.player.base

/**
 * Created by Regina on 2017-09-30.
 */
interface BaseListPresenter {
    companion object {
        val TYPE_NORMAL = 0
        val TYPE_LOAD_MORE = 1
    }

    // get data
    fun loadData()
    // get more data
    fun loadMoreData(offset: Int)

    fun viewDestroy()
}