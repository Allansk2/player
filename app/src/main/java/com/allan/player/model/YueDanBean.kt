package com.allan.player.model

/**
 * Created by Regina on 2017-09-30.
 */
class YueDanBean {
    var totalCount: Int = 0
    var playLists: List<PlayListsBean>? = null

    class PlayListsBean {
        /**
         * id : 1291371
         * title : 欧美女声 一遍就能征服你
         * thumbnailPic : http://img0.yytcdn.com/video/mv/160123/0/-M-74eb5fb2a529d279b0261696ec088646_240x135.jpg?ts=1453480751
         * playListPic : http://img3.c.yinyuetai.com/video/playlist/160902/0/-M-d46f7cabafe37ef868c52128d23a1ecd_110x110.jpg
         * playListBigPic : http://img3.c.yinyuetai.com/video/playlist/160902/0/-M-d46f7cabafe37ef868c52128d23a1ecd_600x600.jpg
         * videoCount : 53
         * description : 精心挑选,品质选择,送上优质欧美女声,一遍就能征服你。
         * category :
         * creator : {"uid":16353282,"nickName":"菊苑逸馨","smallAvatar":"http://img2.c.yinyuetai.com/user/avatar/150902/16353282-1441148922957/-M-114535e68bd5e57a6afea61a2bdc5e6b_50x50.jpg","largeAvatar":"http://img2.c.yinyuetai.com/user/avatar/150902/16353282-1441148922957/-M-114535e68bd5e57a6afea61a2bdc5e6b_100x100.jpg","vipLevel":0}
         * status : 0
         * totalViews : 120745
         * totalFavorites : 1549
         * updateTime : 2016-09-02 13:25
         * createdTime : 2013-06-09 19:57
         * integral : 2178
         * weekIntegral : 0
         * totalUser : 0
         * rank : 0
         */

        var id: Int = 0
        var title: String? = null
        var thumbnailPic: String? = null
        var playListPic: String? = null
        var playListBigPic: String? = null
        var videoCount: Int = 0
        var description: String? = null
        var category: String? = null
        var creator: CreatorBean? = null
        var status: Int = 0
        var totalViews: Int = 0
        var totalFavorites: Int = 0
        var updateTime: String? = null
        var createdTime: String? = null
        var integral: Int = 0
        var weekIntegral: Int = 0
        var totalUser: Int = 0
        var rank: Int = 0

        class CreatorBean {
            /**
             * uid : 16353282
             * nickName : 菊苑逸馨
             * smallAvatar : http://img2.c.yinyuetai.com/user/avatar/150902/16353282-1441148922957/-M-114535e68bd5e57a6afea61a2bdc5e6b_50x50.jpg
             * largeAvatar : http://img2.c.yinyuetai.com/user/avatar/150902/16353282-1441148922957/-M-114535e68bd5e57a6afea61a2bdc5e6b_100x100.jpg
             * vipLevel : 0
             */

            var uid: Int = 0
            var nickName: String? = null
            var smallAvatar: String? = null
            var largeAvatar: String? = null
            var vipLevel: Int = 0
        }
    }

}