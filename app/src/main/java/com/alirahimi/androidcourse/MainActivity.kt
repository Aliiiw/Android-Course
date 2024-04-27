package com.alirahimi.androidcourse

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.alirahimi.androidcourse.adapter.UsersAdapter
import com.alirahimi.androidcourse.data.Constants
import com.alirahimi.androidcourse.databinding.ActivityMainBinding
import com.alirahimi.androidcourse.db.UserDatabase

class MainActivity : AppCompatActivity() {

    //region properties
    private lateinit var binding: ActivityMainBinding
    private val userDb: UserDatabase by lazy {
        Room.databaseBuilder(this, UserDatabase::class.java, Constants.USER_DATABASE)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
    private val usersAdapter by lazy { UsersAdapter() }
    //endregion

    //region lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialBinding()
        configListeners()
    }

    override fun onResume() {
        super.onResume()
        checkItems()
    }
    //endregion

    //region methods
    private fun initialBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun configListeners() {
        binding.addUserButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, AddUserActivity::class.java))
        }
    }

    private fun checkItems() {
        binding.apply {
            if (userDb.userDao().getAllUsers().isNotEmpty()) {
                usersList.visibility = View.VISIBLE
                emptyText.visibility = View.GONE

                usersAdapter.differ.submitList(userDb.userDao().getAllUsers())
                setupRecyclerView()

            } else {
                usersList.visibility = View.GONE
                emptyText.visibility = View.VISIBLE
            }
        }
    }

    private fun setupRecyclerView() {
        binding.usersList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = usersAdapter
        }
    }
    //endregion
}

