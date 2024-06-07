package com.alirahimi.androidcourse

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.alirahimi.androidcourse.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialBinding()
        initialFlow()
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun initialFlow() {
        //TODO 1. create flow
        //TODO 2. emit flow
        //TODO 3. cold / collect
        //TODO 4. stream

        runBlocking {
            flow {
                delay(2000)
                emit(2)
            }.collect {
                Log.e("2323", it.toString())
            }
        }

        /////////////////////////////////////////////////////

//        val myFlow = flow {
//            delay(2000)
//            emit(5)
//        }
//
//        runBlocking {
//            myFlow.collect {
//                Log.e("2323", it.toString())
//            }
//        }

        /////////////////////////////////////////////////////

        val myFlow = flow {
            delay(1000)
            emit(1)
            delay(1000)
            emit(2)
            delay(1000)
            emit(3)
            delay(1000)
            emit(4)
            delay(1000)
            emit(5)
        }
        runBlocking {
            myFlow.collect {
                Log.e("2323", it.toString())
            }
        }

        ///////////////////////////////////////////////////////

        runBlocking {
            power2().collect {
                Log.e("2323", it.toString())
            }
        }

        /////////////////////////////////////////////////////

        //TODO 5. on collections
        runBlocking {
            sendNumbers2().collect {
                Log.e("2323", it.toString())
            }
        }

        /////////////////////////////////////////////////////

        // TODO 6. cancellation / when coroutines cancel / not it self
        val job = GlobalScope.launch {
            power2().collect {
                Log.e("2323", it.toString())
            }
        }

        Thread.sleep(5000)
        job.cancel()

        runBlocking {
            withTimeout(5000) {
                power2().collect {
                    Log.e("2323", it.toString())
                }
            }
        }

        /////////////////////////////////////////////////////

        //TODO 7. collect / collectLatest ->
        // if it takes more that usual and new emit come cancel olds
        runBlocking {
            power2().collectLatest {
                //delay(90)
                delay(100)
                Log.e("2323", it.toString())
            }
        }


        /////////////////////////////////////////////////////

        //TODO 8. filter
        GlobalScope.launch {
            myTestFlow().filter {
                    it.mod(2) == 0
                }.collect {
                    Log.e("2323", it.toString())
                }
        }

        ///////////////////////////////////////////////////////

        //TODO 8. map
        GlobalScope.launch {
            myTestFlow().filter {
                    it.mod(2) == 0
                }.map {
                    "number is: $it"
                }.collect {
                    Log.e("2323", it.toString())
                }
        }

        /////////////////////////////////////////////////////

        //TODO 8. transform
        GlobalScope.launch {
            myTestFlow().filter {
                    it.mod(2) == 0
                }.map {
                    it * 10
                }.transform {
                    emit(it)
                    emit("new emit from transform: $it")
                }.collect {
                    Log.e("2323", it.toString())
                }
        }

        /////////////////////////////////////////////////////

        //TODO 8. onEach
        //TODO 9. take

        /////////////////////////////////////////////////////

        //TODO 10. toList
        GlobalScope.launch {
            myTestFlow().filter {
                    it.mod(2) == 0
                }.toList().forEach {
                    Log.e("2323", "item: $it")
                }
        }
    }


    private fun myTestFlow() = flow {
        for (i in 1..100) {
            delay(100)
            emit(i)
        }
    }

    private fun sendNumbers() = listOf(1, 2, 3, 4, 5).asFlow()
    private fun sendNumbers1() = flowOf(1, 2, 3, 4, 5)
    private fun sendNumbers2() = flowOf(1, "hi", true, 4.5, 5L, -1)

    private fun power2(): Flow<Int> = flow {
        for (i in 1..200) {
            delay(100)
            emit(i * i)
        }
    }

    private fun initialBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}

