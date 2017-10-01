package com.allan.player.ui.activity

import com.allan.player.R
import com.allan.player.base.BaseActivity
import com.allan.player.model.VideoPlayBean
import io.vov.vitamio.LibsChecker
import kotlinx.android.synthetic.main.activity_video_player_vitamio.*


/**
 * Created by Regina on 2017-10-01.
 */
class VitamioVideoPlayerActivity : BaseActivity() {


    override fun getLayoutId(): Int {
        return R.layout.activity_video_player_vitamio

    }

    override fun initData() {
        // initial vitamio
        LibsChecker.checkVitamioLibs(this)

        // get data
        var videoPlayBean = intent.getParcelableExtra<VideoPlayBean>("item")
        videoView.setVideoPath(videoPlayBean.url)
        videoView.setOnPreparedListener{
            videoView.start()
        }

    }
}