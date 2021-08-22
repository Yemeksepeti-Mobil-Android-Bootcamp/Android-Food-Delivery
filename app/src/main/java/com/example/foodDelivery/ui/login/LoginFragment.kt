package com.example.foodDelivery.ui.login

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.foodDelivery.R
import com.example.foodDelivery.databinding.FragmentLoginBinding
import com.example.foodDelivery.utils.Resource
import com.example.foodDelivery.utils.gone
import com.example.foodDelivery.utils.show
import com.wajahatkarim3.easyvalidation.core.view_ktx.nonEmpty
import com.wajahatkarim3.easyvalidation.core.view_ktx.validator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        setSignUpButtonListener()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setLoginButtonListener()
    }

    private fun login() {
        val emailTextView = binding.editTextEmailAddress
        val passwordTextView = binding.editTextPassword
        if(validation()){
            val email = emailTextView.text.toString()
            val password = passwordTextView.text.toString()
        viewModel.login(email, password)
            .observe(viewLifecycleOwner, {
                when (it.status) {
                    Resource.Status.LOADING -> {
                        binding.progressBar.show()
                    }
                    Resource.Status.SUCCESS -> {
                        binding.progressBar.gone()
                        findNavController().navigate(R.id.action_signInFragment_to_homeFragment)
                    }
                    Resource.Status.ERROR -> {
                        binding.progressBar.gone()
                        val dialog = AlertDialog.Builder(context)
                            .setTitle("Error")
                            .setMessage("${it.message}")
                            .setPositiveButton("ok") { dialog, _ ->
                                dialog.dismiss()
                            }
                        dialog.show()
                    }
                }
            })}
        else{
            emailTextView.validator()
                .nonEmpty()
                .addErrorCallback {
                    emailTextView.error = it
                }.check()
            passwordTextView.validator()
                .nonEmpty()
                .addErrorCallback {
                    passwordTextView.error = it
                }.check()
        }
    }

    private fun setSignUpButtonListener() {
        binding.signUpButton.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
        }
    }
    private fun setLoginButtonListener() {
        binding.loginButton.setOnClickListener {
            login()
        }
    }
    private fun validation():Boolean{
        val emailTextView = binding.editTextEmailAddress
        val passwordTextView = binding.editTextPassword
        return emailTextView.nonEmpty() && passwordTextView.nonEmpty()
    }
}