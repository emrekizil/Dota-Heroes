package com.example.data.mapper

import com.example.data.dto.DotaResponseItem
import javax.inject.Inject

class FilterHeroes @Inject constructor(){

    fun execute(
        heroes: List<DotaResponseItem>,
        heroName: String,
        heroAttribute: String?,
        sortingPref: String,
    ): List<DotaResponseItem> {

        var filteredList : MutableList<DotaResponseItem> = heroes.filter {
            it.localizedName.lowercase().contains(heroName.lowercase())
        }.toMutableList()

        when(sortingPref){

            "a" -> {
              filteredList = filteredList.sortedBy { it.localizedName }.toMutableList()
            }
            "z"-> {
               filteredList = filteredList.sortedByDescending { it.localizedName }.toMutableList()
            }
            "0" -> {
               filteredList = filteredList.sortedByDescending{ calculatePercentage(it.proWin,it.proPick) }.toMutableList()
            }
            "100"->{
                filteredList= filteredList.sortedBy { calculatePercentage(it.proWin,it.proPick) }.toMutableList()
            }
            else -> {
               filteredList = filteredList.sortedBy { it.localizedName }.toMutableList()
            }
        }

        filteredList = filteredList.filter {
            it.primaryAttr == heroAttribute
        }.toMutableList()

        return filteredList
    }
}