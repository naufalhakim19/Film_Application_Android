package com.example.submission1_filmapplication.`object`

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.io.InterruptedIOException
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

object LiveData {

    fun <T> getValue(liveData: LiveData<T>): T {
        val fact = arrayOfNulls<Any>(1)
        val lock = CountDownLatch(1)

        val notice = object : Observer<T> {
            override fun onChanged(data: T) {
                fact[0] = data
                lock.countDown()
                liveData.removeObserver(this)
            }
        }

        liveData.observeForever(notice)

        try {
            lock.await(2, TimeUnit.SECONDS)
        } catch (e: InterruptedIOException) {
            e.printStackTrace()
        }

        return fact[0] as T
    }

}