package com.mt.player.utils

import com.mt.player.R
import com.mt.player.base.BaseFragment
import com.mt.player.ui.fragment.HomeFragment
import com.mt.player.ui.fragment.MvFragment
import com.mt.player.ui.fragment.VBangFragment
import com.mt.player.ui.fragment.YueDanFragment

/**
 * 管理Fragment的util类 单例的另一种创建方式
 */
class FragmentUtil private constructor() {
    private val homeFragment by lazy { HomeFragment() }
    private val mvFragment by lazy { MvFragment() }
    private val vBangFragment by lazy { VBangFragment() }
    private val yueDanFragment by lazy { YueDanFragment() }

    companion object {
        val fragmentUtil by lazy { FragmentUtil() }
    }

    /**
     * 根据tabId获取对应的Fragment
     */
    fun getFragment(tabId: Int): BaseFragment? {
        when(tabId) {
            R.id.tab_home -> return homeFragment
            R.id.tab_mv -> return mvFragment
            R.id.tab_vBang -> return vBangFragment
            R.id.tab_yueDan -> return yueDanFragment
        }
        return null
    }
}