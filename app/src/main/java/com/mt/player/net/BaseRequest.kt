package com.mt.player.net

import com.google.gson.Gson
import java.lang.reflect.ParameterizedType

/**
 * 所有请求的基类
 */
open class BaseRequest<RESPONSE>(val type: Int, val url: String, val handler: ResponseHandler<RESPONSE>) {
    /**
     * 解析网络请求 body 的结果
     */
    fun pauseResult(result: String?): RESPONSE {
        //获取泛型类型
        val type = (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        return Gson().fromJson<RESPONSE>(result, type)
    }

    /**
     * 发送网络请求
     */
    fun excuse() {
        NetManager.netManager.sendRequest(this)
    }
}