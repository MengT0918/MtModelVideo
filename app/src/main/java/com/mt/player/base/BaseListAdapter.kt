package com.mt.player.base

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mt.player.widget.LoadMoreView

/**
 * 所有具有下拉刷新 和上拉加载更多 的 列表界面 的基类
 */
abstract class BaseListAdapter<ITEMBEAN, ITEMVIEW : View> : RecyclerView.Adapter<BaseListAdapter.BaseListHolder>() {
    private var list = ArrayList<ITEMBEAN>()

    class BaseListHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseListHolder {
        return if (viewType == 0) BaseListHolder(getItemView(parent.context))
        else BaseListHolder(LoadMoreView(parent.context))
    }

    override fun getItemCount(): Int {
        return list.size + 1
    }

    override fun onBindViewHolder(holder: BaseListHolder, position: Int) {
        //如果是最后一条 不需要刷新view
        if (position == list.size) return
        val data = list[position]
        val itemView = holder.itemView as ITEMVIEW
        //refreshItemView(itemView, data)

        //设置条目的点击事件
        itemView.setOnClickListener {
            listener?.let {
                it(data)
            }
        }
    }

    private var listener : ((itemBean: ITEMBEAN) -> Unit)? = null

    fun setItemListener(listener: ((itemBean: ITEMBEAN) -> Unit)?) {
        this.listener = listener
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 20) 1 else 0
    }

    abstract fun refreshItemView(itemView: ITEMVIEW, data: ITEMBEAN)

    abstract fun getItemView(context: Context?): ITEMVIEW

    /**
     * 更新数据
     */
    fun updateList(list: List<ITEMBEAN>?) {
        list?.let {
            this.list.clear()
            this.list.addAll(it)
            notifyDataSetChanged()
        }
    }

    /**
     * 加载 更多
     */
    fun loadMore(list: List<ITEMBEAN>?) {
        list?.let {
            this.list.addAll(it)
            notifyDataSetChanged()
        }
    }
}