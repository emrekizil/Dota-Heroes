package com.example.home.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.example.home.databinding.FragmentFilterDialogBinding
import com.example.ui.extension.reStateAllCheckbox
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilterDialogFragment : DialogFragment() {

    private lateinit var binding : FragmentFilterDialogBinding

    private val viewModel by viewModels<FilterDialogViewModel>()
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
                viewModel.setHeroAttribute(x?.text.toString())
                dismiss()
            }
            binding.agilityCheckbox.reStateAllCheckbox(binding.intelligenceCheckbox,binding.strengthCheckbox,binding.noneCheckbox)
            binding.noneCheckbox.reStateAllCheckbox(binding.intelligenceCheckbox,binding.strengthCheckbox,binding.agilityCheckbox)
            binding.strengthCheckbox.reStateAllCheckbox(binding.intelligenceCheckbox,binding.agilityCheckbox,binding.noneCheckbox)
            binding.intelligenceCheckbox.reStateAllCheckbox(binding.agilityCheckbox,binding.strengthCheckbox,binding.noneCheckbox)
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")

    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        println("emre")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeState()
    }

    private fun observeState() {
        viewModel.getHeroAttribute()
        viewModel.heroAttribute.observe(viewLifecycleOwner){
            println(it.toString())

        }
    }

    private fun returnCheckedBox(listOfCheckBox: List<CheckBox>): CheckBox? {
        return listOfCheckBox.find { it.isChecked }
    }

}