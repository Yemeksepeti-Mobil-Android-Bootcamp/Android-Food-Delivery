package com.example.foodDelivery.ui.restaurantDetail

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.foodDelivery.R
import com.example.foodDelivery.data.entity.meal.Meal
import com.example.foodDelivery.data.entity.restaurant.Restaurant
import com.example.foodDelivery.databinding.FragmentRestaurantDetailBinding
import com.example.foodDelivery.ui.BaseFragment
import com.example.foodDelivery.ui.home.HomeFragmentDirections
import com.example.foodDelivery.utils.Resource
import com.example.foodDelivery.utils.gone
import com.example.foodDelivery.utils.room.entity.LocalRestaurant
import com.example.foodDelivery.utils.show
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RestaurantDetailFragment: BaseFragment() {
    private val viewModel: RestaurantDetailViewModel by viewModels()
    private var _binding: FragmentRestaurantDetailBinding? = null
    private val binding get() = _binding!!
    private var adapter: MealRecyclerViewAdapter = MealRecyclerViewAdapter()
    private lateinit var restaurant:LocalRestaurant

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRestaurantDetailBinding.inflate(inflater, container, false)
        initViews()
        getRestaurant()
        return binding.root
    }

    private fun initViews() {
        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = adapter
            favButton.setOnClickListener{
                viewModel.addFavorite(restaurant)
            }
        }
    }


    private fun setData(restaurant: Restaurant) {
        binding.apply {
            name.text = restaurant.name
            address.text = restaurant.address
            time.text = restaurant.deliveryTime
            Glide.with(imageView.context)
                .load(restaurant.image).into(imageView)
        }
        adapter.setMealList(restaurant.meals,this)
    }

    private fun getRestaurant() {
        viewModel.getRestaurant().observe(viewLifecycleOwner, { response ->
            when (response.status) {
                Resource.Status.LOADING ->{
                    binding.progressBar.show()
                }
                Resource.Status.SUCCESS -> {
                    binding.progressBar.gone()
                    response.data?.let {
                        setData(it.data)
                        restaurant = it.data.toLocalRestaurant()
                    }
                }
                Resource.Status.ERROR -> {
                    binding.progressBar.gone()
                    val dialog = AlertDialog.Builder(context)
                        .setTitle("Error")
                        .setMessage("${response.message}")
                        .setPositiveButton("ok") { dialog, button ->
                            dialog.dismiss()
                        }
                    dialog.show()
                }
            }
        })
    }

    override fun onClickMeal(meal: Meal) {
        val action = RestaurantDetailFragmentDirections.actionRestaurantDetailFragmentToMealDetailFragment(meal.id)
        findNavController().navigate(action)
    }

    override fun onClick(restaurant: Restaurant) {

    }

}