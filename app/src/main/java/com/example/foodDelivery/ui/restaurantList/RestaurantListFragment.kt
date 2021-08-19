package com.example.foodDelivery.ui.restaurantList

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodDelivery.data.entity.restaurant.Restaurant
import com.example.foodDelivery.databinding.FregmentRestaurantListBinding
import com.example.foodDelivery.ui.BaseFragment
import com.example.foodDelivery.ui.home.HomeFragmentDirections
import com.example.foodDelivery.utils.Resource
import com.example.foodDelivery.utils.gone
import com.example.foodDelivery.utils.room.entity.LocalRestaurant
import com.example.foodDelivery.utils.show
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RestaurantListFragment:BaseFragment()  {

    private var _binding: FregmentRestaurantListBinding? = null
    private val binding get() = _binding!!
    private var adapter: RestaurantRecyclerViewAdapter = RestaurantRecyclerViewAdapter()
    private val viewModel: RestaurantListViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FregmentRestaurantListBinding.inflate(inflater, container, false)
        initViews()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getRestaurants()
    }



    private fun getRestaurants() {
        viewModel.getRestaurants().observe(viewLifecycleOwner, { response ->
            when (response.status) {
                Resource.Status.LOADING ->{
                    binding.progressBar.show()
                }
                Resource.Status.SUCCESS -> {
                    binding.progressBar.gone()
                    viewModel.restaurantList = response.data!!.restaurantList
                    setData(viewModel.restaurantList)
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

    private fun setData(restaurantList: List<Restaurant>) {
        adapter.setRestaurantList(restaurantList,this)
        }


    private fun initViews() {
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

    override fun onClick(restaurant: Restaurant) {
        val action = HomeFragmentDirections.actionHomeFragmentToRestaurantDetailFragment(restaurant.id)
        findNavController().navigate(action)
    }
}