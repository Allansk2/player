package com.allan.player.model

/**
 * Created by Regina on 2017-09-30.
 */

/**
 * ClassName:HomeItemBean
 * Description: bean item for home fragment
 */
data class HomeItemBean(var type: String, var id: Int,
                        var title: String, var description: String?,
                        var posterPic: String?,var thumbnailPic: String?,
                        var url: String?, var hdUrl: String?,var videoSize: Int,
                        var hdVideoSize: Int,var uhdVideoSize: Int,var status: Int,
                        var traceUrl: String?,var clickUrl: String?,var uhdUrl: String?)

