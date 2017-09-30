package com.allan.player.presenter.impl

import android.util.Log
import com.allan.player.model.HomeItemBean
import com.allan.player.net.HomeRequest
import com.allan.player.net.ResponseHandler
import com.allan.player.presenter.interf.HomePresenter
import com.allan.player.presenter.interf.HomePresenter.Companion.TYPE_LOAD_MORE
import com.allan.player.presenter.interf.HomePresenter.Companion.TYPE_NORMAL
import com.allan.player.view.HomeView

/**
 * Created by Regina on 2017-09-30.
 */
class HomePresenterImpl(var homeView: HomeView?): HomePresenter, ResponseHandler<List<HomeItemBean>> {

    override fun viewDestroy(){
        homeView.let {
            homeView = null
        }
    }

    /**
     * initial data or refresh data
     */
    override fun loadData() {
        HomeRequest(TYPE_NORMAL, 0, this).execute()
    }

    override fun loadMoreData(offset: Int) {
        HomeRequest(TYPE_LOAD_MORE, offset, this).execute()
    }

    override fun onError(type: Int, msg: String?) {
        homeView?.onError(msg)
    }

    override fun onSuccess(type: Int, result: List<HomeItemBean>) {
        when(type) {
            TYPE_NORMAL -> homeView?.loadSuccess(result)
            TYPE_LOAD_MORE -> homeView?.loadMoreSuccess(result)
        }
    }

}