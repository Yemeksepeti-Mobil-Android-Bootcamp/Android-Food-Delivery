package com.example.foodDelivery.ui.restaurantDetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodDelivery.data.entity.restaurant.Restaurant
import com.example.foodDelivery.databinding.ItemMealBinding
import com.example.foodDelivery.ui.IOnClickListener


class MealRecyclerViewAdapter:RecyclerView.Adapter<MealRecyclerViewAdapter.MealViewHolder>() {
    private lateinit var binding: ItemMealBinding
    private lateinit var  onClickListener :IOnClickListener
    private  var mealList:List<Restaurant> = mutableListOf()

    class MealViewHolder(private val binding: ItemMealBinding):RecyclerView.ViewHolder(binding.root),View.OnClickListener{
        private lateinit var   onClickListener :IOnClickListener
        fun setItem(item: Restaurant, onClickListener: IOnClickListener) {
            this.onClickListener = onClickListener
            binding.mealTitleTextView.text = item.name
            binding.mealDescriptionTextView.text = item.address
            binding.mealCardView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            onClickListener.onClick(adapterPosition)
        }
    }


    fun setMealList(mealList: ArrayList<Restaurant>, onClickListener: IOnClickListener) {
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
        holder.setItem(item,onClickListener)
    }

    override fun getItemCount():Int  = mealList.size
}
