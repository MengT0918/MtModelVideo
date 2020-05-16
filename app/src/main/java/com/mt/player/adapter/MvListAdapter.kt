package com.mt.player.adapter

import android.content.Context
import com.mt.player.base.BaseListAdapter
import com.mt.player.model.VideosBean
import com.mt.player.widget.MvListItemView

class MvListAdapter : BaseListAdapter<VideosBean, MvListItemView>() {
    override fun refreshItemView(itemView: MvListItemView, data: VideosBean) {
        itemView.setData(data)
    }

    override fun getItemView(context: Context?): MvListItemView {
        return MvListItemView(context)
    }
}