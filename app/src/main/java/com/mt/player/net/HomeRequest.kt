package com.mt.player.net

import com.mt.player.model.HomeItemBean
import com.mt.player.utils.URLProviderUtils

/**
 * 首页数据请求类
 */
class HomeRequest(type: Int, offset: Int, handler: ResponseHandler<List<HomeItemBean>>) :
    BaseRequest<List<HomeItemBean>>(type, URLProviderUtils.getHomeUrl(offset, 20), handler) {
}