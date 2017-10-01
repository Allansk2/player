package com.allan.player.net

import com.allan.player.model.MvPagerBean
import com.allan.player.util.URLProviderUtils

/**
 * Created by Regina on 2017-09-30.
 */
class MvListRequest(code: String, type: Int, offset: Int, handler: ResponseHandler<MvPagerBean>):
        MyRequest<MvPagerBean>(type, URLProviderUtils.getMVListUrl(code, offset, 20), handler) {
}