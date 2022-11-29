package com.example.wetherapp.network

interface OnApiResultCallBack<T> {

    fun onSuccess(response: T)

    fun onFail(exception: java.lang.Exception, code: Int)

}
