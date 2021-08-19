package com.example.foodDelivery.ui.restaurantDetail

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.FtsOptions
import com.bumptech.glide.Glide
import com.example.foodDelivery.data.entity.meal.Meal
import com.example.foodDelivery.data.entity.order.OrderRequest
import com.example.foodDelivery.data.entity.restaurant.Restaurant
import com.example.foodDelivery.databinding.FragmentRestaurantDetailBinding
import com.example.foodDelivery.utils.Resource
import com.example.foodDelivery.utils.gone
import com.example.foodDelivery.utils.room.entity.LocalRestaurant
import com.example.foodDelivery.utils.show
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RestaurantDetailFragment: Fragment(),IMealListener {
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
                val dialog = AlertDialog.Builder(context)
                    .setTitle("Success")
                    .setMessage("The restaurant has been added to your favorites")
                    .setPositiveButton("ok") { dialog, button ->
                        dialog.dismiss()
                    }
                dialog.show()
            }
            backButton.setOnClickListener{
                findNavController().popBackStack()
            }
        }
    }

    private fun setData(restaurant: Restaurant) {
        binding.apply {
            restaurantNameTextView.text = restaurant.name
            restaurantAddressTextView.text = restaurant.address
            deliveryTimeTextView.text = "${restaurant.deliveryTime}min."
            paymentTextView.text = restaurant.paymentMethods
            minDeliveryFeeTextView.text = "min ${restaurant.minimumDeliveryFee}$"
            phoneTextView.text = restaurant.phone
            Glide.with(imageView.context)
                .load(restaurant.image).into(imageView)
        }
        adapter.setMealList(restaurant.meals,this)
    }

    private fun getRestaurant() {
        viewModel.getRestaurant().observe(viewLifecycleOwner, { response ->
            when (response.status) {
                Resource.Status.LOADING ->{
                    binding.apply {
                        profilerCardView.gone()
                        restaurantMenuTextView.gone()
                        progressBar.show()
                    }

                }
                Resource.Status.SUCCESS -> {
                    binding.apply {
                        profilerCardView.show()
                        restaurantMenuTextView.show()
                        progressBar.gone()
                    }
                    response.data?.let {
                        setData(it.data)
                        restaurant = it.data.toLocalRestaurant()
                    }
                }
                Resource.Status.ERROR -> {
                    binding.apply {
                        profilerCardView.show()
                        progressBar.gone()
                    }
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
        val action = RestaurantDetailFragmentDirections.actionRestaurantDetailFragmentToMealDetailFragment(meal.id,restaurant.restaurantId)
        findNavController().navigate(action)
    }

    override fun onClickOrder(meal:Meal) {
        viewModel.postOrder(OrderRequest(restaurant.restaurantId,meal.id)).observe(viewLifecycleOwner,{
            when (it.status) {
                Resource.Status.LOADING -> {
                    binding.progressBar.show()
                }
                Resource.Status.SUCCESS -> {
                    binding.progressBar.gone()
                    val dialog = AlertDialog.Builder(context)
                        .setTitle("Success")
                        .setMessage("Your order has been created")
                        .setPositiveButton("ok") { dialog, button ->
                            dialog.dismiss()
                        }
                    dialog.show()
                }
                Resource.Status.ERROR -> {
                    binding.progressBar.gone()
                    val dialog = AlertDialog.Builder(context)
                        .setTitle("Error")
                        .setMessage("${it.message}")
                        .setPositiveButton("ok") { dialog, button ->
                            dialog.dismiss()
                        }
                    dialog.show()
                }
            }
        })
    }


}