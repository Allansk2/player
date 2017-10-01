package com.allan.player.presenter.impl

import com.allan.player.base.BaseListPresenter
import com.allan.player.model.MvPagerBean
import com.allan.player.net.MvListRequest
import com.allan.player.net.ResponseHandler
import com.allan.player.presenter.interf.MvListPresenter
import com.allan.player.view.MvListView

/**
 * Created by Regina on 2017-09-30.
 */
class MvListPresenterImpl(var code:String, var mvListView: MvListView?): MvListPresenter, ResponseHandler<MvPagerBean> {


    override fun loadData() {
        MvListRequest(code, BaseListPresenter.TYPE_NORMAL, 0, this).execute()
    }

    override fun loadMoreData(offset: Int) {
        MvListRequest(code, BaseListPresenter.TYPE_LOAD_MORE, offset, this).execute()

    }

    override fun viewDestroy() {
        mvListView.let {
            mvListView = null
        }
    }

    override fun onError(type: Int, msg: String?) {
        mvListView?.onError(msg)
    }

    override fun onSuccess(type: Int, result: MvPagerBean) {
        when(type) {
            BaseListPresenter.TYPE_NORMAL -> mvListView?.loadSuccess(result)
            BaseListPresenter.TYPE_LOAD_MORE -> mvListView?.loadMoreSuccess(result)
        }
    }
}