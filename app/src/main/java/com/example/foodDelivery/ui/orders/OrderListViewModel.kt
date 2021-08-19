package com.example.foodDelivery.ui.orders

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.foodDelivery.data.Repository
import com.example.foodDelivery.data.entity.order.OrderGetResponse
import com.example.foodDelivery.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OrderListViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    fun getOrderList():LiveData<Resource<OrderGetResponse>> = repository.getOrder()
}