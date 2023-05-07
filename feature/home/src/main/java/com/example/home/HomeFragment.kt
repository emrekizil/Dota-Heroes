package com.example.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.home.databinding.FragmentHomeBinding
import com.example.ui.HomeUiData
import com.example.ui.extension.observeTextChanges
import com.example.ui.extension.okWith
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.*


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
        observeTextChanges()
        observeUiState()
        initView()
    }

    private fun observeTextChanges() {
        binding.searchEditText.observeTextChanges()
            .filter { it okWith MINIMUM_SEARCH_LENGTH }
            .debounce(MILLISECONDS)
            .distinctUntilChanged()
            .onEach {
                viewModel.getAllHero()
            }.launchIn(lifecycleScope)
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
    private fun initView(){
        binding.optionsIcon.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToFilterDialogFragment()
            findNavController().navigate(action)
        }
    }

    companion object{
        private const val MILLISECONDS = 200L
        private const val MINIMUM_SEARCH_LENGTH = 1
    }




}