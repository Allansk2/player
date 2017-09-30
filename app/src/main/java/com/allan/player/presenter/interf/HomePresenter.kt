package com.allan.player.presenter.interf

/**
 * Created by Regina on 2017-09-30.
 */
interface HomePresenter {
    companion object {
        val TYPE_NORMAL = 0
        val TYPE_LOAD_MORE = 1
    }

    // get data
    fun loadData()
    // get more data
    fun loadMoreData(offset: Int)
}