package com.allan.player.base

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.allan.player.adapter.HomeAdapter
import com.allan.player.model.HomeItemBean
import com.allan.player.widget.HomeItemView
import com.allan.player.widget.LoadMoreView

/**
 * Created by Regina on 2017-09-30.
 */
abstract class BaseListAdapter<BEAN, ITEMVIEW: View> : RecyclerView.Adapter<BaseListAdapter.BaseListHolder>() {

    val normalView = 0
    val loadMoreView = 1


    private var list = ArrayList<BEAN>()

    /**
     * update date and UI
     */
    fun updateData(list: List<BEAN>?) {
        list?.let {
            this.list.clear()
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }

    /**
     * add more data to list
     */
    fun loadMoreData(list: List<BEAN>?) {
        list?.let {
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseListHolder {
        if (viewType == normalView) {
            return BaseListHolder(getItemView(parent?.context))
        }else {
            return BaseListHolder(LoadMoreView(parent?.context))
        }
    }



    override fun onBindViewHolder(holder: BaseListHolder, position: Int) {
        if (position == list.size) return
        // get item data
        val item = list.get(position)
        // get item view
        val itemView = holder.itemView as ITEMVIEW
        // update item view
        refreshView(itemView, item)
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


    class BaseListHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    /**
     * set the item view content
     */
    abstract fun refreshView(itemView: ITEMVIEW, item: BEAN)

    /**
     * get item view
     */
    abstract fun getItemView(context: Context?): ITEMVIEW
}