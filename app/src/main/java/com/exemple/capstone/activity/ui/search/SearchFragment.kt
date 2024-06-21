package com.exemple.capstone.activity.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.exemple.capstone.databinding.FragmentSearchBinding
import android.util.Log


class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private val searchViewModel: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Set up RecyclerView
        val adapter = SearchAdapter(listOf())
        binding.rvFood.layoutManager = LinearLayoutManager(context)
        binding.rvFood.adapter = adapter

        // Observe data from ViewModel
        searchViewModel.listUser.observe(viewLifecycleOwner, Observer { users ->
            users?.let {
                adapter.updateData(it)
            } ?: run {
                Log.e("SearchFragment", "User data is null")
            }
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


