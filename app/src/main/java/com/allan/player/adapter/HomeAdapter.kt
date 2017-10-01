package com.allan.player.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.allan.player.base.BaseListAdapter
import com.allan.player.model.HomeItemBean
import com.allan.player.widget.HomeItemView
import com.allan.player.widget.LoadMoreView


/**
 * Created by Regina on 2017-09-24.
 */
class HomeAdapter: BaseListAdapter<HomeItemBean, HomeItemView>() {
    override fun refreshView(itemView: HomeItemView, item: HomeItemBean) {
        itemView.setData(item)
    }

    override fun getItemView(context: Context?): HomeItemView {
        return HomeItemView(context)
    }
}
