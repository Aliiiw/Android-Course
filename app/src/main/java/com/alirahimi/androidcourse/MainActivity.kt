package com.alirahimi.androidcourse

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.alirahimi.androidcourse.databinding.ActivityMainBinding
import com.alirahimi.androidcourse.databinding.DialogAddNewItemBinding
import com.alirahimi.androidcourse.databinding.RecyclerViewBinding
import com.alirahimi.androidcourse.feature.home.domain.data.model.Food
import com.alirahimi.androidcourse.feature.home.presentation.ui.adapter.FoodAdapter
import com.alirahimi.androidcourse.utils.NetworkChecker

class MainActivity : AppCompatActivity() {

    //region

    //1. private lateinit var binding: ActivityMainBinding
    private lateinit var binding: ActivityMainBinding

    //private lateinit var binding: RecyclerViewBinding
    private lateinit var broadcastReceiver: BroadcastReceiver
    private var isNetworkConnected = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //2. binding = ActivityMainBinding.inflate(layoutInflater)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonToggle.setOnClickListener {
            Intent(this, MainActivity2::class.java).also {
                startActivity(it)
            }
        }


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
        val foodAdapter = FoodAdapter(foodList)
        ///binding.recyclerMain.adapter = foodAdapter
        //binding.recyclerMain.layoutManager =
        // LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        binding.recyclerMain.initRecycler(
//            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false),
//            adapter
//        )

        // addNewFood(foodAdapter)
    }

//    private fun addNewFood(adapter: FoodAdapter) {
//
//        binding.buttonAddNewFood.setOnClickListener {
//            val dialog = DialogAddNewItemBinding.inflate(layoutInflater)
//
//            //Builder
//
//            val alertDialog = AlertDialog.Builder(this)
//                .setView(dialog.root)
//                .setCancelable(true)
//                .create()
//
//
//            alertDialog.show()
//            dialog.dialogButtonDone.setOnClickListener {
//
//                if (
//                    dialog.dialogEditNameFood.text?.isNotEmpty()!! &&
//                    dialog.dialogEditFoodPrice.text?.isNotEmpty()!! &&
//                    dialog.dialogEditFoodDistance.text?.isNotEmpty()!! &&
//                    dialog.dialogEditFoodCity.text?.isNotEmpty()!!
//                ) {
//                    val name = dialog.dialogEditNameFood.text.toString()
//                    val price = dialog.dialogEditFoodPrice.text.toString()
//                    val distance = dialog.dialogEditFoodDistance.text.toString()
//                    val city = dialog.dialogEditFoodCity.text.toString()
//
//                    val numberOfRating = (1..150).random()
//                    //val numberOfRating = (1 until 150).random()
//                    val ratingBarStar = (1..5).random().toFloat()
//                    val itemImage = R.drawable.food1
//
////                    val minValue = 0f
////                    val maxValue = 5f
////                    val random = minValue + Random().nextFloat() * (maxValue - minValue)
//
//                    val newFood = Food(
//                        name,
//                        price,
//                        distance,
//                        city,
//                        itemImage,
//                        numberOfRating,
//                        ratingBarStar
//                    )
//
//                    adapter.addFood(newFood)
//                    alertDialog.dismiss()
//                    binding.recyclerMain.smoothScrollToPosition(7)
//
//                } else {
//                    Toast.makeText(this, "لطفا مقادیر را کامل وارد کنید", Toast.LENGTH_LONG).show()
//                }
//            }
//        }
//    }

    private fun configBroadCastReceiver() {
        broadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                checkNetworkConnected()
            }
        }
        val intentFilter = IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")
        this.registerReceiver(broadcastReceiver, intentFilter)
    }

    private fun checkNetworkConnected() {
        isNetworkConnected = NetworkChecker(this).isInternetConnected
    }

    private fun openGoogle() {
        val uri = Uri.parse("www.google.com")
        Intent(Intent.ACTION_VIEW, uri).also {
            startActivity(it)
        }
    }

    private fun moveToShare() {
        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.putExtra(Intent.EXTRA_TEXT, "Lets Install this App!")
        intent.type = "text/plain"
        startActivity(intent)
    }

    private fun moveToDial() {
        val uri = Uri.parse("tel: 09179544301")
        Intent(Intent.ACTION_DIAL, uri).also {
            startActivity(it)
        }
    }
}

