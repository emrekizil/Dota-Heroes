package com.example.home

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
import com.example.home.databinding.FragmentHomeBinding
import com.example.home.dialog.FilterDialogFragment
import com.example.home.dialog.FilterDialogViewModel
import com.example.ui.HeroUiData
import com.example.ui.extension.observeTextChanges
import com.example.ui.extension.okWith
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val viewModel by viewModels<HomeViewModel>()

    private val adapter :HeroRecyclerViewAdapter by lazy {
        HeroRecyclerViewAdapter{data ->
            adapterOnClick(data)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(LayoutInflater.from(
            requireContext()
        )).apply {
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
                viewModel.heroName = it
                viewModel.getAllHero()
            }.launchIn(lifecycleScope)
    }

    private fun observeUiState(){
        viewModel.getHeroAttribute()
        viewModel.getAllHero()
        viewModel.getSortingPreference()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.heroHomeUiState.collect{
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
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.heroAttributeNew.collect{
                    viewModel.heroAttribute = it
                    viewModel.getAllHero()
                }
            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.sortingPreference.collect{
                    viewModel.sortingPref = it
                    viewModel.getAllHero()
                }
            }
        }
    }

    private fun handleSuccessUiState(data: List<HeroUiData>) {
        adapter.updateItems(data)
    }
    private fun initView(){
        binding.optionsIcon.setOnClickListener {
            val filterDialogFragment = FilterDialogFragment()
            val args = Bundle()
            args.putString("attribute",viewModel.heroAttribute)
            args.putString("sorting",viewModel.sortingPref)
            filterDialogFragment.arguments = args
            filterDialogFragment.show(
                childFragmentManager, FilterDialogFragment.TAG
            )
        }
    }

    private fun adapterOnClick(data:HeroUiData){
        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(data)
        findNavController().navigate(action)
    }

    companion object{
        private const val MILLISECONDS = 200L
        private const val MINIMUM_SEARCH_LENGTH = -1
    }

}