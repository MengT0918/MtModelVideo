package com.mt.player.presenter.impl

import com.mt.player.base.BaseListPresenter
import com.mt.player.base.BaseListView
import com.mt.player.model.MvPagerBean
import com.mt.player.model.VideosBean
import com.mt.player.net.MvListRequest
import com.mt.player.net.ResponseHandler
import com.mt.player.presenter.interf.MvListPresenter

class MvListPresenterImpl(private var mvListView: BaseListView<MvPagerBean>?, private val code: String) :
    MvListPresenter, ResponseHandler<MvPagerBean> {
    //自己添加的假数据
    private val pagerBean: MvPagerBean
    init {
        val videos = ArrayList<VideosBean>()
        (1 .. 20).forEach { videos.add(VideosBean("首页", "简介", "")) }
        pagerBean = MvPagerBean(7, videos)
    }

    override fun loadData() {
        MvListRequest(BaseListPresenter.TYPE_INIT_OR_REFLASH, code, 0, this).excuse()

        //自己添加的假数据
        mvListView?.loadSuccess(pagerBean)
    }

    override fun loadMore(offset: Int) {
        MvListRequest(BaseListPresenter.TYPE_LOAD_MORE, code, offset, this).excuse()

        //自己添加的假数据
        mvListView?.loadMore(pagerBean)
    }

    override fun destoryView() {
        if (mvListView != null) mvListView = null
    }

    override fun onRequestError(msg: String?) {
        mvListView?.onError(msg)
    }

    override fun onRequestSuccess(type: Int, result: MvPagerBean) {
        when(type) {
            BaseListPresenter.TYPE_INIT_OR_REFLASH -> mvListView?.loadSuccess(result)
            BaseListPresenter.TYPE_LOAD_MORE -> mvListView?.loadMore(result)
        }
    }

}