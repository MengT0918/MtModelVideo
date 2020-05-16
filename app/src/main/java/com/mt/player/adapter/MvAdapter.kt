package com.mt.player.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.mt.player.model.MvAreaBean
import com.mt.player.ui.fragment.MvListFragment

class MvAdapter(private val list: List<MvAreaBean>?, fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        val fragment = MvListFragment()
        val bundle = Bundle()
        bundle.putString("args", list?.get(position)?.code)
        fragment.arguments = bundle
        return fragment
    }

    override fun getCount(): Int {
        //如果不为空 返回list.size；为空 返回0
        return list?.size ?: 0
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return list?.get(position)?.name
    }
}