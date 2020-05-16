package com.mt.player.net

import com.mt.player.model.YueDanBean
import com.mt.player.utils.URLProviderUtils

class YueDanRequest(type: Int, offset: Int, handler: ResponseHandler<YueDanBean>) :
    BaseRequest<YueDanBean>(type, URLProviderUtils.getYueDanUrl(offset, 20), handler) {
}