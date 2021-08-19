package com.example.foodDelivery.ui.restaurantList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodDelivery.data.entity.restaurant.Restaurant
import com.example.foodDelivery.databinding.ItemRestaurantBinding
import com.example.foodDelivery.ui.IOnClickListener
import com.example.foodDelivery.utils.gone

class RestaurantRecyclerViewAdapter:RecyclerView.Adapter<RestaurantRecyclerViewAdapter.RestaurantViewHolder>() {
    private lateinit var binding: ItemRestaurantBinding
    private lateinit var  onClickListener : IRestaurantListener
    private  var restaurant:List<Restaurant> = mutableListOf()

    class RestaurantViewHolder(private val binding: ItemRestaurantBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item: Restaurant, onClickListener: IRestaurantListener) {
            binding.apply {
                restaurantNameTextView.text = item.name
                restaurantAddressTextView.text = item.address
                deliveryTimeTextView.text = "${item.deliveryTime} min."
                paymentTextView.text = item.paymentMethods
                minDeliveryFeeTextView.text = "min ${item.minimumDeliveryFee}$"
                Glide.with(imageView.context)
                    .load(item.image).into(imageView)
                favDeleteButton.gone()
                cardView.setOnClickListener{
                    onClickListener.onClick(item)
            }
                favButton.setOnClickListener{
                    onClickListener.onFavoriteClick(item)
                }
            }
        }
    }
    fun setRestaurantList(restaurant: List<Restaurant>, onClickListener: IRestaurantListener) {
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
