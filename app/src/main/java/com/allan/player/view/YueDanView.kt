package com.allan.player.view

import com.allan.player.model.HomeItemBean
import com.allan.player.model.YueDanBean

/**
 * Created by Regina on 2017-09-30.
 */
interface YueDanView {
    // get data fail
    fun onError(message: String?)
    // get data success or refresh data success
    fun loadSuccess(response: YueDanBean?)
    // load more data success
    fun loadMoreSuccess(response: YueDanBean?)

}