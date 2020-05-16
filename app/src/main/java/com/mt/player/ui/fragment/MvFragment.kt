package com.mt.player.ui.fragment

import android.view.View
import com.mt.player.model.MvAreaBean
import com.mt.player.R
import com.mt.player.adapter.MvAdapter
import com.mt.player.base.BaseFragment
import com.mt.player.presenter.impl.MvPresenterImpl
import com.mt.player.view.MvView
import kotlinx.android.synthetic.main.fragment_lsit.*
import kotlinx.android.synthetic.main.fragment_mv.*

class MvFragment : BaseFragment(), MvView {
    private var areaList = ArrayList<MvAreaBean>()

    override fun init() {
        with(areaList) {
            add(MvAreaBean("首播", "ML"))
            add(MvAreaBean("韩国", "KR"))
            add(MvAreaBean("欧美", "HT"))
            add(MvAreaBean("日本", "JP"))
            add(MvAreaBean("内地", "ML"))
            add(MvAreaBean("港台", "HT"))
            add(MvAreaBean("热推", ""))
        }
    }

    private val presenter by lazy { MvPresenterImpl(this) }

    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_mv, null)
    }

    override fun initData() {
        //加载区域块数据
        presenter.loadDatas()

        //自己写的假数据代码
        val adapter = MvAdapter(areaList, childFragmentManager)
        mv_vp.adapter = adapter
        mv_tab.setupWithViewPager(mv_vp)
    }

    override fun onError(msg: String?) {
        refreshLayout.isRefreshing = false
    }

    override fun onSuccess(result: List<MvAreaBean>) {
        refreshLayout.isRefreshing = false
        //在Fragment中管理Fragment需要childFragmentManager
        val adapter = MvAdapter(result, childFragmentManager)
        mv_vp.adapter = adapter
        mv_tab.setupWithViewPager(mv_vp)
    }
}