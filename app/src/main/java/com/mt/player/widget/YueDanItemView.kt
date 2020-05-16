package com.mt.player.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.mt.player.R
import com.mt.player.model.YueDanBean
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import kotlinx.android.synthetic.main.item_yuedan.view.*

class YueDanItemView : RelativeLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        View.inflate(context, R.layout.item_yuedan, this)
    }

    fun setData(data: YueDanBean.PlayListsBean) {
        //歌单名称
        item_title.text = data.title
        //创建者
        item_name.text = data.creator?.nickName
        //歌曲个数
        item_count.text = data.videoCount.toString()
        //背景
        Picasso.get().load(data.playListBigPic).into(item_bg)
        //创建者头像--设置成圆形显示（transform(CropCircleTransformation())）
        Picasso.get().load(data.creator?.largeAvatar).transform(CropCircleTransformation()).into(item_icon)
    }
}