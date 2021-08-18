package com.example.foodDelivery.ui.meal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodDelivery.databinding.ItemIngredientBinding
import com.example.foodDelivery.databinding.ItemMealBinding
import com.example.foodDelivery.ui.restaurantList.Restaurant

class IngredientsRecylerViewAdapter: RecyclerView.Adapter<IngredientsRecylerViewAdapter.IngredientsViewHolder>() {
    private lateinit var binding: ItemIngredientBinding
    private lateinit var  onCargoListener :OnIngredientsListener
    private  var cargoList:List<Restaurant> = mutableListOf()

    class IngredientsViewHolder(private val binding: ItemIngredientBinding): RecyclerView.ViewHolder(binding.root),
        View.OnClickListener{
        private lateinit var   onCargoListener :OnIngredientsListener
        fun setItem(item: Restaurant, onCargoListener: OnIngredientsListener) {
            this.onCargoListener = onCargoListener
            binding.ingredientNameTextView.text = item.name
        }
        override fun onClick(v: View?) {
            onCargoListener.onRestaurantClick(adapterPosition)
        }
    }


    fun setIngredientList(cargoList: ArrayList<Restaurant>, onCargoListener: OnIngredientsListener) {
        this.onCargoListener =onCargoListener
        this.cargoList = cargoList
        println(cargoList.size)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientsViewHolder {
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cargo, parent, false)
        //return CargoViewHolder(view)
        binding = ItemIngredientBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return IngredientsViewHolder(binding)

    }

    override fun onBindViewHolder(holder: IngredientsViewHolder, position: Int) {
        val item = cargoList[position]
        holder.setItem(item,onCargoListener)
    }

    override fun getItemCount():Int  = cargoList.size
}

interface OnIngredientsListener{
    fun onRestaurantClick(position:Int)
}