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
import com.example.ui.extension.HEROATTRIBUTE
import com.example.ui.extension.reStateAllCheckbox
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilterDialogFragment : DialogFragment() {

    private lateinit var binding: FragmentFilterDialogBinding

    private val viewModel by viewModels<FilterDialogViewModel>()

    companion object {
        const val TAG = "FilterDialogFragment"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            binding = FragmentFilterDialogBinding.inflate(layoutInflater)
            builder.setView(binding.root)
            observeUiState()
            binding.checkButton.setOnClickListener {
                val listOfCheckBox = listOf(
                    binding.noneCheckbox,
                    binding.strengthCheckbox,
                    binding.agilityCheckbox,
                    binding.intelligenceCheckbox
                )
                val x: CheckBox? = returnCheckedBox(listOfCheckBox)
                viewModel.setHeroAttribute(x?.text.toString())
                dismiss()
            }
            binding.agilityCheckbox.reStateAllCheckbox(
                binding.intelligenceCheckbox,
                binding.strengthCheckbox,
                binding.noneCheckbox
            )
            binding.noneCheckbox.reStateAllCheckbox(
                binding.intelligenceCheckbox,
                binding.strengthCheckbox,
                binding.agilityCheckbox
            )
            binding.strengthCheckbox.reStateAllCheckbox(
                binding.intelligenceCheckbox,
                binding.agilityCheckbox,
                binding.noneCheckbox
            )
            binding.intelligenceCheckbox.reStateAllCheckbox(
                binding.agilityCheckbox,
                binding.strengthCheckbox,
                binding.noneCheckbox
            )
            val heroArgument = arguments?.getString("attribute")
            checkAttribute(heroArgument)
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")

    }

    fun observeUiState(){
        viewModel.getHeroAttribute()
        viewModel.heroAttribute.observe(this){
          //  println("güncellendi $it")
        }
    }


    private fun returnCheckedBox(listOfCheckBox: List<CheckBox>): CheckBox? {
        return listOfCheckBox.find { it.isChecked }
    }

    private fun checkAttribute(heroAttribute:String?){
        when(heroAttribute){
            HEROATTRIBUTE.STRENGTH.heroAttribute -> binding.strengthCheckbox.isChecked = true
            HEROATTRIBUTE.INTELLIGENCE.heroAttribute -> binding.intelligenceCheckbox.isChecked = true
            HEROATTRIBUTE.NONE.heroAttribute -> binding.noneCheckbox.isChecked = true
            HEROATTRIBUTE.AGILITY.heroAttribute -> binding.agilityCheckbox.isChecked = true
        }
    }

}