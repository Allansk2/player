package com.allan.player.ui.fragment

import com.allan.player.adapter.HomeAdapter
import com.allan.player.base.BaseListAdapter
import com.allan.player.base.BaseListFragment
import com.allan.player.base.BaseListPresenter
import com.allan.player.model.HomeItemBean
import com.allan.player.presenter.impl.HomePresenterImpl
import com.allan.player.widget.HomeItemView

/**
 * Created by Regina on 2017-09-24.
 */
class HomeFragment: BaseListFragment<List<HomeItemBean>, HomeItemBean, HomeItemView>() {
    override fun getList(response: List<HomeItemBean>?): List<HomeItemBean>? {
        return response
    }

    override fun getMyAdapter(): BaseListAdapter<HomeItemBean, HomeItemView> {
        return HomeAdapter()
    }

    override fun getMyPresenter(): BaseListPresenter {
        return HomePresenterImpl(this)
    }

}