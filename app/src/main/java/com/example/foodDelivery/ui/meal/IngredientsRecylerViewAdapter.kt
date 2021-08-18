package com.example.foodDelivery.ui.meal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodDelivery.data.entity.restaurant.Restaurant
import com.example.foodDelivery.databinding.ItemIngredientBinding
import com.example.foodDelivery.ui.IOnClickListener

class IngredientsRecyclerViewAdapter: RecyclerView.Adapter<IngredientsRecyclerViewAdapter.IngredientsViewHolder>() {
    private lateinit var binding: ItemIngredientBinding
    private lateinit var  onClickListener : IOnClickListener
    private  var ingredientsList:List<Restaurant> = mutableListOf()

    class IngredientsViewHolder(private val binding: ItemIngredientBinding): RecyclerView.ViewHolder(binding.root),
        View.OnClickListener{
        private lateinit var   onClickListener :IOnClickListener
        fun setItem(item: Restaurant, onClickListener: IOnClickListener) {
            this.onClickListener = onClickListener
            binding.ingredientNameTextView.text = item.name
        }
        override fun onClick(v: View?) {
            onClickListener.onClick(adapterPosition)
        }
    }


    fun setIngredientList(ingredientsList: ArrayList<Restaurant>, onClickListener: IOnClickListener) {
        this.onClickListener =onClickListener
        this.ingredientsList = ingredientsList
        println(ingredientsList.size)
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
        val item = ingredientsList[position]
        holder.setItem(item,onClickListener)
    }

    override fun getItemCount():Int  = ingredientsList.size
}
