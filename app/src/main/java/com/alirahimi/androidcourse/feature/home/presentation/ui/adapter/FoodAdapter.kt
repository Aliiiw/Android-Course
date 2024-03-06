package com.alirahimi.androidcourse.feature.home.presentation.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alirahimi.androidcourse.R
import com.alirahimi.androidcourse.feature.home.domain.data.model.Food

/*
we need to customize for our need so

1. extend from RecyclerView.Adapter()
2. create view holder -> for hold my data -> extend from RecyclerView.ViewHolder()
3. give the view to view holder
4. in view holder you should tell the holder that what data you have
5. get the data in simple mode
6. add the View holder to my adapter -> implement them 3 functions
7. onCreateViewHolder -> for creating my view holder
8. create data class fr your items
9. get the list of data
10. getItemCount -> know how many items we have
11. onBindViewHolder -> set my data to my cards or anything -> need to change the items -> call on every scroll

 */


class FoodAdapter(private val foods: ArrayList<Food>) :
    RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imageMain = itemView.findViewById<ImageView>(R.id.item_image_main)
        private val subjectText = itemView.findViewById<TextView>(R.id.item_text_subject)
        private val cityText = itemView.findViewById<TextView>(R.id.item_text_city)
        private val priceText = itemView.findViewById<TextView>(R.id.item_text_price)
        private val distanceText = itemView.findViewById<TextView>(R.id.item_text_distance)
        private val ratingText = itemView.findViewById<TextView>(R.id.item_text_rating)
        private val ratingBar = itemView.findViewById<RatingBar>(R.id.item_rating_main)

        @SuppressLint("SetTextI18n")
        fun bindData(position: Int) {
            imageMain.setImageResource(foods[position].image)
            subjectText.text = foods[position].subject
            cityText.text = foods[position].city
            priceText.text = "$" + foods[position].price
            distanceText.text = foods[position].distance + " Km"
            ratingText.text = "(${foods[position].numberOfRatings} Ratings)"
            ratingBar.rating = foods[position].rating
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = foods.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(position)
    }

    fun addFood(newFood: Food) {
        foods.add(0, newFood)
        notifyItemInserted(0)
    }

}