package com.mt.player.net

import com.mt.player.model.MvAreaBean
import com.mt.player.utils.URLProviderUtils

class MvRequest(handler: ResponseHandler<List<MvAreaBean>>) :
    BaseRequest<List<MvAreaBean>>(0, URLProviderUtils.getMVareaUrl(), handler) {
}