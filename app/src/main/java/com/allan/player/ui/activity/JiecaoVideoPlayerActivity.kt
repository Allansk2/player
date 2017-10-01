package com.allan.player.ui.activity

import com.allan.player.R
import com.allan.player.base.BaseActivity
import com.allan.player.model.VideoPlayBean
import cn.jzvd.JZVideoPlayerStandard
import kotlinx.android.synthetic.main.activity_video_player_jiecao.*
import cn.jzvd.JZVideoPlayer




/**
 * Created by Regina on 2017-10-01.
 */
class JiecaoVideoPlayerActivity : BaseActivity() {


    override fun getLayoutId(): Int {
        return R.layout.activity_video_player_jiecao

    }

    override fun initData() {
        // get data
        var videoPlayBean = intent.getParcelableExtra<VideoPlayBean>("item")
        videoplayer.setUp(videoPlayBean.url, JZVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, videoPlayBean.title)

    }

    override fun onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return
        }
        super.onBackPressed()
    }

    override fun onPause() {
        super.onPause()
        JZVideoPlayer.releaseAllVideos()
    }



}