package com.example.foodDelivery.ui.restaurantDetail

import com.example.foodDelivery.ui.restaurantList.Restaurant
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodDelivery.databinding.ItemMealBinding


class MealRecyclerViewAdapter:RecyclerView.Adapter<MealRecyclerViewAdapter.MealViewHolder>() {
    private lateinit var binding: ItemMealBinding
    private lateinit var  onCargoListener :OnMealListener
    private  var cargoList:List<Restaurant> = mutableListOf()

    class MealViewHolder(private val binding: ItemMealBinding):RecyclerView.ViewHolder(binding.root),View.OnClickListener{
        private lateinit var   onCargoListener :OnMealListener
        fun setItem(item: Restaurant, onCargoListener: OnMealListener) {
            this.onCargoListener = onCargoListener
            binding.mealTitleTextView.text = item.name
            binding.mealDescriptionTextView.text = item.address
            binding.mealPriceTextView.text = item.time
            binding.mealCardView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            onCargoListener.onRestaurantClick(adapterPosition)
        }
    }


    fun setMealList(cargoList: ArrayList<Restaurant>, onCargoListener: OnMealListener) {
        this.onCargoListener =onCargoListener
        this.cargoList = cargoList
        println(cargoList.size)
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
        val item = cargoList[position]
        holder.setItem(item,onCargoListener)
    }

    override fun getItemCount():Int  = cargoList.size
}

interface OnMealListener{
    fun onRestaurantClick(position:Int)
}