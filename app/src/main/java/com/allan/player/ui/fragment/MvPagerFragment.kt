package com.allan.player.ui.fragment

import android.graphics.Color
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.allan.player.adapter.MvListAdapter
import com.allan.player.base.BaseListAdapter
import com.allan.player.base.BaseListFragment
import com.allan.player.base.BaseListPresenter
import com.allan.player.model.MvPagerBean
import com.allan.player.model.VideoPlayBean
import com.allan.player.model.VideosBean
import com.allan.player.presenter.impl.MvListPresenterImpl
import com.allan.player.ui.activity.*
import com.allan.player.view.MvListView
import com.allan.player.widget.MvItemView
import org.jetbrains.anko.support.v4.startActivity

/**
 * Created by Regina on 2017-09-30.
 */
class MvPagerFragment: BaseListFragment<MvPagerBean, VideosBean, MvItemView>(), MvListView {

    var name: String? = null
    var code: String? = null

    override fun init() {
        // get data
        name = arguments.getString("name")
        code = arguments.getString("code")

    }

    override fun getList(response: MvPagerBean?): List<VideosBean>? {
        return response?.videos
    }

    override fun getMyAdapter(): BaseListAdapter<VideosBean, MvItemView> {
        return MvListAdapter()
    }

    override fun getMyPresenter(): BaseListPresenter {
        return MvListPresenterImpl(code!!, this)
    }

    override fun initListner() {
        super.initListner()
        // set item onclick listner
        adapter.setMyListner {
            val videoPlayBean = VideoPlayBean(it.id, it.title, it.url)
            startActivity<JiecaoVideoPlayerActivity>("item" to videoPlayBean)
        }
    }

}