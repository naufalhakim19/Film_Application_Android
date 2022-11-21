package com.example.submission1_filmapplication

import android.os.Handler
import android.os.Looper
import androidx.annotation.VisibleForTesting
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class Deputy @VisibleForTesting constructor(
    private val diskIO: Executor,
    private val networkIO :Executor,
    private val mainThread: Executor
) {
    companion object {
        private const val COUNTING_THREADS = 3
    }

    constructor(): this(
        Executors.newSingleThreadExecutor(),
        Executors.newFixedThreadPool(COUNTING_THREADS),
        MainThreadDeputy()
    )

    fun diskIO(): Executor = diskIO
    fun mainThread(): Executor = mainThread

    private class MainThreadDeputy : Executor {
        private val mainThreadTutor = Handler(Looper.getMainLooper())
        override fun execute(command: Runnable) {
            mainThreadTutor.post(command)
        }
    }
}


