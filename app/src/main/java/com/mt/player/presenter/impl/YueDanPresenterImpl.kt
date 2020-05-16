package com.mt.player.presenter.impl

import com.mt.player.base.BaseListPresenter
import com.mt.player.base.BaseListView
import com.mt.player.model.YueDanBean
import com.mt.player.net.ResponseHandler
import com.mt.player.net.YueDanRequest
import com.mt.player.presenter.interf.YueDanPresenter

class YueDanPresenterImpl(private var yueDanView: BaseListView<YueDanBean>?) : YueDanPresenter,
    ResponseHandler<YueDanBean> {
    //自己添加的假数据
    val itemBean: YueDanBean = YueDanBean()
    init {
        var playLists = ArrayList<YueDanBean.PlayListsBean>()
        (1..20).forEach { playLists.add(YueDanBean.PlayListsBean()) }
        itemBean.playLists = playLists
    }

    override fun loadData() {
        YueDanRequest(BaseListPresenter.TYPE_INIT_OR_REFLASH, 0, this).excuse()

        //自己添加的假数据
        yueDanView?.loadSuccess(itemBean)
    }

    override fun loadMore(offset: Int) {
        YueDanRequest(BaseListPresenter.TYPE_LOAD_MORE, offset, this).excuse()

        //自己添加的假数据
        yueDanView?.loadMore(itemBean)
    }

    override fun destoryView() {
        if (yueDanView != null) yueDanView = null
    }

    override fun onRequestError(msg: String?) {
        yueDanView?.onError(msg)
    }

    override fun onRequestSuccess(type: Int, result: YueDanBean) {
        when(type) {
            BaseListPresenter.TYPE_INIT_OR_REFLASH -> yueDanView?.loadSuccess(result)
            BaseListPresenter.TYPE_LOAD_MORE -> yueDanView?.loadMore(result)
        }
    }
}