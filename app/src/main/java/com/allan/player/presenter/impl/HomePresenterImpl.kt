package com.allan.player.presenter.impl

import com.allan.player.R.id.home
import com.allan.player.R.id.refreshLayout
import com.allan.player.model.HomeItemBean
import com.allan.player.net.HomeRequest
import com.allan.player.net.NetworkManager
import com.allan.player.net.ResponseHandler
import com.allan.player.presenter.interf.HomePresenter
import com.allan.player.presenter.interf.HomePresenter.Companion.TYPE_LOAD_MORE
import com.allan.player.presenter.interf.HomePresenter.Companion.TYPE_NORMAL
import com.allan.player.util.ThreadUtil
import com.allan.player.util.URLProviderUtils
import com.allan.player.view.HomeView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.squareup.picasso.RequestHandler
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.*
import java.io.IOException

/**
 * Created by Regina on 2017-09-30.
 */
class HomePresenterImpl(var homeView: HomeView): HomePresenter, ResponseHandler<List<HomeItemBean>> {

    /**
     * initial data or refresh data
     */
    override fun loadData() {

        val request = HomeRequest(TYPE_NORMAL, 0, this).execute()
    }

    override fun loadMoreData(offset: Int) {

        val request = HomeRequest(TYPE_LOAD_MORE, offset, this).execute()
    }

    override fun onError(type: Int, msg: String?) {
        homeView.onError(msg)
    }

    override fun onSuccess(type: Int, result: List<HomeItemBean>) {
        when(type) {
            TYPE_NORMAL -> homeView.loadSuccess(result)
            TYPE_LOAD_MORE -> homeView.loadMoreSuccess(result)
        }
    }

}