package com.mt.player.net

/**
 * 请求回调
 */
interface ResponseHandler<RESPONSE> {
    fun onRequestError(msg: String?)
    fun onRequestSuccess(type: Int, result: RESPONSE)
}