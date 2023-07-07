package com.example.home

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.CheckBox
import androidx.fragment.app.DialogFragment
import com.example.home.databinding.FragmentFilterDialogBinding
import com.example.ui.extension.reStateAllCheckbox


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
                val listOfCheckBox= listOf(binding.noneCheckbox,binding.strengthCheckbox,binding.agilityCheckbox,binding.intelligenceCheckbox)
                val x:CheckBox? = returnCheckedBox(listOfCheckBox)
                dismiss()
            }
            binding.agilityCheckbox.reStateAllCheckbox(binding.intelligenceCheckbox,binding.strengthCheckbox,binding.noneCheckbox)
            binding.noneCheckbox.reStateAllCheckbox(binding.intelligenceCheckbox,binding.strengthCheckbox,binding.agilityCheckbox)
            binding.strengthCheckbox.reStateAllCheckbox(binding.intelligenceCheckbox,binding.agilityCheckbox,binding.noneCheckbox)
            binding.intelligenceCheckbox.reStateAllCheckbox(binding.agilityCheckbox,binding.strengthCheckbox,binding.noneCheckbox)
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    private fun returnCheckedBox(listOfCheckBox: List<CheckBox>): CheckBox? {
        return listOfCheckBox.find { it.isChecked }
    }


}