package com.mt.player.view

import com.mt.player.model.MvAreaBean

interface MvView {
    fun onError(msg: String?)
    fun onSuccess(result: List<MvAreaBean>)
}