package com.mt.player.base

/**
 * 所有具有下拉刷新 和上拉加载更多 的 列表界面 的基类
 */
interface BaseListView<RESPONSE> {
    /**
     * 获取数据失败
     */
    fun onError(msg: String?)
    /**
     * 初始化数据 或者 刷新数据成功
     */
    fun loadSuccess(response: RESPONSE?)

    /**
     * 加载更多数据
     */
    fun loadMore(response: RESPONSE?)
}