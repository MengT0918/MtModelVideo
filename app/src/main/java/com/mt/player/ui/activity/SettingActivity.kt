package com.mt.player.ui.activity

import android.preference.PreferenceManager
import androidx.appcompat.widget.Toolbar
import com.mt.player.R
import com.mt.player.base.BaseActivity
import com.mt.player.utils.ToolBarManager
import org.jetbrains.anko.find

class SettingActivity : BaseActivity(), ToolBarManager {

    override fun getLayoutId(): Int {
        return R.layout.activity_setting
    }

    override val toolBar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun initData() {
        initSettingToolBar()
        //获取Fragment中SwitchPreference开关状态的值
        val sp = PreferenceManager.getDefaultSharedPreferences(this)
        val push = sp.getBoolean("push", false)
    }
}