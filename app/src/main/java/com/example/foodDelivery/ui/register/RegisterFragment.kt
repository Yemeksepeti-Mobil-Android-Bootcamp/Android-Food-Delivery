package com.example.foodDelivery.ui.register

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.foodDelivery.R
import com.example.foodDelivery.databinding.FragmentRegisterBinding
import com.example.foodDelivery.utils.Resource
import com.example.foodDelivery.utils.gone
import com.example.foodDelivery.utils.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private val viewModel: RegisterViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        setListener()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.registerButton.setOnClickListener {
            register()
        }
    }

    private fun register() {
        val email = binding.editTextTextEmailAddress.text.toString()
        val name = binding.editTextTextPersonName.text.toString()
        val password = binding.editTextTextPassword.text.toString()
        viewModel.register(email, name, password).observe(viewLifecycleOwner,{
            when(it.status){
                Resource.Status.LOADING -> {
                    binding.progressBar.show()
                }
                Resource.Status.SUCCESS -> {
                    binding.progressBar.gone()
                    findNavController().navigate(R.id.action_signUpFragment_to_homeFragment)
                }
                Resource.Status.ERROR -> {
                    binding.progressBar.gone()
                }
            }
        })
    }

    private fun setListener() {
        binding.loginButton.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_signInFragment)
        }
    }
}