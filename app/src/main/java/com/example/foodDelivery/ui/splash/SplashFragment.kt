package com.example.foodDelivery.ui.splash

import android.animation.Animator
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.foodDelivery.R
import com.example.foodDelivery.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment:Fragment() {
    private  var _binding:FragmentSplashBinding ? = null
    private  val binding get() = _binding !!
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        animatorListener()
    }

    private fun animatorListener() {

        //Animation Listener
        binding.lottieAnimationView.addAnimatorListener(object: Animator.AnimatorListener{
            override fun onAnimationStart(animation: Animator?) {
                Log.v("Animation","Started")
            }

            override fun onAnimationEnd(animation: Animator?) {
                viewModel.observeNavigationLiveData().observe(viewLifecycleOwner,{
                    when (it) {
                        "auth" -> {
                            findNavController().navigate(R.id.action_splashFragment_to_signInFragment)
                        }
                        "onboarding" -> {
                            findNavController().navigate(R.id.action_splashFragment_to_onboardingMainFragment)
                        }
                    }
                })
                viewModel.checkOnboardingAndNavigation("onboarding")
            }
            override fun onAnimationCancel(animation: Animator?) {
                Log.v("Animation","Canceled")
            }

            override fun onAnimationRepeat(animation: Animator?) {
                Log.v("Animation","Repeated")
            }
        })
    }
}