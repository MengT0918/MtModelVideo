package com.mt.player.adapter

import android.content.Context
import com.mt.player.base.BaseListAdapter
import com.mt.player.model.HomeItemBean
import com.mt.player.widget.HomeItemView

class HomeAdapter : BaseListAdapter<HomeItemBean, HomeItemView>() {
    override fun refreshItemView(itemView: HomeItemView, data: HomeItemBean) {
        itemView.setData(data)
    }

    override fun getItemView(context: Context?): HomeItemView {
        return HomeItemView(context)
    }
}