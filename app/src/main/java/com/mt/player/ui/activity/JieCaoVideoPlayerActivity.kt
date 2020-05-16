package com.mt.player.ui.activity

import android.util.Log
import androidx.viewpager.widget.ViewPager
import com.mt.player.R
import com.mt.player.adapter.VideoPageAdapter
import com.mt.player.base.BaseActivity
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard
import kotlinx.android.synthetic.main.activity_video_player_jiecao.*


class JieCaoVideoPlayerActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_video_player_jiecao
    }

    override fun initData() {
        //响应外部应用视频播放请求
        val data = intent.data
        Log.e("mengteng","initData data = $data")
        if (data == null) {
            //从应用内响应
            //播放对应URL的视频
            videoPlayer.setUp("http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4",
                JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"视频标题");
        } else {
            //从应用外响应
            Log.e("mengteng","initData data = ${data.path}")
            videoPlayer.setUp(data.path,
                JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, data.path)
        }

    }

    override fun onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return
        }
        super.onBackPressed()
    }

    override fun onPause() {
        super.onPause()
        JCVideoPlayer.releaseAllVideos()
    }

    override fun initListener() {
        view_page.adapter = VideoPageAdapter(supportFragmentManager)

        rg.setOnCheckedChangeListener { radioGroup, i ->
            when(i) {
                R.id.rg1 -> view_page.currentItem = 0
                R.id.rg2 -> view_page.currentItem = 1
                R.id.rg3 -> view_page.currentItem = 2
            }
        }

        view_page.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            /**
             * 滑动状态改变的回调
             */
            override fun onPageScrollStateChanged(state: Int) {
            }

            /**
             * 滑动回调
             */
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            /**
             * 选中状态改变回调
             */
            override fun onPageSelected(position: Int) {
                when(position) {
                    0 -> rg.check(R.id.rg1)
                    1 -> rg.check(R.id.rg2)
                    2 -> rg.check(R.id.rg3)
                }
            }
        })
    }
}