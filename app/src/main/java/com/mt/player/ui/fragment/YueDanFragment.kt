package com.mt.player.ui.fragment

import com.mt.player.adapter.YueDanAdapter
import com.mt.player.base.BaseListAdapter
import com.mt.player.base.BaseListFragment
import com.mt.player.base.BaseListPresenter
import com.mt.player.base.BaseListView
import com.mt.player.model.YueDanBean
import com.mt.player.presenter.impl.YueDanPresenterImpl
import com.mt.player.widget.YueDanItemView

class YueDanFragment : BaseListFragment<YueDanBean, YueDanBean.PlayListsBean, YueDanItemView>() {
    override fun getList(response: YueDanBean?): List<YueDanBean.PlayListsBean>? {
        return response?.playLists
    }

    override fun getSpecialAdapter(): BaseListAdapter<YueDanBean.PlayListsBean, YueDanItemView> {
        return YueDanAdapter()
    }

    override fun getPresenterImpl(): BaseListPresenter {
        return YueDanPresenterImpl(this)
    }
}