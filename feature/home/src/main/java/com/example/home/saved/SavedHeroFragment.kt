package com.example.home.saved

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.home.R
import com.example.home.databinding.FragmentHomeBinding
import com.example.home.databinding.FragmentSavedHeroBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SavedHeroFragment : Fragment() {

    private val viewModel by viewModels<SavedHeroViewModel>()

    private lateinit var binding:FragmentSavedHeroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSavedHeroBinding.inflate(LayoutInflater.from(
            requireContext()
        ))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }



}