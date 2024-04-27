package com.alirahimi.androidcourse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.alirahimi.androidcourse.data.Constants
import com.alirahimi.androidcourse.data.model.UserEntity
import com.alirahimi.androidcourse.databinding.ActivityUpdateUserBinding
import com.alirahimi.androidcourse.db.UserDatabase
import com.google.android.material.snackbar.Snackbar

class UpdateUserActivity : AppCompatActivity() {

    //Binding
    private lateinit var binding: ActivityUpdateUserBinding

    //Database
    private val userDb: UserDatabase by lazy {
        Room.databaseBuilder(this, UserDatabase::class.java, Constants.USER_DATABASE)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    //Other
    private lateinit var userEntity: UserEntity
    private var userID = 0
    private var defaultName = ""
    private var defaultAge = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Intent
        intent.extras?.let {
            userID = it.getInt(Constants.BUNDLE_USER_ID)
        }

        //Binding
        binding.apply {
            defaultName = userDb.userDao().getUser(userID).userName
            defaultAge = userDb.userDao().getUser(userID).userAge
            nameEditText.setText(defaultName)
            ageEditText.setText(defaultAge.toString())

            //Delete
            deleteButton.setOnClickListener {
                userEntity = UserEntity(userID, defaultName, defaultAge)
                userDb.userDao().deleteUser(userEntity)
                finish()
            }

            //Update
            updateButton.setOnClickListener {
                val name = nameEditText.text.toString()
                val age = ageEditText.text.toString()
                if (name.isNotEmpty() || age.isNotEmpty()) {
                    userEntity = UserEntity(userID, name, age.toInt())
                    userDb.userDao().updateUser(userEntity)
                    finish()
                } else {
                    Snackbar.make(it, "Name and age cannot be empty", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }
}