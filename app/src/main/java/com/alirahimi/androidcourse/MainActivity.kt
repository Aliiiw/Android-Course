package com.alirahimi.androidcourse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.alirahimi.androidcourse.databinding.RecyclerViewBinding
import com.alirahimi.androidcourse.feature.home.domain.data.model.Food
import com.alirahimi.androidcourse.feature.home.presentation.ui.adapter.FoodAdapter

class MainActivity : AppCompatActivity() {

    //1. private lateinit var binding: ActivityMainBinding

    private lateinit var binding: RecyclerViewBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //2. binding = ActivityMainBinding.inflate(layoutInflater)

        binding = RecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foodList = arrayListOf(
            Food("Hamburger", "15", "3", "LA, USA", R.drawable.food1, 20, 4.5f),
            Food("Grilled fish", "20", "2.1", "Tehran, Iran", R.drawable.food1, 10, 4f),
            Food("Lasania", "40", "1.4", "Isfahan, Iran", R.drawable.food1, 30, 2f),
            Food("pizza", "10", "2.5", "Zahedan, Iran", R.drawable.food1, 80, 1.5f),
            Food("Sushi", "20", "3.2", "Mashhad, Iran", R.drawable.food1, 200, 3f),
            Food("Roasted Fish", "40", "3.7", "Yazd, Iran", R.drawable.food1, 50, 3.5f),
            Food("Fried chicken", "70", "3.5", "NewYork, USA", R.drawable.food1, 70, 2.5f),
            Food("Vegetable salad", "12", "3.6", "Berlin, Germany", R.drawable.food1, 40, 4.5f),
            Food("Grilled chicken", "10", "3.7", "Beijing, China", R.drawable.food1, 15, 5f),
            Food("Baryooni", "16", "10", "Tehran, Iran", R.drawable.food1, 28, 4.5f),
            Food("Ghorme Sabzi", "11.5", "7.5", "Karaj, Iran", R.drawable.food1, 27, 5f),
            Food("Rice", "12.5", "2.4", "Shiraz, Iran", R.drawable.food1, 35, 2.5f),
        )

        //TODO make recycler view
        //1. create view for recycler
        //2. create item for recycler
        //3. create adapter for recycler
        //4. set adapter to recycler
        //5. set the layout manager
        val adapter = FoodAdapter(foodList)
        binding.recyclerMain.adapter = adapter
        binding.recyclerMain.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        binding.recyclerMain.initRecycler(
//            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false),
//            adapter
//        )
    }

}

