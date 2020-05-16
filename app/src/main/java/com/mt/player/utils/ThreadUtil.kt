package com.mt.player.utils

import android.os.Handler
import android.os.Looper

object ThreadUtil {
    private val mHandler = Handler(Looper.getMainLooper())

    fun runOnMainThread(runnable: Runnable) {
        mHandler.post(runnable)
    }
}