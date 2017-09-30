package com.allan.player.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.allan.player.R
import com.allan.player.model.YueDanBean
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import kotlinx.android.synthetic.main.item_yuedan.view.*

/**
 * Created by Regina on 2017-09-30.
 */
class YueDanItemView: RelativeLayout {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        View.inflate(context, R.layout.item_yuedan, this)

    }

    /**
     * update item content
     */
    fun setData(item: YueDanBean.PlayListsBean) {
        // song description
        title.text = item.title
        // author name
        author_name.text = item.creator?.nickName
        // count
        count.text = item.videoCount.toString()
        // background image
        Picasso.with(context).load(item.playListBigPic).into(bg)
        // author image
        Picasso.with(context)
                .load(item.creator?.largeAvatar)
                .transform(CropCircleTransformation())
                .into(author_iv)
    }

}