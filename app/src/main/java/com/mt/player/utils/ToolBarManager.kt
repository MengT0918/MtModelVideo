package com.mt.player.utils

import androidx.appcompat.widget.Toolbar
import com.mt.player.R
import com.mt.player.ui.activity.SettingActivity
import org.jetbrains.anko.startActivity

/**
 * 所有界面ToolBar的管理类
 */
interface ToolBarManager {
    val toolBar: Toolbar

    /**
     * 管理主界面的ToolBar
     */
    fun initMainToolBar() {
        toolBar.title = "手机影音"
        //ToolBar右边显示设置按钮
        toolBar.inflateMenu(R.menu.main)
        //给设置按钮设置点击事件
        //设置Java接口中只有一个未实现的方法，可以是有lambda表达式
        toolBar.setOnMenuItemClickListener {
            toolBar.context.startActivity<SettingActivity>()
            true
        }
    }

    /**
     * 管理设置界面的ToolBar
     */
    fun initSettingToolBar() {
        toolBar.title = "设置"
    }
}