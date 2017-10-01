package com.allan.player.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.allan.player.base.BaseListAdapter
import com.allan.player.model.HomeItemBean
import com.allan.player.model.YueDanBean
import com.allan.player.widget.LoadMoreView
import com.allan.player.widget.YueDanItemView

/**
 * Created by Regina on 2017-09-24.
 */
class YueDanAdapter: BaseListAdapter<YueDanBean.PlayListsBean, YueDanItemView>() {

    override fun refreshView(itemView: YueDanItemView, item: YueDanBean.PlayListsBean) {
        itemView.setData(item)
    }

    override fun getItemView(context: Context?): YueDanItemView {
        return YueDanItemView(context)
    }

}