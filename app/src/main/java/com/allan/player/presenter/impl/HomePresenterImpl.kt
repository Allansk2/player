package com.allan.player.presenter.impl

import com.allan.player.R.id.refreshLayout
import com.allan.player.model.HomeItemBean
import com.allan.player.presenter.interf.HomePresenter
import com.allan.player.util.ThreadUtil
import com.allan.player.util.URLProviderUtils
import com.allan.player.view.HomeView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.*
import java.io.IOException

/**
 * Created by Regina on 2017-09-30.
 */
class HomePresenterImpl(var homeView: HomeView): HomePresenter {

    /**
     * initial data or refresh data
     */
    override fun loadData() {
        val url = URLProviderUtils.getHomeUrl(0, 20)
        val client = OkHttpClient()
        val request = Request.Builder()
                .url(url)
                .get()
                .build()
        client.newCall(request).enqueue(object : Callback {
            /**
             * callback not in main thread
             */
            override fun onFailure(call: Call?, e: IOException?) {
                ThreadUtil.runOnMainThread(object :Runnable{
                    override fun run() {
                        // return to view
                        homeView.onError(e?.message)
                    }
                })
            }
            override fun onResponse(call: Call?, response: Response?) {
                val result = response?.body()?.string()
                val gson = Gson()
                val list = gson.fromJson<List<HomeItemBean>>(result, object : TypeToken<List<HomeItemBean>>(){}.type)
                // update list
                ThreadUtil.runOnMainThread(object :Runnable{
                    override fun run() {
                        homeView.loadSuccess(list)
                    }
                })

            }
        })

    }

    override fun loadMoreData(offset: Int) {

        val url = URLProviderUtils.getHomeUrl(offset, 20)
        val client = OkHttpClient()
        val request = Request.Builder()
                .url(url)
                .get()
                .build()
        client.newCall(request).enqueue(object : Callback {
            /**
             * callback not in main thread
             */
            override fun onFailure(call: Call?, e: IOException?) {
                ThreadUtil.runOnMainThread(object :Runnable{
                    override fun run() {
                        homeView.onError(e?.message)
                    }
                })
            }
            override fun onResponse(call: Call?, response: Response?) {
                val result = response?.body()?.string()
                val gson = Gson()
                val list = gson.fromJson<List<HomeItemBean>>(result, object :TypeToken<List<HomeItemBean>>(){}.type)
                // update list
                ThreadUtil.runOnMainThread(object :Runnable{
                    override fun run() {
                        homeView.loadMoreSuccess(list)
                    }
                })

            }
        })
    }


}