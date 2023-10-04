package com.example.home.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels

import com.example.home.databinding.FragmentFilterDialogBinding
import com.example.ui.extension.HeroAttribute
import com.example.ui.extension.QueueAttribute
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

            reStateAllCheckbox(
                listOf(
                    binding.intelligenceCheckbox,
                    binding.agilityCheckbox,
                    binding.noneCheckbox,
                    binding.strengthCheckbox
                )
            )

            reStateAllCheckbox(
                listOf(
                    binding.heroWinDescendingCheckbox,
                    binding.heroWinAscendingCheckbox,
                    binding.heroTitleDescendingCheckbox,
                    binding.heroTitleAscendingCheckbox
                )
            )


            binding.heroTitleCheckbox.setOnCheckedChangeListener { _, isChecked ->
                binding.heroTitleAscendingCheckbox.visibility =
                    if (isChecked) View.VISIBLE else View.GONE
                binding.heroTitleDescendingCheckbox.visibility =
                    if (isChecked) View.VISIBLE else View.GONE
                if (isChecked) {
                    binding.proWinRateCheckbox.isChecked = false
                }
            }

            binding.proWinRateCheckbox.setOnCheckedChangeListener { _, isChecked ->
                binding.heroWinAscendingCheckbox.visibility =
                    if (isChecked) View.VISIBLE else View.GONE
                binding.heroWinDescendingCheckbox.visibility =
                    if (isChecked) View.VISIBLE else View.GONE
                if (isChecked) {
                    binding.heroTitleCheckbox.isChecked = false
                }
            }

            val heroArgument = arguments?.getString("attribute")
            val heroSortingPref = arguments?.getString("sorting")
            checkAttribute(heroArgument)
            checkSortingPref(heroSortingPref)

            val listOfPrimaryCheckBox = listOf(
                binding.noneCheckbox,
                binding.strengthCheckbox,
                binding.agilityCheckbox,
                binding.intelligenceCheckbox
            )

            val listOfQueueCheckBox = listOf(
                binding.heroWinAscendingCheckbox,
                binding.heroTitleAscendingCheckbox,
                binding.heroTitleDescendingCheckbox,
                binding.heroWinDescendingCheckbox
            )

            binding.checkButton.setOnClickListener {
                val primaryAttribute: CheckBox? = returnCheckedBox(listOfPrimaryCheckBox)
                viewModel.setHeroAttribute(primaryAttribute?.text.toString())
                val queueAttribute: CheckBox? = returnCheckedBox(listOfQueueCheckBox)
                val checkedQueueAttribute = returnCheckedValue(queueAttribute?.text.toString())
                viewModel.setSortingPreference(checkedQueueAttribute)
                dismiss()
            }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")

    }


    private fun returnCheckedBox(listOfCheckBox: List<CheckBox>): CheckBox? {
        return listOfCheckBox.find { it.isChecked }
    }

    private fun returnCheckedValue(sortAttribute: String): String {
        return when (sortAttribute) {
            "a -> z" -> QueueAttribute.ASCTITLE.queueAttribute
            "z -> a" -> QueueAttribute.DESCTITLE.queueAttribute
            "0% - 100%" -> QueueAttribute.ASCWIN.queueAttribute
            "100% - 0%" -> QueueAttribute.DESCWIN.queueAttribute
            else -> QueueAttribute.ASCTITLE.queueAttribute
        }
    }

    private fun checkAttribute(heroAttribute: String?) {
        when (heroAttribute) {
            HeroAttribute.STRENGTH.heroAttribute -> binding.strengthCheckbox.isChecked = true
            HeroAttribute.INTELLIGENCE.heroAttribute -> binding.intelligenceCheckbox.isChecked = true
            HeroAttribute.NONE.heroAttribute -> binding.noneCheckbox.isChecked = true
            HeroAttribute.AGILITY.heroAttribute -> binding.agilityCheckbox.isChecked = true
        }
    }

    private fun checkSortingPref(heroSortingPref: String?) {
        when(heroSortingPref){
            QueueAttribute.ASCTITLE.queueAttribute -> checkTitleCheckbox(binding.heroTitleAscendingCheckbox)
            QueueAttribute.DESCTITLE.queueAttribute -> checkTitleCheckbox( binding.heroTitleDescendingCheckbox)
            QueueAttribute.DESCWIN.queueAttribute -> checkWinCheckbox(binding.heroWinAscendingCheckbox)
            QueueAttribute.ASCWIN.queueAttribute -> checkWinCheckbox(binding.heroWinDescendingCheckbox)
        }
    }

    private fun checkTitleCheckbox(checkBox: CheckBox){
        binding.heroTitleCheckbox.isChecked = true
        checkBox.isChecked = true
    }
    private fun checkWinCheckbox(checkBox: CheckBox){
        binding.proWinRateCheckbox.isChecked = true
        checkBox.isChecked = true
    }

}