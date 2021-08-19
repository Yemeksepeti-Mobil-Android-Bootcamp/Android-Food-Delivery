package com.example.foodDelivery.ui.meal

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.foodDelivery.data.Repository
import com.example.foodDelivery.data.entity.meal.Meal
import com.example.foodDelivery.data.entity.meal.MealResponse
import com.example.foodDelivery.data.entity.order.OrderRequest
import com.example.foodDelivery.data.entity.order.OrderResponse
import com.example.foodDelivery.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MealDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: Repository
):ViewModel() {

    lateinit var meal: Meal

    fun getMeal(): LiveData<Resource<MealResponse>> {
      return  savedStateHandle.get<String>("mealId")!!.let {
            repository.getMealById(it)
        }
    }

    fun postOrder(mealId:String):LiveData<Resource<OrderResponse>> = repository.postOrder(
        OrderRequest(savedStateHandle.get<String>("restaurantId")!!,mealId)
    )
}