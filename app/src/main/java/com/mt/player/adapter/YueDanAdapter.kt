package com.mt.player.adapter

import android.content.Context
import com.mt.player.base.BaseListAdapter
import com.mt.player.model.YueDanBean
import com.mt.player.widget.YueDanItemView

class YueDanAdapter : BaseListAdapter<YueDanBean.PlayListsBean, YueDanItemView>() {
    override fun refreshItemView(itemView: YueDanItemView, data: YueDanBean.PlayListsBean) {
        //itemView.setData(data)
    }

    override fun getItemView(context: Context?): YueDanItemView {
        return YueDanItemView(context)
    }
}