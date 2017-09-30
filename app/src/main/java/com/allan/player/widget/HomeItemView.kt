package com.allan.player.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.View.inflate
import android.widget.RelativeLayout
import com.allan.player.R
import com.allan.player.model.HomeItemBean
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_home.view.*

/**
 * Created by Regina on 2017-09-24.
 */
class HomeItemView: RelativeLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        View.inflate(context, R.layout.item_home, this)

    }


    /**
     * update item content
     */
    fun setData(item: HomeItemBean) {
        // song name
        title.text = item.title
        // sond description
        desc.text = item.description
        // background image
        Picasso.with(context).load(item.posterPic).into(bg)
    }


}