package com.allan.player.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.allan.player.widget.HomeItemView


/**
 * Created by Regina on 2017-09-24.
 */
class HomeAdapter: RecyclerView.Adapter<HomeAdapter.HomeHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HomeHolder {
        return HomeHolder(HomeItemView(parent?.context))
    }

    override fun onBindViewHolder(holder: HomeHolder?, position: Int) {

    }

    override fun getItemCount(): Int {
        return 20
    }


    class HomeHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }
}