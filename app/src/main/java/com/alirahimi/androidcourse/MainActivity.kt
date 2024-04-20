package com.alirahimi.androidcourse

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.alirahimi.androidcourse.databinding.ActivityMainBinding
import com.alirahimi.androidcourse.feature.post.presentation.ui.adapter.PostAdapter
import com.alirahimi.androidcourse.feature.post.presentation.viewmodel.PostViewModel
import com.alirahimi.androidcourse.feature.post.presentation.viewmodel.PostViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    //region properties
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: PostViewModel
    //endregion

    //region lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialBinding()
        initialViewModel()
        configViewModel()
        callApi()
    }
    //endregion

    //region methods
    private fun initialBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initialViewModel() {
        viewModel = ViewModelProvider(this, PostViewModelFactory())[PostViewModel::class.java]
    }

    private fun configViewModel() {
        viewModel.posts.observe(this) { posts ->
            val list = posts.take(7)
            val adapter = PostAdapter(list)

            binding.postRecyclerView.adapter = adapter
            binding.postRecyclerView.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.postRecyclerView.addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    LinearLayoutManager.VERTICAL
                )
            )

            binding.postRecyclerView.itemAnimator = DefaultItemAnimator()


        }

        viewModel.loadingState.observe(this) {
            if (it) {
                ////
            } else {

            }
        }
    }

    private fun callApi() {

        CoroutineScope(Dispatchers.Main).launch {
            binding.constraintAll.visibility = View.INVISIBLE
            binding.linearLoading.visibility = View.VISIBLE
            delay(2000)
            viewModel.getAllPost()
            binding.constraintAll.visibility = View.VISIBLE
            binding.linearLoading.visibility = View.GONE
        }

    }
    //endregion
}

