package com.allan.player.ui.activity

import com.allan.player.R
import com.allan.player.base.BaseActivity
import com.allan.player.model.VideoPlayBean
import kotlinx.android.synthetic.main.activity_video_player.*

/**
 * Created by Regina on 2017-10-01.
 */
class VideoPlayerActivity: BaseActivity() {


    override fun getLayoutId(): Int {
        return R.layout.activity_video_player

    }

    override fun initData() {
        // get data
        var videoPlayBean = intent.getParcelableExtra<VideoPlayBean>("item")
        videoView.setVideoPath(videoPlayBean.url)
        videoView.setOnPreparedListener{
            videoView.start()
        }

    }
}