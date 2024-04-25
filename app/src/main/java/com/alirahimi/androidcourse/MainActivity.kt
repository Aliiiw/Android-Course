package com.alirahimi.androidcourse

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.alirahimi.androidcourse.databinding.ActivityMainBinding
import com.alirahimi.androidcourse.databinding.FragmentMainSecondBinding
import com.alirahimi.androidcourse.feature.post.presentation.ui.adapter.PostAdapter
import com.alirahimi.androidcourse.feature.post.presentation.viewmodel.PostViewModel
import com.alirahimi.androidcourse.feature.post.presentation.viewmodel.PostViewModelFactory
import com.alirahimi.androidcourse.shared_component.data.Constants
import com.alirahimi.androidcourse.utils.extensions.putString
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    //region properties
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: PostViewModel
    private lateinit var sharedPreferences: SharedPreferences
    //endregion

    //region lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialBinding()
        initialViewModel()
        initialSharedPreference()
        initialButton()
    }
    //endregion

    //region methods

    private fun initialSharedPreference() {
        sharedPreferences = getSharedPreferences(Constants.SHARED_PREFERENCE_KEY, MODE_PRIVATE)
        val token = sharedPreferences.getString(Constants.USER_TOKEN_KEY, "").toString()
    }

    private fun initialBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initialViewModel() {
        viewModel = ViewModelProvider(this, PostViewModelFactory())[PostViewModel::class.java]
    }

    private fun initialButton() {

        binding.addButton.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .add(binding.mainContainer.id, MainSecondFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.replaceButton.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(binding.mainContainer.id, MainFragment())
                .commit()
        }
    }
    //endregion
}

