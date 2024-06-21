package com.exemple.capstone.activity.ui.profil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.exemple.capstone.R
import com.exemple.capstone.databinding.FragmentFoodBinding
import com.exemple.capstone.databinding.FragmentHomeBinding
import com.exemple.capstone.databinding.FragmentProfilBinding


class ProfilFragment : Fragment() {

    private var _binding: FragmentProfilBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfilBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        // Inisialisasi ViewModel
//        val foodViewModel = ViewModelProvider(this).get(FoodViewModel::class.java)

//        // Inisialisasi TextView dari binding
//        val textView: TextView = binding.textView  // Memastikan textHome ada di dalam fragment_food.xml

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