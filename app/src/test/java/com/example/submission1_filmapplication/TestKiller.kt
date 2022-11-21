package com.example.submission1_filmapplication

import java.util.concurrent.Executor

class TestKiller: Executor {
    override fun execute(command: Runnable) {
        command.run()
    }
}