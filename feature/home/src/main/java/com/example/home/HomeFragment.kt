package com.example.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.home.databinding.FragmentHomeBinding
import com.example.ui.HomeUiData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val viewModel by viewModels<HomeViewModel>()

    private val adapter :HeroRecyclerViewAdapter by lazy {
        HeroRecyclerViewAdapter()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater).apply {
            heroListRecyclerView.adapter = adapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeUiState()
    }



    private fun observeUiState(){
        viewModel.getAllHero()
        viewModel.heroHomeUiState.observe(viewLifecycleOwner){
            when(it){
                is HomeUiState.Success->{
                    handleSuccessUiState(it.data)
                }
                is HomeUiState.Loading->{

                }
                is HomeUiState.Error->{

                }
            }
        }
    }

    private fun handleSuccessUiState(data: List<HomeUiData>) {
        adapter.updateItems(data)
    }




}