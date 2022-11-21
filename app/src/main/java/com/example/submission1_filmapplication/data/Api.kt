package com.example.submission1_filmapplication.data

class Api<T>(val status: StatusInfo, val body: T, val message: String?) {

    companion object {
        fun <T> success(body: T): Api<T> = Api(StatusInfo.SUCCESS, body, null)
        fun <T> error(msg: String, body: T): Api<T> = Api(StatusInfo.ERROR, body, msg)
    }
}
