package com.alirahimi.androidcourse

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alirahimi.androidcourse.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //region properties
    private lateinit var binding: ActivityMainBinding
    //endregion

    //region lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialBinding()
        configViews()
    }
    //endregion

    //region methods
    private fun initialBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    //1
    private fun configViews() {
        binding.loginButton.setOnClickListener {
            val userName = binding.userNameEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            val loginModule = LoginModule(FakeAuth(), NewErrorHandler3())
            if (loginModule.loginUser(userName, password)) {
                Intent(this, MainActivity2::class.java).also {
                    it.putExtra(Constants.USER_NAME_KEY, userName)
                    it.putExtra(Constants.PASSWORD_KEY, password)
                    startActivity(it)
                }
            }
        }
    }

    //2
//    private fun configViews() {
//        binding.loginButton.setOnClickListener {
//            val userName = binding.userNameEditText.text.toString()
//            val password = binding.passwordEditText.text.toString()
//            val loginModule = LoginModule(FakeAuth(), )
//            if (loginModule.loginUser(userName, password)) {
//                Intent(this, MainActivity2::class.java).also {
//                    it.putExtra(Constants.USER_NAME_KEY, userName)
//                    it.putExtra(Constants.PASSWORD_KEY, password)
//                    startActivity(it)
//                }
//            }
//        }
//    }
    //endregion

}