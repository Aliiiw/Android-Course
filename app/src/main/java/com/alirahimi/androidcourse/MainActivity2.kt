package com.alirahimi.androidcourse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alirahimi.androidcourse.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialBinding()
        configViews()
        configListener()
    }

    private fun initialBinding() {
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun configViews() {
        binding.username.text = intent.extras?.getString(Constants.USER_NAME_KEY)
        binding.password.text = intent.extras?.getString(Constants.PASSWORD_KEY)
    }

    private fun configListener() {
        binding.turnBackButton.setOnClickListener {
            finish()
        }
    }

}