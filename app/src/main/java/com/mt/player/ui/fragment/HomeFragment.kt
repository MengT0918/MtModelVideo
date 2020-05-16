package com.mt.player.ui.fragment

import com.mt.player.model.HomeItemBean
import com.mt.player.adapter.HomeAdapter
import com.mt.player.base.*
import com.mt.player.presenter.impl.HomePresenterImpl
import com.mt.player.widget.HomeItemView

class HomeFragment : BaseListFragment<List<HomeItemBean>, HomeItemBean, HomeItemView>() {
    override fun getList(response: List<HomeItemBean>?): List<HomeItemBean>? {
        return response
    }

    override fun getSpecialAdapter(): BaseListAdapter<HomeItemBean, HomeItemView> {
        return HomeAdapter()
    }

    override fun getPresenterImpl(): BaseListPresenter {
        return HomePresenterImpl(this)
    }

    /*override fun onDestroyView() {
        super.onDestroyView()
        //解绑presenter
        presenter.destoryView()
    }*/
}