package com.mt.player.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.mt.player.model.HomeItemBean
import com.mt.player.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_home.view.*

class HomeItemView : RelativeLayout {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        View.inflate(context, R.layout.item_home, this)
    }

    fun setData(data: HomeItemBean) {
        item_title.text = data.title
        item_desc.text = data.description
        //使用Picasso框架 加载服务器上的图片，来设置背景图
        Picasso.get().load(data.posterPic).into(item_bg)
    }
}