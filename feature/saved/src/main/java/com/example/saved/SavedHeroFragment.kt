package com.example.saved

import android.app.ProgressDialog.show
import android.content.ClipData.Item
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.accessibility.AccessibilityEventCompat.setAction
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.saved.databinding.FragmentSavedHeroBinding
import com.example.ui.HeroUiData
import com.google.android.material.snackbar.Snackbar
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
        initView()
    }

    private fun initView() {
        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ){
            override fun getMovementFlags(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
            ): Int {
                val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
                val swipeFlags = ItemTouchHelper.START or ItemTouchHelper.END

                return makeMovementFlags(dragFlags, swipeFlags)
            }

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder,
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val hero = adapter.getItem(position)

                viewModel.deleteSavedHero(hero)

                Snackbar.make(view!!,"Successfully deleted hero",Snackbar.LENGTH_LONG).apply {
                    setAction("Undo"){
                        viewModel.saveHero(hero)
                    }
                    show()
                }
            }

        }

        ItemTouchHelper(itemTouchHelperCallback).apply {
            attachToRecyclerView(binding.savedHeroListRecyclerView)
        }
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