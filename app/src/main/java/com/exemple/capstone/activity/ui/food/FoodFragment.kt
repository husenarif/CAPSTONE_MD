package com.exemple.capstone.activity.ui.food

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.exemple.capstone.databinding.FragmentFoodBinding


class FoodFragment : Fragment() {

    private var _binding: FragmentFoodBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFoodBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        // Inisialisasi ViewModel
//        val foodViewModel = ViewModelProvider(this).get(FoodViewModel::class.java)
//
//        // Inisialisasi TextView dari binding
//        val textView: TextView = binding.textHome  // Memastikan textHome ada di dalam fragment_food.xml
//
//        // Observasi LiveData dari ViewModel
//        foodViewModel.text.observe(viewLifecycleOwner) { text ->
//            textView.text = text
//        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}