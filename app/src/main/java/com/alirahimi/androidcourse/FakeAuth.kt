package com.alirahimi.androidcourse

class FakeAuth {

    private val userName = "aliiiw"
    private val password = "123"

    fun signInWithUserNameAndPassword(userName: String, password: String): Boolean {
        return this.userName == userName && this.password == password
    }

}