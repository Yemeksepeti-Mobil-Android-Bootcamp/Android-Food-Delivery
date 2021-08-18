package com.example.foodDelivery.ui.restaurantDetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodDelivery.data.entity.meal.Meal
import com.example.foodDelivery.data.entity.restaurant.Restaurant
import com.example.foodDelivery.databinding.ItemMealBinding
import com.example.foodDelivery.ui.IOnClickListener


class MealRecyclerViewAdapter:RecyclerView.Adapter<MealRecyclerViewAdapter.MealViewHolder>() {
    private lateinit var binding: ItemMealBinding
    private lateinit var  onClickListener :IOnClickListener
    private  var mealList:List<Meal> = mutableListOf()

    class MealViewHolder(private val binding: ItemMealBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item: Meal, onClickListener: IOnClickListener) {
            binding.apply {
                mealTitleTextView.text = item.name
                mealDescriptionTextView.text = item.description
                mealPriceTextView.text = "${item.price}$"
                Glide.with(mealImageView.context)
                    .load(item.image).into(mealImageView)
            }
            binding.mealCardView.setOnClickListener{
                onClickListener.onClickMeal(item)
            }
        }
    }
    fun setMealList(mealList: List<Meal>, onClickListener: IOnClickListener) {
        this.onClickListener =onClickListener
        this.mealList = mealList
        println(mealList.size)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cargo, parent, false)
        //return CargoViewHolder(view)
        binding = ItemMealBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MealViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val item = mealList[position]
        holder.bind(item,onClickListener)
    }

    override fun getItemCount():Int  = mealList.size
}
