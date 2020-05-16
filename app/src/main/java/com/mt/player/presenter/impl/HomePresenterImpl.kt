package com.mt.player.presenter.impl

import com.mt.player.base.BaseListPresenter
import com.mt.player.base.BaseListView
import com.mt.player.model.HomeItemBean
import com.mt.player.net.HomeRequest
import com.mt.player.net.ResponseHandler
import com.mt.player.presenter.interf.HomePresenter

class HomePresenterImpl(private var homeView: BaseListView<List<HomeItemBean>>?) :
    HomePresenter, ResponseHandler<List<HomeItemBean>> {

    //自己添加的假数据
    val list = ArrayList<HomeItemBean>()
    init {
        (1 ..20).forEach{ list.add(HomeItemBean("首页", "简介", "", "")) }
    }

    /**
     * 初始化数据 或者 刷新数据
     */
    override fun loadData() {
        HomeRequest(BaseListPresenter.TYPE_INIT_OR_REFLASH, 0, this).excuse()

        //自己添加的假数据
        homeView?.loadSuccess(list)
    }

    /**
     * 加载 更多数据
     */
    override fun loadMore(offset: Int) {
        HomeRequest(BaseListPresenter.TYPE_LOAD_MORE, offset, this).excuse()

        //自己添加的假数据
        homeView?.loadMore(list)
    }

    override fun onRequestError(msg: String?) {
        homeView?.onError(msg)
    }

    override fun onRequestSuccess(type: Int, result: List<HomeItemBean>) {
        when(type) {
            BaseListPresenter.TYPE_INIT_OR_REFLASH -> homeView?.loadSuccess(result)
            BaseListPresenter.TYPE_LOAD_MORE -> homeView?.loadMore(result)
        }
    }

    /**
     * 解绑 View层 和 Presenter层 的操作
     */
    override fun destoryView() {
        if(homeView != null){
            homeView = null
        }
    }
}