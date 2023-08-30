package com.example.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.detail.databinding.FragmentDetailBinding
import com.example.ui.HeroUiData
import com.example.ui.extension.getHeroAttributeAllName
import com.example.ui.extension.getHeroPercentageAndColor
import com.example.ui.extension.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel

    private val args: DetailFragmentArgs by navArgs()

    private lateinit var binding:FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentDetailBinding.inflate(LayoutInflater.from(
            requireContext()
        ))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(args.heroUiData)
    }

    private fun setupView(heroUiData: HeroUiData) {
        binding.apply {
            heroTitleTextView.text = heroUiData.localizedName
            heroAttributeTextView.text = getHeroAttributeAllName(heroUiData.primaryAttr)
            heroImageView.loadImage("https://api.opendota.com"+ heroUiData.img)
            heroProWinsValueTextView.getHeroPercentageAndColor(heroUiData.proWinRate)
            heroTurboWinsValueTextView.getHeroPercentageAndColor(heroUiData.turboWinRate)
            heroAttackRangeValueTextView.text = heroUiData.attackRange.toString()
            heroHealthValueTextView.text = heroUiData.health.toString()
            heroMoveSpeedValueTextView.text = heroUiData.moveSpeed.toString()
            heroProjectileSpeedValueTextView.text = heroUiData.projectileSpeed.toString()
            heroAttackTypeTextView.text = heroUiData.attackType
            heroStrengthValueTextView.text = getString(com.example.ui.R.string.base_hero_stat_addition,heroUiData.baseStr.toString(),heroUiData.strGain.toString())
            heroAgilityValueTextView.text = getString(com.example.ui.R.string.base_hero_stat_addition,heroUiData.baseAgi.toString(),heroUiData.agiGain.toString())
            heroIntelligenceValueTextView.text = getString(com.example.ui.R.string.base_hero_stat_addition,heroUiData.baseInt.toString(),heroUiData.intGain.toString())
            heroAttackDamageValueTextView.text = getString(com.example.ui.R.string.base_hero_stat_addition,heroUiData.baseAttackMin.toString(),heroUiData.baseAttackMax.toString())
            heroIconImageView.loadImage("https://api.opendota.com"+ heroUiData.icon)
        }
    }
}