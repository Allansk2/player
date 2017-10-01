package com.allan.player.ui.fragment

import com.allan.player.adapter.YueDanAdapter
import com.allan.player.base.BaseListAdapter
import com.allan.player.base.BaseListFragment
import com.allan.player.base.BaseListPresenter
import com.allan.player.model.YueDanBean
import com.allan.player.presenter.impl.YueDanPresenterImpl
import com.allan.player.widget.YueDanItemView

/**
 * Created by Regina on 2017-09-24.
 */
class YueDanFragment: BaseListFragment<YueDanBean, YueDanBean.PlayListsBean, YueDanItemView>() {

    override fun getList(response: YueDanBean?): List<YueDanBean.PlayListsBean>? {
        return response?.playLists
    }


    override fun getMyAdapter(): BaseListAdapter<YueDanBean.PlayListsBean, YueDanItemView> {
        return YueDanAdapter()
    }

    override fun getMyPresenter(): BaseListPresenter {
        return YueDanPresenterImpl(this)
    }

}