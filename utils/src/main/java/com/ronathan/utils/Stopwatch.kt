package com.ronathan.utils

class Stopwatch {

    private var startTime: Long = 0
    private var pauseTime: Long = 0
    private var stopTime: Long = 0
    private var running = false

    // returns elapsed time in seconds
    val elapsedTime: Long
        get() {
            return if (running) {
                (System.currentTimeMillis() - startTime - pauseTime / 1000)
            } else {
                (stopTime - startTime - pauseTime) / 1000
            }
        }

    fun start() {
        startTime = System.currentTimeMillis()
        running = true
    }

    fun stop() {
        stopTime = System.currentTimeMillis()
        running = false
    }

    fun pause() {
        pauseTime = System.currentTimeMillis()
        running = false
    }
}