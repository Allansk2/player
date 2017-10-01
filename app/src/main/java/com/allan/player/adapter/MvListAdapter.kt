package com.allan.player.adapter

import android.content.Context
import com.allan.player.base.BaseListAdapter
import com.allan.player.model.VideosBean
import com.allan.player.widget.MvItemView

/**
 * Created by Regina on 2017-09-30.
 */
class MvListAdapter: BaseListAdapter<VideosBean, MvItemView>() {

    override fun refreshView(itemView: MvItemView, item: VideosBean) {
        itemView.setData(item)
    }

    override fun getItemView(context: Context?): MvItemView {
        return MvItemView(context)
    }
}