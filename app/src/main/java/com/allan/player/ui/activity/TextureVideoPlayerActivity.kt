package com.allan.player.ui.activity

import android.graphics.SurfaceTexture
import android.media.MediaPlayer
import android.view.Surface
import android.view.TextureView
import com.allan.player.R
import com.allan.player.base.BaseActivity
import com.allan.player.model.VideoPlayBean
import kotlinx.android.synthetic.main.activity_video_player_texture.*

/**
 * Created by Regina on 2017-10-01.
 */
class TextureVideoPlayerActivity : BaseActivity(), TextureView.SurfaceTextureListener {

    var videoPlayBean: VideoPlayBean? = null
    val mediaPlayer by lazy { MediaPlayer() }

    override fun getLayoutId(): Int {
        return R.layout.activity_video_player_texture
    }

    override fun initData() {
        // get data
        videoPlayBean = intent.getParcelableExtra<VideoPlayBean>("item")
        textureView.surfaceTextureListener = this

    }

    override fun onSurfaceTextureSizeChanged(p0: SurfaceTexture?, p1: Int, p2: Int) {

    }

    override fun onSurfaceTextureUpdated(p0: SurfaceTexture?) {

    }

    override fun onSurfaceTextureDestroyed(p0: SurfaceTexture?): Boolean {
        mediaPlayer.let {
            mediaPlayer.stop()
            mediaPlayer.release()
        }
        return true
    }

    override fun onSurfaceTextureAvailable(p0: SurfaceTexture?, p1: Int, p2: Int) {
        videoPlayBean?.let {

            mediaPlayer.setDataSource(it.url)
            mediaPlayer.setSurface(Surface(p0))
            mediaPlayer.prepareAsync()
            mediaPlayer.setOnPreparedListener{
                mediaPlayer.start()
                textureView.rotation = 90f
            }
        }

    }

}