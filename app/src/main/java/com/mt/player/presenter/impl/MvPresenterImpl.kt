package com.mt.player.presenter.impl

import com.mt.player.model.MvAreaBean
import com.mt.player.net.MvRequest
import com.mt.player.net.ResponseHandler
import com.mt.player.presenter.interf.MvPresenter
import com.mt.player.view.MvView

class MvPresenterImpl(private var mvView: MvView) : MvPresenter, ResponseHandler<List<MvAreaBean>> {
    override fun loadDatas() {
        MvRequest(this).excuse()
    }

    override fun onRequestError(msg: String?) {
        mvView.onError(msg)
    }

    override fun onRequestSuccess(type: Int, result: List<MvAreaBean>) {
        mvView.onSuccess(result)
    }

}