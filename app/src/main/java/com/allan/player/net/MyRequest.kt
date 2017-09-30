package com.allan.player.net

import com.google.gson.Gson
import java.lang.reflect.ParameterizedType

/**
 * Created by Regina on 2017-09-30.
 */
open class MyRequest <T> (val type: Int, val url: String, val handler: ResponseHandler<T>){

    /**
     * parse response
     */
    fun parseResult(result: String?): T {
        val gson = Gson()
        val type = (this.javaClass
                .genericSuperclass as ParameterizedType).getActualTypeArguments()[0]
        val list = gson.fromJson<T>(result, type)
        return list
    }

    fun execute(){
        NetworkManager.manager.sendRequest(this)
    }
}