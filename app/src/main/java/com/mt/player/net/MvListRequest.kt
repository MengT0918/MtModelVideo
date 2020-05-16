package com.mt.player.net

import com.mt.player.model.MvPagerBean
import com.mt.player.utils.URLProviderUtils

class MvListRequest(type: Int, code: String, offset: Int, handler: ResponseHandler<MvPagerBean>) :
    BaseRequest<MvPagerBean>(type, URLProviderUtils.getMVListUrl(code, offset, 20), handler) {
}