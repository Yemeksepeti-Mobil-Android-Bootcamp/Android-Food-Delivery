package com.example.foodDelivery.ui.restaurantDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodDelivery.databinding.FragmentRestaurantDetailBinding
import com.example.foodDelivery.ui.restaurantList.OnRestaurantListener
import com.example.foodDelivery.ui.restaurantList.Restaurant

class RestaurantDetailFragment: Fragment(),OnMealListener {

    private var _binding: FragmentRestaurantDetailBinding? = null
    private val binding get() = _binding!!
    private var adapter: MealRecyclerViewAdapter = MealRecyclerViewAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRestaurantDetailBinding.inflate(inflater, container, false)
        setData()
        initViews()
        return binding.root
    }

    private fun setData() {
        val data = ArrayList<Restaurant>()
        for (i in 0..100) {
            data.add(Restaurant("name $i", "address - $i","time- $i"))
        }
        adapter.setMealList(data,this)
    }


    private fun initViews() {
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

    override fun onRestaurantClick(position: Int) {
    }

}