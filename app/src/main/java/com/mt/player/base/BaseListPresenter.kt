package com.mt.player.base

/**
 * 所有具有下拉刷新 和上拉加载更多 的 列表界面 的基类
 */
interface BaseListPresenter {
    companion object {
        val TYPE_INIT_OR_REFLASH = 1
        val TYPE_LOAD_MORE = 2
    }

    fun loadData()
    fun loadMore(offset: Int)
    //解绑 Presenter层 和 View层
    fun destoryView()
}