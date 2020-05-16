package com.mt.player.ui.fragment

import com.mt.player.adapter.MvListAdapter
import com.mt.player.base.*
import com.mt.player.model.MvPagerBean
import com.mt.player.model.VideosBean
import com.mt.player.presenter.impl.MvListPresenterImpl
import com.mt.player.ui.activity.JieCaoVideoPlayerActivity
import com.mt.player.widget.MvListItemView
import org.jetbrains.anko.support.v4.startActivity

class MvListFragment : BaseListFragment<MvPagerBean, VideosBean, MvListItemView>() {
    private var code: String? = null

    override fun init() {
        code = arguments?.getString("args")
    }

    override fun getList(response: MvPagerBean?): List<VideosBean>? {
        return response?.videos
    }

    override fun getSpecialAdapter(): BaseListAdapter<VideosBean, MvListItemView> {
        return MvListAdapter()
    }

    override fun getPresenterImpl(): BaseListPresenter {
        return MvListPresenterImpl(this, code!!)
    }

    override fun initListener() {
        super.initListener()
        adapter.setItemListener {
            startActivity<JieCaoVideoPlayerActivity>()
        }
    }
}