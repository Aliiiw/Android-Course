package com.alirahimi.androidcourse

import android.util.Log

class LoginModule(private val auth: FakeAuth, private val errorHandler: ErrorHandler) {

    //4 attribute class

    fun loginUser(userName: String, password: String): Boolean {
        val isLogin = auth.signInWithUserNameAndPassword(userName, password)
        return if (isLogin) {
            Log.e("2323", "user login")
            true
        } else {
            errorHandler.logError(
                "wrong",
                "192",
                userName,
                password
            )
            false
        }
    }

    //TODO Single Responsibility -> error

}