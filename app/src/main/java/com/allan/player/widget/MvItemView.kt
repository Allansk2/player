package com.allan.player.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.allan.player.R
import com.allan.player.model.VideosBean
import com.allan.player.model.YueDanBean
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import kotlinx.android.synthetic.main.item_mv.view.*

/**
 * Created by Regina on 2017-09-30.
 */
class MvItemView : RelativeLayout {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        View.inflate(context, R.layout.item_mv, this)

    }

    /**
     * update item content
     */
    fun setData(item: VideosBean) {
        // song description
        title.text = item.title
        // artis name
        artis.text = item.artistName

        // background image
        Picasso.with(context).load(item.playListPic).into(bg)

    }

}