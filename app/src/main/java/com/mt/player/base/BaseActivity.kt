package com.mt.player.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * 所有Activity的基类
 */
abstract class BaseActivity : AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initListener()
        initData()
    }

    /**
     * 初始化数据
     */
    open protected fun initData() {
    }

    /**
     * adapter listener相关操作
     */
    open protected fun initListener() {
    }

    /**
     * 布局ID
     */
    abstract fun getLayoutId(): Int

    open protected fun baseToast(msg: String) {
        runOnUiThread { toast(msg) }
    }

    /**
     * 开启一个Activity，并且finish当前界面
     */
    protected inline fun <reified T:BaseActivity>startActivityAndFinish() {
        startActivity<T>()
        finish()
    }
}