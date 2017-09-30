package com.allan.player.net

import com.allan.player.model.HomeItemBean
import com.allan.player.util.ThreadUtil
import com.allan.player.util.URLProviderUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.*
import java.io.IOException

/**
 * Created by Regina on 2017-09-30.
 */
class NetworkManager private constructor(){

    val client by lazy { OkHttpClient() }

    companion object {
        val manager by lazy { NetworkManager() }
    }

    fun <T> sendRequest(req: MyRequest<T>) {
        val request = Request.Builder()
                .url(req.url)
                .get()
                .build()
        client.newCall(request).enqueue(object : Callback {
            /**
             * callback not in main thread
             */
            override fun onFailure(call: Call?, e: IOException?) {
                ThreadUtil.runOnMainThread(object :Runnable{
                    override fun run() {
                        req.handler.onError(req.type, e?.message)
                    }
                })
            }
            override fun onResponse(call: Call?, response: Response?) {
                val result = response?.body()?.string()
                val parseResult = req.parseResult(result)
                // update list
                ThreadUtil.runOnMainThread(object :Runnable{
                    override fun run() {
                        req.handler.onSuccess(req.type, parseResult)
                    }
                })

            }
        })
    }


}