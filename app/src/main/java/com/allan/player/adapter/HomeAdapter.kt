package com.allan.player.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.allan.player.model.HomeItemBean
import com.allan.player.widget.HomeItemView
import com.allan.player.widget.LoadMoreView


/**
 * Created by Regina on 2017-09-24.
 */
class HomeAdapter: RecyclerView.Adapter<HomeAdapter.HomeHolder>() {

    val normalView = 0
    val loadMoreView = 1


    private var list = ArrayList<HomeItemBean>()

    /**
     * update date and UI
     */
    fun updateData(list: List<HomeItemBean>?) {
        list?.let {
            this.list.clear()
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }

    /**
     * add more data to list
     */
    fun loadMoreData(list: List<HomeItemBean>?) {
        list?.let {
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HomeHolder {
        if (viewType == normalView) {
            return HomeHolder(HomeItemView(parent?.context))
        }else {
            return HomeHolder(LoadMoreView(parent?.context))
        }
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        if (position == list.size) return
        // get item data
        val item = list.get(position)
        // get item view
        val itemView = holder.itemView as HomeItemView
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


    class HomeHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }
}