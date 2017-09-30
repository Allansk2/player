package com.allan.player.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.allan.player.model.HomeItemBean
import com.allan.player.model.YueDanBean
import com.allan.player.widget.LoadMoreView
import com.allan.player.widget.YueDanItemView

/**
 * Created by Regina on 2017-09-24.
 */
class YueDanAdapter : RecyclerView.Adapter<YueDanAdapter.YueDanHolder>() {

    val normalView = 0
    val loadMoreView = 1


    private var list = ArrayList<YueDanBean.PlayListsBean>()

    /**
     * update date and UI
     */
    fun updateData(list: List<YueDanBean.PlayListsBean>?) {
        list?.let {
            this.list.clear()
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }

    /**
     * add more data to list
     */
    fun loadMoreData(list: List<YueDanBean.PlayListsBean>?) {
        list?.let {
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): YueDanHolder {
        if (viewType == normalView) {
            return YueDanHolder(YueDanItemView(parent?.context))
        }else {
            return YueDanHolder(LoadMoreView(parent?.context))
        }
    }

    override fun onBindViewHolder(holder: YueDanHolder, position: Int) {
        if (position == list.size) return
        // get item data
        val item = list.get(position)
        // get item view
        val itemView = holder.itemView as YueDanItemView
        // update item view
        itemView.setData(item)


    }

    override fun getItemViewType(position: Int): Int {
        if (position == list.size) {
            return loadMoreView
        }
        return normalView
    }

    override fun getItemCount(): Int {
        return list.size + 1
    }


    class YueDanHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }
}