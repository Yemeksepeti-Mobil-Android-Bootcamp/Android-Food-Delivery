package com.example.foodDelivery.ui.restaurantList


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodDelivery.databinding.ItemRestaurantBinding


class RestaurantRecyclerViewAdapter:RecyclerView.Adapter<RestaurantRecyclerViewAdapter.RestaurantViewHolder>() {
    private lateinit var binding: ItemRestaurantBinding
    private lateinit var  onCargoListener :OnRestaurantListener
    private  var cargoList:List<Restaurant> = mutableListOf()

    class RestaurantViewHolder(private val binding: ItemRestaurantBinding):RecyclerView.ViewHolder(binding.root),View.OnClickListener{
        private lateinit var   onCargoListener :OnRestaurantListener
        fun setItem(item: Restaurant,onCargoListener: OnRestaurantListener) {
            this.onCargoListener = onCargoListener
            binding.name.text = item.name
            binding.address.text = item.address
            binding.time.text = item.time
            binding.cardView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            onCargoListener.onRestaurantClick(adapterPosition)
        }
    }


    fun setRestaurantList(cargoList: ArrayList<Restaurant>, onCargoListener: OnRestaurantListener) {
        this.onCargoListener =onCargoListener
        this.cargoList = cargoList
        println(cargoList.size)
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
        val item = cargoList[position]
        holder.setItem(item,onCargoListener)
    }

    override fun getItemCount():Int  = cargoList.size
}

interface OnRestaurantListener{
    fun onRestaurantClick(position:Int)
}