package com.example.foodDelivery.ui.restaurantDetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodDelivery.data.entity.meal.Meal
import com.example.foodDelivery.databinding.ItemMealBinding


class MealRecyclerViewAdapter:RecyclerView.Adapter<MealRecyclerViewAdapter.MealViewHolder>() {
    private lateinit var binding: ItemMealBinding
    private lateinit var  onClickListener :IMealListener
    private  var mealList:List<Meal> = mutableListOf()

    class MealViewHolder(private val binding: ItemMealBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item: Meal, onClickListener: IMealListener) {
            binding.apply {
                mealNameTextView.text = item.name
                val description = "Meal Description"
                mealDescriptionTextView.text = description
                mealPriceTextView.text = "${item.price}$"
                Glide.with(imageView.context)
                    .load(item.image).into(imageView)
                mealCardView.setOnClickListener{
                    onClickListener.onClickMeal(item)
                }
                orderButton.setOnClickListener{
                    onClickListener.onClickOrder(item)
                }
            }


        }
    }
    fun setMealList(mealList: List<Meal>, onClickListener: IMealListener) {
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
