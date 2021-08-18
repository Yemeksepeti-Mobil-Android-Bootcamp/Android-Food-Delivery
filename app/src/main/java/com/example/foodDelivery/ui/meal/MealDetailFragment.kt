package com.example.foodDelivery.ui.meal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodDelivery.databinding.FragmentMealDetailBinding
import com.example.foodDelivery.ui.restaurantDetail.MealRecyclerViewAdapter
import com.example.foodDelivery.ui.restaurantList.Restaurant

class MealDetailFragment:Fragment(),OnIngredientsListener {

    private var _binding: FragmentMealDetailBinding? = null
    private val binding get() = _binding!!
    private var adapter: IngredientsRecylerViewAdapter = IngredientsRecylerViewAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMealDetailBinding.inflate(inflater, container, false)
        setData()
        initViews()
        return binding.root
    }

    private fun setData() {
        val data = ArrayList<Restaurant>()
        for (i in 0..100) {
            data.add(Restaurant("name $i", "address - $i","time- $i"))
        }
        adapter.setIngredientList(data,this)
    }


    private fun initViews() {
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

    override fun onRestaurantClick(position: Int) {
    }
}