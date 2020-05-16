package com.mt.player.base

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mt.player.R
import kotlinx.android.synthetic.main.fragment_lsit.*

/**
 * 所有具有下拉刷新 和上拉加载更多 的 列表界面 的基类
 */
abstract class BaseListFragment<RESPONSE, ITEMBEAN, ITEMVIEW: View> : BaseFragment(), BaseListView<RESPONSE> {
    //适配
    val adapter by lazy { getSpecialAdapter() }

    val presenter by lazy { getPresenterImpl() }

    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_lsit, null)
    }

    override fun initListener() {
        //初始化RecyclerView
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.adapter = adapter

        //初始化 刷新控件
        refreshLayout.setColorSchemeColors(Color.RED, Color.YELLOW, Color.GREEN)
        //下拉刷新 监听
        refreshLayout.setOnRefreshListener {
            presenter.loadData()
        }

        recycler_view.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    //最后一条是否已经显示
                    val layoutManager = recyclerView.layoutManager
                    if (layoutManager is LinearLayoutManager) {
                        val manager: LinearLayoutManager = layoutManager
                        val lastPosition = manager.findLastVisibleItemPosition()
                        if (lastPosition == adapter.itemCount - 1) {
                            //最后一条item
                            presenter.loadMore(lastPosition)
                        }
                    }
                }
            }
        })
    }

    override fun initData() {
        presenter.loadData()
    }

    override fun onError(msg: String?) {
        refreshLayout.isRefreshing = false
    }

    override fun loadSuccess(response: RESPONSE?) {
        refreshLayout.isRefreshing = false
        adapter.updateList(getList(response))
    }

    override fun loadMore(response: RESPONSE?) {
        adapter.loadMore(getList(response))
    }

    abstract fun getList(response: RESPONSE?): List<ITEMBEAN>?

    abstract fun getSpecialAdapter(): BaseListAdapter<ITEMBEAN, ITEMVIEW>

    abstract fun getPresenterImpl(): BaseListPresenter
}