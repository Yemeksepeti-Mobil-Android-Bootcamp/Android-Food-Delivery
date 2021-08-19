package com.example.foodDelivery.ui.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodDelivery.databinding.ItemRestaurantBinding
import com.example.foodDelivery.utils.room.entity.LocalRestaurant

class FavoriteRecyclerViewAdapter: RecyclerView.Adapter<FavoriteRecyclerViewAdapter.FavoriteViewHolder>() {
    private lateinit var binding: ItemRestaurantBinding
    private lateinit var  onClickListener : IFavoriteListener
    private  var restaurant:List<LocalRestaurant> = mutableListOf()

    class FavoriteViewHolder(private val binding: ItemRestaurantBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item: LocalRestaurant, onClickListener: IFavoriteListener) {
            binding.apply {
                name.text = item.name
                address.text = item.address
                time.text = item.deliveryTime
                Glide.with(imageView.context)
                    .load(item.image).into(imageView)
                cardView.setOnClickListener{
                    onClickListener.onClick(item)
                }
                delete.setOnClickListener{
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