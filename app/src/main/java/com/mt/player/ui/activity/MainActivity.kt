package com.mt.player.ui.activity

import androidx.appcompat.widget.Toolbar
import com.mt.player.R
import com.mt.player.base.BaseActivity
import com.mt.player.utils.FragmentUtil
import com.mt.player.utils.ToolBarManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.find

class MainActivity : BaseActivity(), ToolBarManager {
    private val mBottomBar by lazy { bottomBar }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override val toolBar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun initData() {
        initMainToolBar()
    }

    override fun initListener() {
        mBottomBar.setOnTabSelectListener {
            val transaction = supportFragmentManager.beginTransaction()
            val fragment = FragmentUtil.fragmentUtil.getFragment(it)
            fragment?.let {
                transaction.replace(R.id.container, fragment)
                transaction.commit()
            }
        }
    }
}