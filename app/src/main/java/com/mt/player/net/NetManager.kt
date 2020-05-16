package com.mt.player.net

import android.util.Log
import com.mt.player.utils.ThreadUtil
import okhttp3.*
import java.io.IOException

/**
 * 发送网络请求的类
 */
class NetManager private constructor(){
    private val mClient by lazy { OkHttpClient() }

    companion object {
        val netManager by lazy { NetManager() }
    }

    /**
     * 发送网络请求
     */
    fun <RESPONSE>sendRequest(rqt: BaseRequest<RESPONSE>) {
        val request = Request.Builder()
            .url(rqt.url)
            .get()
            .build()
        mClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                ThreadUtil.runOnMainThread(Runnable {
                   rqt.handler.onRequestError(e.message)
                })
            }

            override fun onResponse(call: Call, response: Response) {
                val result = response.body?.string()
                val pauseResult = rqt.pauseResult(result)
                ThreadUtil.runOnMainThread(Runnable {
                    rqt.handler.onRequestSuccess(rqt.type, pauseResult)
                })
            }
        })
    }
}