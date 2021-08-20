package com.example.foodDelivery.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodDelivery.databinding.FragmentFavoriteBinding
import com.example.foodDelivery.ui.home.HomeFragmentDirections
import com.example.foodDelivery.utils.gone
import com.example.foodDelivery.utils.room.entity.LocalRestaurant
import com.example.foodDelivery.utils.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment:Fragment(),IFavoriteListener {
    private val viewModel: FavoriteViewModel by viewModels()
    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!
    private var adapter: FavoriteRecyclerViewAdapter = FavoriteRecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        initViews()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getFavoriteList()
    }


    override fun onResume() {
        super.onResume()
        getFavoriteList()
    }

    private fun getFavoriteList() {
        viewModel.getFavoriteListLiveData().observe(viewLifecycleOwner,{
            if (it.isEmpty()){
                binding.apply {
                    noDataImageView.show()
                    noDataTextView.show()
                }
            }else{
                binding.apply {
                    noDataImageView.gone()
                    noDataTextView.gone()
                }
            }
            adapter.setRestaurantList(it,this)
        })
        viewModel.listFavorite()
    }


    private fun initViews() {
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

    override fun onClick(localRestaurant: LocalRestaurant) {
        val action = HomeFragmentDirections.actionHomeFragmentToRestaurantDetailFragment(localRestaurant.restaurantId)
        findNavController().navigate(action)
    }

    override fun onClickFavButton(localRestaurant: LocalRestaurant) {
        viewModel.removeFavorite(localRestaurant)
        getFavoriteList()
    }


}