package com.allan.player.net

import com.allan.player.model.HomeItemBean
import com.allan.player.model.YueDanBean
import com.allan.player.util.URLProviderUtils

/**
 * Created by Regina on 2017-09-30.
 */
class YueDanRequest(type: Int, offset: Int, handler: ResponseHandler<YueDanBean>):
        MyRequest<YueDanBean>(type, URLProviderUtils.getYueDanUrl(offset, 20), handler) {
}