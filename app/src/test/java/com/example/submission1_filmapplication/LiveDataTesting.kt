package com.example.submission1_filmapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

object LiveDataTesting {

    fun<X> getValue(liveData: LiveData<X>) : X {

        val datas = arrayOfNulls<Any>(1)
        val catch = CountDownLatch(1)

        val observasi = object : Observer<X> {
            override fun onChanged(t: X) {
                datas[0] = t
                catch.countDown()
                liveData.removeObserver(this)
            }
        }

        liveData.observeForever(observasi)

        try {
            catch.await(2, TimeUnit.SECONDS)
        } catch (e: InterruptedException){
            e.printStackTrace()
        }

        return datas[0] as X

    }

}