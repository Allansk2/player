package com.allan.player.net

import com.allan.player.model.HomeItemBean
import com.allan.player.model.MvAreaBean
import com.allan.player.util.URLProviderUtils

/**
 * Created by Regina on 2017-09-30.
 */
class MvAreaRequest(handler: ResponseHandler<List<MvAreaBean>>):
        MyRequest<List<MvAreaBean>>(0, URLProviderUtils.getMVareaUrl(), handler) {
}