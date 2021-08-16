package com.example.foodDelivery.ui.signUp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.foodDelivery.R
import com.example.foodDelivery.databinding.FragmentSignupBinding

class SignUpFragment:Fragment() {
    private  var _binding:FragmentSignupBinding? = null
    private  val binding get() = _binding !!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        setListener()
        return binding.root
    }

    private fun setListener() {
        binding.loginButton.setOnClickListener{
            findNavController().navigate(R.id.action_signUpFragment_to_signInFragment)
        }
    }
}