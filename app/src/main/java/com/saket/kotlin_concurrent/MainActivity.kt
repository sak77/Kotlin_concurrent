package com.saket.kotlin_concurrent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import java.util.*
import kotlin.concurrent.schedule
import kotlin.concurrent.thread
import kotlin.concurrent.timer

/**
 * Look at different ways to create threads in kotlin.
 *
 * Focus on kotlin.concurrent package.
 * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.concurrent/
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //simple_thread_1(7)
        //simple_thread_2()
        //simpleThread3()
        simpleTimer()
    }

    //Simple thread
    fun simple_thread_1(count: Int) {
        Thread {
            for (i in 1..count) {
                println("Simple thread counter $i")
                Thread.sleep(1000)
            }
        }.start()
    }

    //Simple thread
    fun simple_thread_2() {
        Thread(Runnable {
            for (i in 1..10) {
                println("Simple thread2 counter $i")
                SystemClock.sleep(1000)
            }
        }).start()
    }

    //function thread
    /*
    fun thread(
    start: Boolean = true,
    isDaemon: Boolean = false,
    contextClassLoader: ClassLoader? = null,
    name: String? = null,
    priority: Int = -1,
    block: () -> Unit
    ): Thread

    The function accepts five parameters:

    start – To run immediately the thread
    isDaemon – if true, the thread is created as a daemon thread. The Java Virtual Machine exits when the only threads running are all daemon threads.
    contextClassLoader – A class loader to use for loading classes and resources
    name – To set the name of the thread
    priority – To set the priority of the thread

    block() is the block of work that the thread executes...
     */
    fun simpleThread3() {
        val mythread = thread(start = false, name = "MyThread", block = {
            println("TESTING thread ${Thread.currentThread().name}")
        })
        //Sleep for 5 secs
        SystemClock.sleep(5000)
        mythread.start()
    }


    /*
     Timer executes the specified action periodically, starting after the specified initialDelay (expressed in milliseconds)
      and with the interval of period milliseconds between the end of the previous task and the
      start of the next one.

      inline fun timer(
        name: String? = null,
        daemon: Boolean = false,
        initialDelay: Long = 0.toLong(),
        period: Long,
        crossinline action: TimerTask.() -> Unit
      ): Timer
     */
    fun simpleTimer() {
        /*timer(name = "MyTimer", initialDelay = 5000, period = 1000, action = {
            println("Alarm time!!")
        })*/

        //java.util.Timer
        /*Timer().schedule(4000){
            println("Alarm time!!")
        }*/
    }
}