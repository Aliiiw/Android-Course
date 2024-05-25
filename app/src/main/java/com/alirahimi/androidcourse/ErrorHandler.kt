package com.alirahimi.androidcourse

import android.util.Log

//1
//class ErrorHandler {
//
//    fun logError(message: String, IP: String, userName: String, password: String) {
//        Log.e("2323", "message: $message")
//        Log.e("2323", "IP: $IP")
//        Log.e("2323", "incorrect username is: $userName")
//        Log.e("2323", "incorrect password is: $password")
//    }
//}


//2 / 3
//open class ErrorHandler {
//
//    open fun logError(message: String, IP: String, userName: String, password: String) {
//        Log.e("2323", "message: $message")
//        Log.e("2323", "IP: $IP")
//        Log.e("2323", "incorrect username is: $userName")
//        Log.e("2323", "incorrect password is: $password")
//
//        //close
//    }
//}

class NewErrorHandler : ErrorHandler {


    override fun logError(message: String, IP: String, userName: String, password: String) {
        Log.e("2323", "message: $message")
    }
}

class NewErrorHandler2 : ErrorHandler {


    override fun logError(message: String, IP: String, userName: String, password: String) {
        Log.e("2323", "ip: $IP")
    }
}

class NewErrorHandler3 : ErrorHandler {

    override fun errorHandlerCustom() {
        Log.e("2323", "🚬")
    }

    override fun logError(message: String, IP: String, userName: String, password: String) {
        Log.e("2323", "ip: $IP")
    }
}

//
//
////3 without override
//
//
////4
//
interface ErrorHandler {

    fun errorHandlerCustom(){}

    fun logError(message: String, IP: String, userName: String, password: String) {
        Log.e("2323", "message: $message")
        Log.e("2323", "IP: $IP")
        Log.e("2323", "incorrect username is: $userName")
        Log.e("2323", "incorrect password is: $password")

        //close
    }
}
