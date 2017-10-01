package com.allan.player.presenter.impl

import com.allan.player.model.HomeItemBean
import com.allan.player.model.MvAreaBean
import com.allan.player.net.MvAreaRequest
import com.allan.player.net.ResponseHandler
import com.allan.player.presenter.interf.MvPresenter
import com.allan.player.view.MvView

/**
 * Created by Regina on 2017-09-30.
 */
class MvPresenterImpl(val mvView: MvView): MvPresenter, ResponseHandler<List<MvAreaBean>> {

    /**
     * load area data
     */
    override fun loadData() {
        MvAreaRequest(this).execute()
    }

    override fun onError(type: Int, msg: String?) {
        mvView.onError(msg)
    }

    override fun onSuccess(type: Int, result: List<MvAreaBean>) {
        mvView.loadSuccess(result)
    }
}