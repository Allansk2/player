package com.allan.player.base

import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.allan.player.R
import com.allan.player.adapter.HomeAdapter
import com.allan.player.model.HomeItemBean
import com.allan.player.presenter.impl.HomePresenterImpl
import com.allan.player.view.HomeView
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * Created by Regina on 2017-09-30.
 */
abstract class BaseListFragment<RESPONSE, BEAN, ITEMVIEW: View> : BaseFragment(), BaseView<RESPONSE> {

    // set adapter
    val adapter by lazy { getMyAdapter() }
    val presenter by lazy { getMyPresenter() }


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
        refreshLayout.isRefreshing = false
        myToast("Load data fail")
    }

    override fun loadSuccess(response: RESPONSE?) {
        if (refreshLayout != null) {
            refreshLayout.isRefreshing = false
        }
        adapter.updateData(getList(response))
    }



    override fun loadMoreSuccess(response: RESPONSE?) {
        if (refreshLayout != null) {
            refreshLayout.isRefreshing = false
        }
        adapter.loadMoreData(getList(response))
    }


    abstract fun getList(response: RESPONSE?): List<BEAN>?

    /**
     * get adapter
     */
    abstract fun getMyAdapter(): BaseListAdapter<BEAN, ITEMVIEW>


    /**
     * get presenter
     */
    abstract fun getMyPresenter(): BaseListPresenter
}