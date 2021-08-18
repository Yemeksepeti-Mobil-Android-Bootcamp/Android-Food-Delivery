package com.example.foodDelivery.ui.restaurantList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodDelivery.data.entity.restaurant.Restaurant
import com.example.foodDelivery.databinding.ItemRestaurantBinding
import com.example.foodDelivery.ui.IOnClickListener

class RestaurantRecyclerViewAdapter:RecyclerView.Adapter<RestaurantRecyclerViewAdapter.RestaurantViewHolder>() {
    private lateinit var binding: ItemRestaurantBinding
    private lateinit var  onClickListener : IOnClickListener
    private  var restaurant:List<Restaurant> = mutableListOf()

    class RestaurantViewHolder(private val binding: ItemRestaurantBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item: Restaurant, onClickListener: IOnClickListener) {
            binding.apply {
                name.text = item.name
                address.text = item.address
                time.text = item.deliveryTime
                Glide.with(imageView.context)
                    .load(item.image).into(imageView)
            }
            binding.cardView.setOnClickListener{
                onClickListener.onClick(item)
            }
        }
    }
    fun setRestaurantList(restaurant: List<Restaurant>, onClickListener: IOnClickListener) {
        this.onClickListener =onClickListener
        this.restaurant = restaurant
        println(restaurant.size)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cargo, parent, false)
        //return CargoViewHolder(view)
        binding = ItemRestaurantBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return RestaurantViewHolder(binding)
    }
    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val item = restaurant[position]
        holder.bind(item,onClickListener)
    }
    override fun getItemCount():Int  = restaurant.size
}
