package com.allan.player.ui.activity

import android.support.v4.view.ViewPager
import com.allan.player.R
import com.allan.player.base.BaseActivity
import com.allan.player.model.VideoPlayBean
import cn.jzvd.JZVideoPlayerStandard
import kotlinx.android.synthetic.main.activity_video_player_jiecao.*
import cn.jzvd.JZVideoPlayer
import com.allan.player.adapter.VideoPagerAdapter


/**
 * Created by Regina on 2017-10-01.
 */
class JiecaoVideoPlayerActivity : BaseActivity() {


    override fun getLayoutId(): Int {
        return R.layout.activity_video_player_jiecao

    }

    override fun initData() {
        // get data
        val data = intent.data
        if (data == null) {
            // data pass from application
            var videoPlayBean = intent.getParcelableExtra<VideoPlayBean>("item")
            videoplayer.setUp(videoPlayBean.url, JZVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, videoPlayBean.title)

        }else {
            // data pass from outside
            if (data.toString().startsWith("http")){
                // from internet
                videoplayer.setUp(data.toString(), JZVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, data.toString())
            }else {
                // from local storage
                videoplayer.setUp(data.path, JZVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, data.path)
            }

        }

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

    override fun initListner() {
        // set viewpager adapter
        viewPager.adapter = VideoPagerAdapter(supportFragmentManager)
        // set radio group listner
        rg.setOnCheckedChangeListener { radioGroup, i ->
            when(i) {
                R.id.rb1 -> viewPager.setCurrentItem(0)
                R.id.rb2 -> viewPager.setCurrentItem(1)
                R.id.rb3 -> viewPager.setCurrentItem(2)

            }
        }

        // set viewpager change listner
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{

            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                when(position) {
                    0 -> rg.check(R.id.rb1)
                    1 -> rg.check(R.id.rb2)
                    2 -> rg.check(R.id.rb3)

                }
            }
        })

    }

}