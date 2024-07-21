package com.okbatech.barbershop.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.okbatech.barbershop.R
import com.okbatech.barbershop.data.Category
import com.okbatech.barbershop.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), CategoryRecycler.CategoryListener {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var categoryAdapter: CategoryRecycler


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        categoryAdapter = CategoryRecycler(this)
        binding.recyclerCategories.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, true)
        binding.recyclerCategories.adapter = categoryAdapter
        val category1 = Category("1", "All")
        val category2 = Category("2", "Nails")
        val category3 = Category("3", "Makeup")
        val category4 = Category("4", "Lipstick")
        val category5 = Category("5", "Cream")
        val category6 = Category("6", "Haircut")
        val categories = listOf(
            category1,
            category2,
            category3,
            category4,
            category5,
            category6
        )

        categoryAdapter.setData(categories)
        return binding.root
    }

    override fun selectCategory(category: Category) {

    }

}