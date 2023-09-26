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
import com.example.ui.extension.getHeroAttributeAbbreviation
import com.example.ui.extension.reStateAllCheckbox
import com.example.ui.extension.reStateAllCheckbox2
import com.example.ui.extension.reStateAllCheckbox3
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

            reStateAllCheckbox3(listOf(
                binding.intelligenceCheckbox,binding.agilityCheckbox,binding.noneCheckbox,binding.strengthCheckbox
            ) )

            reStateAllCheckbox3(listOf(binding.heroWinDescendingCheckbox,binding.heroWinAscendingCheckbox))
            reStateAllCheckbox3(listOf(binding.heroTitleDescendingCheckbox,binding.heroTitleAscendingCheckbox))


            binding.heroTitleCheckbox.setOnCheckedChangeListener { _, isChecked ->
                binding.heroTitleAscendingCheckbox.visibility = if (isChecked) View.VISIBLE else View.GONE
                binding.heroTitleDescendingCheckbox.visibility = if (isChecked) View.VISIBLE else View.GONE
               if (isChecked){
                   binding.proWinRateCheckbox.isChecked = false
               }
            }

            binding.proWinRateCheckbox.setOnCheckedChangeListener { _, isChecked ->
                binding.heroWinAscendingCheckbox.visibility = if (isChecked) View.VISIBLE else View.GONE
                binding.heroWinDescendingCheckbox.visibility = if (isChecked) View.VISIBLE else View.GONE
                if (isChecked){
                    binding.heroTitleCheckbox.isChecked = false
                }
            }

            val heroArgument = arguments?.getString("attribute")
            checkAttribute(heroArgument)
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")

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