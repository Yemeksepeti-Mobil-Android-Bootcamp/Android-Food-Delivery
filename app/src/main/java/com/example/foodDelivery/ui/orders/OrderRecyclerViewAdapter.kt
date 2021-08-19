package com.example.foodDelivery.ui.orders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodDelivery.data.entity.order.Order
import com.example.foodDelivery.databinding.ItemOrderBinding

class OrderRecyclerViewAdapter: RecyclerView.Adapter<OrderRecyclerViewAdapter.OrderViewHolder>() {

    private lateinit var binding: ItemOrderBinding
    private  var orderList:List<Order> = mutableListOf()

    class OrderViewHolder(private val binding: ItemOrderBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(item: Order) {
            binding.apply {
                date.text = item.createdDate.toString()
                price.text = item.price.toString()
                restaurant.text = item.restaurant.name
                meal.text = item.meal.name
            }
        }
    }


    fun setOrderList(orderList: List<Order>) {
        this.orderList = orderList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cargo, parent, false)
        //return CargoViewHolder(view)
        binding = ItemOrderBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return OrderViewHolder(binding)

    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val item = orderList[position]
        holder.bind(item)
    }

    override fun getItemCount():Int  = orderList.size
}
