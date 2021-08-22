package com.example.foodDelivery.ui.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodDelivery.databinding.ItemRestaurantBinding
import com.example.foodDelivery.utils.gone
import com.example.foodDelivery.utils.room.entity.LocalRestaurant
import com.example.foodDelivery.utils.show

class FavoriteRecyclerViewAdapter: RecyclerView.Adapter<FavoriteRecyclerViewAdapter.FavoriteViewHolder>() {
    private lateinit var binding: ItemRestaurantBinding
    private lateinit var  onClickListener : IFavoriteListener
    private  var restaurant:List<LocalRestaurant> = mutableListOf()

    class FavoriteViewHolder(private val binding: ItemRestaurantBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item: LocalRestaurant, onClickListener: IFavoriteListener) {
            binding.apply {
                restaurantNameTextView.text = item.name
                restaurantAddressTextView.text = item.address
                val deliveryTime = "${item.deliveryTime} min."
                deliveryTimeTextView.text = deliveryTime
                paymentTextView.text = item.paymentMethods
                val minDeliveryFee = "min ${item.minDeliveryFee}$"
                minDeliveryFeeTextView.text = minDeliveryFee
                Glide.with(imageView.context)
                    .load(item.image).into(imageView)
                cardView.setOnClickListener{
                    onClickListener.onClick(item)
                }
                favButton.gone()
                favDeleteButton.show()
                favDeleteButton.setOnClickListener{
                    onClickListener.onClickFavButton(item)
                }
            }

        }
    }
    fun setRestaurantList(restaurant: List<LocalRestaurant>, onClickListener: IFavoriteListener) {
        this.onClickListener =onClickListener
        this.restaurant = restaurant
        println(restaurant.size)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cargo, parent, false)
        //return CargoViewHolder(view)
        binding = ItemRestaurantBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(binding)
    }
    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val item = restaurant[position]
        holder.bind(item,onClickListener)
    }
    override fun getItemCount():Int  = restaurant.size
}