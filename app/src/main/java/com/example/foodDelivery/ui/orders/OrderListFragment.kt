package com.example.foodDelivery.ui.orders

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodDelivery.data.entity.order.Order
import com.example.foodDelivery.databinding.FragmentOrderListBinding
import com.example.foodDelivery.utils.Resource
import com.example.foodDelivery.utils.gone
import com.example.foodDelivery.utils.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrderListFragment:Fragment() {

    private val viewModel: OrderListViewModel by viewModels()
    private var _binding:FragmentOrderListBinding?  = null
    private val binding get() = _binding!!
    private var adapter: OrderRecyclerViewAdapter = OrderRecyclerViewAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrderListBinding.inflate(inflater, container, false)
        initViews()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getOrderList()
    }
    fun setData(orders:List<Order>){
        adapter.setOrderList(orders)
    }

    private fun getOrderList() {
        viewModel.getOrderList().observe(viewLifecycleOwner, {
            when (it.status) {
                Resource.Status.LOADING -> {
                    binding.progressBar.show()
                }
                Resource.Status.SUCCESS -> {
                    binding.progressBar.gone()
                    setData(it.data!!.orderList)
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

    private fun initViews() {
        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = adapter
            backButton.setOnClickListener{
                findNavController().popBackStack()
            }
        }
    }



}