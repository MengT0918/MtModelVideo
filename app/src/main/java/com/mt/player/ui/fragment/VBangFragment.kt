package com.mt.player.ui.fragment

import android.provider.MediaStore
import android.util.Log
import android.view.View
import com.mt.player.R
import com.mt.player.base.BaseFragment
import com.mt.player.utils.CursorUtil

class VBangFragment : BaseFragment() {
    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_vbang, null)
    }

    override fun initData() {
        //加载音乐列表数据
        Log.e("mengteng", "initData context = $context")
        context?.let {
            val resolver = it.contentResolver
            Log.e("mengteng", "initData resolver = $resolver")
            val cursor = resolver.query(MediaStore.Audio.Media.INTERNAL_CONTENT_URI,
                arrayOf(
                    MediaStore.Audio.Media.DATA,
                    MediaStore.Audio.Media.SIZE,
                    MediaStore.Audio.Media.DISPLAY_NAME,
                    MediaStore.Audio.Media.ARTIST
                ), null, null, null)
            Log.e("mengteng", "initData cursor = $cursor")
            CursorUtil.logCursor(cursor)
        }
    }
}