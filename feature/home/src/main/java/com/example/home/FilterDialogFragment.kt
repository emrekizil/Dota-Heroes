package com.example.home

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.home.databinding.FragmentFilterDialogBinding


class FilterDialogFragment : DialogFragment() {

    private lateinit var binding : FragmentFilterDialogBinding

    companion object {
        const val TAG = "FilterDialogFragment"
    }

   override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            binding = FragmentFilterDialogBinding.inflate(layoutInflater)
            builder.setView(binding.root)
            binding.checkButton.setOnClickListener {
                println("Emre")
                dismiss()
            }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }







}