package com.example.foodDelivery.ui.meal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodDelivery.databinding.ItemIngredientBinding

class IngredientsRecyclerViewAdapter: RecyclerView.Adapter<IngredientsRecyclerViewAdapter.IngredientsViewHolder>() {
    private lateinit var binding: ItemIngredientBinding
    private  var ingredientsList:List<String> = mutableListOf()

    class IngredientsViewHolder(private val binding: ItemIngredientBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(item: String) {
            binding.ingredientNameTextView.text = item
        }
    }


    fun setIngredientList(ingredientsList: ArrayList<String>) {
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
        holder.bind(item)
    }

    override fun getItemCount():Int  = ingredientsList.size
}
