package com.example.foodDelivery.ui.restaurantList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodDelivery.databinding.FregmentRestaurantListBinding

class RestaurantListFragment:Fragment(),OnCargoListener  {

    private var _binding: FregmentRestaurantListBinding? = null
    private val binding get() = _binding!!
    private var adapter: RestaurantRecyclerViewAdapter = RestaurantRecyclerViewAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FregmentRestaurantListBinding.inflate(inflater, container, false)
        setData()
        initViews()
        return binding.root
    }

    private fun setData() {
        val data = ArrayList<Restaurant>()
        for (i in 0..100) {
            data.add(Restaurant("name $i", "address - $i","time- $i"))
        }
        adapter.setRestaurantList(data,this)
        }


    private fun initViews() {
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

    override fun OnCargoClick(position: Int) {
    }


}