package com.alirahimi.androidcourse

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.alirahimi.androidcourse.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {

    //TODO 1. Global Scope
    //TODO 2. Thread vs Coroutines
    //TODO 3. Run Blocking
    //TODO 4. viewModel Scope
    //TODO 5. Job
    //TODO 6. Async and Await

    //region properties
    private lateinit var binding: ActivityMainBinding
    //endregion

    //region lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialBinding()
        //globalScope()
        //threadVsCoroutines()
        //seeRunBlocking()
        //seeJob()
        seeAsyncAndAwait()
    }

    private fun seeAsyncAndAwait() {

        GlobalScope.launch {


            val time = measureTimeMillis {
                val a = async { callApi1() }
                val b = async { callApi2() }
                Log.e("2323", "time: ${a.await() + b.await()}")

            }

            Log.e("2323", "time: $time")

        }


    }

    private suspend fun callApi1(): Int {
        delay(3000)
        return 3
    }

    private suspend fun callApi2(): Int {
        delay(5000)
        return 5
    }

    private fun seeJob() {
        val job = GlobalScope.launch {
            Log.e("2323", "start job")
        }

        suspend {
            job.join()
        }


    }

    private fun seeRunBlocking() {
        Log.e("2323", "start app")
        runBlocking {
            launch { Log.e("2323", "in app 1") }
            launch { Log.e("2323", "in app 2") }
            launch { Log.e("2323", "in app 3") }
            launch { Log.e("2323", "in app 4") }
        }
        Log.e("2323", "end app")
    }

    private fun threadVsCoroutines() {
    }
    //endregion

    //region methods

    @OptIn(DelicateCoroutinesApi::class)
    private fun globalScope() {

//        GlobalScope.launch(Dispatchers.) {
//
//        }

//        Log.e("2323", "start app")
//        Log.e("2323", "thread outside: ${Thread.currentThread().name}")
//        GlobalScope.launch {
//            Log.e("2323", "thread inside: ${Thread.currentThread().name}")
//        }
//        Log.e("2323", "end app")

    }


    private fun initialBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    //endregion
}

