package com.example.saved

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.saved.databinding.FragmentSavedHeroBinding
import com.example.ui.HeroUiData
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SavedHeroFragment : Fragment() {

    private val viewModel by viewModels<SavedHeroViewModel>()

    private val adapter : SavedHeroRecyclerViewAdapter by lazy {
        SavedHeroRecyclerViewAdapter { data ->
            onClickItem(data)
        }
    }



    private lateinit var binding:FragmentSavedHeroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSavedHeroBinding.inflate(LayoutInflater.from(
            requireContext()
        )).apply {
            savedHeroListRecyclerView.adapter = adapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeUiState()
    }

    private fun observeUiState() {
        viewModel.getSavedHeroes()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.savedHeroUiState.collect{
                    when(it){
                        is SavedHeroUiState.Success -> {
                            handleSuccessUiData(it.data)
                        }
                        is SavedHeroUiState.Loading -> {

                        }
                        is SavedHeroUiState.Error ->{

                        }
                    }
                }
            }
        }
    }

    private fun handleSuccessUiData(data: List<HeroUiData>) {
        adapter.updateItems(data)
    }


    private fun onClickItem(data: HeroUiData) {
        val action = SavedHeroFragmentDirections.actionSavedHeroFragmentToDetailFragment(data)
        findNavController().navigate(action)
    }

}