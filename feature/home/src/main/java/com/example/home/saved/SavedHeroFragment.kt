package com.example.home.saved

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.home.R

class SavedHeroFragment : Fragment() {

    companion object {
        fun newInstance() = SavedHeroFragment()
    }

    private lateinit var viewModel: SavedHeroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_saved_hero, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SavedHeroViewModel::class.java)
        // TODO: Use the ViewModel
    }

}