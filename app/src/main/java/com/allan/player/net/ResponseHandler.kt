package com.allan.player.net

/**
 * Created by Regina on 2017-09-30.
 */
interface ResponseHandler<T> {
    fun onError(type: Int, msg: String?)
    fun onSuccess(type: Int, result: T)
}