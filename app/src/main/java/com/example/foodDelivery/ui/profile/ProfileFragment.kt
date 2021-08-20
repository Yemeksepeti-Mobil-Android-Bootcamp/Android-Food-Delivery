package com.example.foodDelivery.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.foodDelivery.R
import com.example.foodDelivery.databinding.FragmentProfileBinding
import com.example.foodDelivery.ui.MainActivity
import com.example.foodDelivery.utils.room.entity.LocalUser
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment:Fragment() {
    private val viewModel:ProfileViewModel by viewModels()
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        getUser()
        return binding.root
    }

    private fun getUser() {
        viewModel.observeUserLiveData().observe(viewLifecycleOwner,{
            initViews(it)
        })

        viewModel.getProfileInformation()
    }

    private fun initViews(user: LocalUser) {
        binding.apply {
            profileNameTextView.text = user.name
            emailAddressTextView.text = user.email
            roleTextView.text = user.role
            logoutCardView.setOnClickListener{
                viewModel.logout(user)
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            }
            orderCardViews.setOnClickListener{
                findNavController().navigate(R.id.action_homeFragment_to_orderListFragment)
            }
            favoriteCardView.setOnClickListener{
                findNavController().navigate(R.id.action_homeFragment_to_favoriteFragment)
            }
        }

    }


}