package com.mt.player.ui.activity

import android.graphics.SurfaceTexture
import android.media.MediaPlayer
import android.view.Surface
import android.view.TextureView
import com.mt.player.R
import com.mt.player.base.BaseActivity
import kotlinx.android.synthetic.main.activity_video_player_texture.*

class TextureVideoPlayerActivity : BaseActivity(), TextureView.SurfaceTextureListener {
    private val mediaPlayer by lazy { MediaPlayer() }

    override fun getLayoutId(): Int {
        return R.layout.activity_video_player_texture
    }

    override fun initData() {
        texture_view.surfaceTextureListener = this
    }

    override fun onSurfaceTextureSizeChanged(p0: SurfaceTexture?, p1: Int, p2: Int) {
        //view 大小发生改变
    }

    override fun onSurfaceTextureUpdated(p0: SurfaceTexture?) {
        //视图更新
    }

    override fun onSurfaceTextureDestroyed(p0: SurfaceTexture?): Boolean {
        //关闭MediaPlayer
        mediaPlayer?.let {
            mediaPlayer.stop()
            mediaPlayer.release()
        }
        //视图销毁
        return true
    }

    override fun onSurfaceTextureAvailable(p0: SurfaceTexture?, p1: Int, p2: Int) {
        //视图可用
        mediaPlayer.setDataSource("URL") //设置视频的URL路径
        mediaPlayer.setSurface(Surface(p0)) //设置播放视频画面的View
        mediaPlayer.prepareAsync()
        mediaPlayer.setOnPreparedListener {
            mediaPlayer.start()
            //旋转画面
            texture_view.rotation = 180F
        }
    }
}