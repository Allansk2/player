package com.allan.player.ui.fragment

import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.allan.player.R
import com.allan.player.adapter.HomeAdapter
import com.allan.player.adapter.YueDanAdapter
import com.allan.player.base.BaseFragment
import com.allan.player.model.HomeItemBean
import com.allan.player.model.YueDanBean
import com.allan.player.presenter.impl.HomePresenterImpl
import com.allan.player.presenter.impl.YueDanPresenterImpl
import com.allan.player.view.YueDanView
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * Created by Regina on 2017-09-24.
 */
class YueDanFragment : BaseFragment(), YueDanView {


    // set adapter
    val adapter by lazy { YueDanAdapter() }
    val presenter by lazy { YueDanPresenterImpl(this) }

    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_list, null)
    }

    override fun initListner() {

        recycleView.layoutManager = LinearLayoutManager(context)
        recycleView.adapter = adapter

        // initial refresh layout
        refreshLayout.setColorSchemeColors(Color.RED, Color.YELLOW, Color.GREEN)
        // refresh listner
        refreshLayout.setOnRefreshListener {
            presenter.loadData()
        }

        // adapter listner
        recycleView.addOnScrollListener(object : RecyclerView.OnScrollListener(){

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    val layoutManager = recyclerView.layoutManager
                    if (layoutManager is LinearLayoutManager) {
                        val manager: LinearLayoutManager = layoutManager
                        val last = manager.findLastVisibleItemPosition()
                        if (last == adapter.itemCount - 1) {
                            // last visible item is the last item
                            presenter.loadMoreData(adapter.itemCount - 1)
                        }
                    }
                }
            }
        })

    }

    override fun initData() {
        // initial data
        presenter.loadData()
    }

    override fun onError(message: String?) {
        myToast("Load data fail")
    }

    override fun loadSuccess(response: YueDanBean?) {
        refreshLayout.isRefreshing = false
        adapter.updateData(response?.playLists)    }

    override fun loadMoreSuccess(response: YueDanBean?) {
        refreshLayout.isRefreshing = false
        adapter.loadMoreData(response?.playLists)
    }

}