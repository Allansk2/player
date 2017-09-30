package com.allan.player.presenter.impl

import com.allan.player.model.HomeItemBean
import com.allan.player.model.YueDanBean
import com.allan.player.net.HomeRequest
import com.allan.player.net.ResponseHandler
import com.allan.player.net.YueDanRequest
import com.allan.player.presenter.interf.HomePresenter
import com.allan.player.presenter.interf.YueDanPresenter
import com.allan.player.view.HomeView
import com.allan.player.view.YueDanView

/**
 * Created by Regina on 2017-09-30.
 */
class YueDanPresenterImpl(var yueDanView: YueDanView?): YueDanPresenter, ResponseHandler<YueDanBean> {

    /**
     * initial data or refresh data
     */
    override fun loadData() {
        YueDanRequest(YueDanPresenter.TYPE_NORMAL, 0, this).execute()
    }

    override fun loadMoreData(offset: Int) {
        YueDanRequest(YueDanPresenter.TYPE_LOAD_MORE, offset, this).execute()
    }


    override fun onError(type: Int, msg: String?) {
        yueDanView?.onError(msg)
    }

    override fun onSuccess(type: Int, result: YueDanBean) {
        when(type) {
            YueDanPresenter.TYPE_NORMAL -> yueDanView?.loadSuccess(result)
            YueDanPresenter.TYPE_LOAD_MORE -> yueDanView?.loadMoreSuccess(result)
        }
    }

    override fun viewDestroy(){
        yueDanView.let {
            yueDanView = null
        }
    }

}