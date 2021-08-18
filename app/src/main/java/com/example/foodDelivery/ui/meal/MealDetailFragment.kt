package com.example.foodDelivery.ui.meal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodDelivery.data.entity.restaurant.Restaurant
import com.example.foodDelivery.databinding.FragmentMealDetailBinding
import com.example.foodDelivery.ui.BaseFragment

class MealDetailFragment: Fragment() {

    private var _binding: FragmentMealDetailBinding? = null
    private val binding get() = _binding!!
    private var adapter: IngredientsRecyclerViewAdapter = IngredientsRecyclerViewAdapter()
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
//        val data = ArrayList<Restaurant>()
//        for (i in 0..100) {
//            data.add(Restaurant("name $i", "address - $i","time- $i"))
//        }
//        adapter.setIngredientList(data,this)
    }


    private fun initViews() {
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

}