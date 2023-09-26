package com.example.ui.extension

import android.annotation.SuppressLint
import android.widget.CheckBox
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import coil.load
import coil.size.Scale
import com.example.ui.R
import com.example.ui.contract.AbstractTextWatcher
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.onStart


fun AppCompatEditText.observeTextChanges(): Flow<String> {
    return callbackFlow {
        val textWatcher = object : AbstractTextWatcher() {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                super.onTextChanged(s, start, before, count)
                trySend(s.toString())
            }
        }
        addTextChangedListener(textWatcher)
        awaitClose {
            removeTextChangedListener(textWatcher)
        }
    }.onStart {
        text?.let {
            emit(it.toString())
        }
    }

}

fun AppCompatImageView.loadImage(imageUrl: String) {
    load(imageUrl) {
        scale(Scale.FILL)
    }
}

fun CheckBox.reStateAllCheckbox(checkboxes:List<CheckBox>) {
    this.setOnCheckedChangeListener { compoundButton, isChecked ->
        if (isChecked) {
            checkboxes.forEach {
                it.isChecked=false
            }
        }
    }
}

fun reStateAllCheckbox2(checkboxes:List<CheckBox>) {
    checkboxes.forEach { checkbox ->
        checkbox.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked){
                val f =checkboxes.filter {
                    it != checkbox
                }

                f.forEach {
                    it.isChecked = false
                }
            }

        }
    }
}

fun reStateAllCheckbox3(checkboxes: List<CheckBox>) {
    checkboxes.forEachIndexed { index, checkbox ->
        checkbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                checkboxes.forEachIndexed { innerIndex, innerCheckbox ->
                    if (index != innerIndex) {
                        innerCheckbox.isChecked = false
                    }
                }
            }
        }
    }
}


fun AppCompatTextView.getHeroPercentageAndColor(heroWinRate: Int) {
    if (heroWinRate < 50) {
        setTextColor(ContextCompat.getColor(context, R.color.red))
    } else {
        setTextColor(ContextCompat.getColor(context, R.color.green))
    }
    text = "$heroWinRate%"
}

enum class HEROATTRIBUTE(val heroAttribute: String) {
    STRENGTH("Strength"),
    AGILITY("Agility"),
    INTELLIGENCE("Intelligence"),
    NONE("None")
}

fun getHeroAttributeAbbreviation(heroAttribute: String?): String =
    when (heroAttribute) {
        HEROATTRIBUTE.NONE.heroAttribute -> "all"
        HEROATTRIBUTE.AGILITY.heroAttribute -> "agi"
        HEROATTRIBUTE.INTELLIGENCE.heroAttribute -> "int"
        HEROATTRIBUTE.STRENGTH.heroAttribute -> "str"
        else -> ""
    }

fun getHeroAttributeAllName(heroAttribute: String): String =
    when (heroAttribute) {
        "all" -> HEROATTRIBUTE.NONE.heroAttribute
        "agi" -> HEROATTRIBUTE.AGILITY.heroAttribute
        "int" -> HEROATTRIBUTE.INTELLIGENCE.heroAttribute
        "str" -> HEROATTRIBUTE.STRENGTH.heroAttribute
        else -> ""
    }
