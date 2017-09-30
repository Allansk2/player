package com.allan.player.net

import com.allan.player.model.HomeItemBean
import com.allan.player.util.URLProviderUtils

/**
 * Created by Regina on 2017-09-30.
 */
class HomeRequest(type: Int, offset: Int, handler: ResponseHandler<List<HomeItemBean>>):
        MyRequest<List<HomeItemBean>>(type, URLProviderUtils.getHomeUrl(offset, 20), handler) {
}