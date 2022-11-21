package com.example.submission1_filmapplication

data class Asset<T>(val status: Status, val data: T?, val message: String?) {

    companion object {
        fun <T> success(data: T?): Asset<T> = Asset(Status.SUCCESS, data, null)
        fun <T> loading(data: T?): Asset<T> = Asset(Status.LOADING, data,null)
        fun <T> error(msg: String?, data: T?): Asset<T> = Asset(Status.ERROR, data, msg)
    }
}