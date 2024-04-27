package com.alirahimi.androidcourse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.alirahimi.androidcourse.data.Constants
import com.alirahimi.androidcourse.data.model.UserEntity
import com.alirahimi.androidcourse.databinding.ActivityAddUserBinding
import com.alirahimi.androidcourse.db.UserDatabase
import com.google.android.material.snackbar.Snackbar


class AddUserActivity : AppCompatActivity() {

    //Binding
    private lateinit var binding: ActivityAddUserBinding

    //Database
    private val userDb: UserDatabase by lazy {
        Room.databaseBuilder(this, UserDatabase::class.java, Constants.USER_DATABASE)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    //Other
    private lateinit var user: UserEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //InitViews
        binding.apply {

            //Save
            saveButton.setOnClickListener {
                val name = nameEditText.text.toString()
                val age = ageEditText.text.toString()

                if (name.isNotEmpty() || age.isNotEmpty()) {
                    user = UserEntity(0, name, age.toInt())
                    userDb.userDao().insertUser(user)
                    finish()
                } else {
                    Snackbar.make(
                        it,
                        "Name and age cannot be empty",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}