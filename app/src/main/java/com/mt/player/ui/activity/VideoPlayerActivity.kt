package com.mt.player.ui.activity

import com.mt.player.R
import com.mt.player.base.BaseActivity
import kotlinx.android.synthetic.main.activity_video_player.*

class VideoPlayerActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_video_player
    }

    override fun initData() {
        //播放对应URL的视频
        //video_view.setVideoPath("URL") //异步准备，把视频加载到内存中
        //video_view.start() //现在播放，可能视频还没有加载好
        /*video_view.setOnPreparedListener {
            video_view.start()
        }*/
    }
}