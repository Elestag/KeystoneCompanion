package com.ostapenko.keystonecompanion.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ostapenko.keystonecompanion.R
import com.ostapenko.keystonecompanion.databinding.FragmentMainBinding
import com.ostapenko.keystonecompanion.model.dungeons.AffixesSet
import com.ostapenko.keystonecompanion.ui.base.viewBinding
import com.ostapenko.keystonecompanion.viewmodel.main.AffixesViewModel


class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewBinding { FragmentMainBinding.bind(it) }
    private val viewModel = AffixesViewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TODO сделать ретрофит с рейдер ио для отображения цены жетона (или вовхед)


        viewModel.myData.observe(viewLifecycleOwner) {
            binding.tokenPrice.text = getString(AffixesSet.Tyrannical.nameResId)
            val tyraFortAffix = it[0].replace("[", "").replace("]", "")
            val seasonAffix = it[3].replace("[", "").replace("]", "")
            val oneAffix = it[1].replace("[", "").replace("]", "")
            val twoAffix = it[2].replace("[", "").replace("]", "")
            checkTyraFortAffix(tyraFortAffix)
            checkAffixOne(oneAffix)
            checkAffixTwo(twoAffix)
            binding.seasonAffix.setImageResource(R.drawable.affix_thundering)
        }
        /*binding.affixOne.setImageResource(R.drawable.affix_spiteful)
        binding.affixTwo.setImageResource(R.drawable.affix_grievous)

        binding.tyraFortAffix.setImageResource(R.drawable.affix_fortified)*/

        binding.dungeonsButton.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.container, DungeonsFragment())
                ?.addToBackStack("MainFragment")
                ?.commit()
        }

        binding.mythicButton.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.container, MplusFragment())
                ?.addToBackStack("MainFragment")
                ?.commit()
        }
    }

    private fun checkTyraFortAffix(name: String){
        if (name == getString(AffixesSet.Tyrannical.nameResId)){
            binding.tyraFortAffix.setImageResource(R.drawable.affix_tyrannical)
        }else{
            binding.tyraFortAffix.setImageResource(R.drawable.affix_fortified)
        }
    }

    private fun checkAffixOne(name: String){
        when(name){
            getString(AffixesSet.Volcanic.nameResId) -> binding.affixOne.setImageResource(R.drawable.affix_volcanic)
            getString(AffixesSet.Raging.nameResId) -> binding.affixOne.setImageResource(R.drawable.affix_raging)
            getString(AffixesSet.Bolstering.nameResId) -> binding.affixOne.setImageResource(R.drawable.affix_bolstering)
            getString(AffixesSet.Sanguine.nameResId) -> binding.affixOne.setImageResource(R.drawable.affix_sanguine)
            getString(AffixesSet.Bursting.nameResId) -> binding.affixOne.setImageResource(R.drawable.affix_bursting)
            getString(AffixesSet.Grievous.nameResId) -> binding.affixOne.setImageResource(R.drawable.affix_grievous)
            getString(AffixesSet.Explosive.nameResId) -> binding.affixOne.setImageResource(R.drawable.affix_explosive)
            getString(AffixesSet.Quaking.nameResId) -> binding.affixOne.setImageResource(R.drawable.affix_quaking)
            getString(AffixesSet.Spiteful.nameResId) -> binding.affixOne.setImageResource(R.drawable.affix_spiteful)
            getString(AffixesSet.Storming.nameResId) -> binding.affixOne.setImageResource(R.drawable.affix_storming)
        }
    }
    private fun checkAffixTwo(name: String){
        when(name){
            getString(AffixesSet.Volcanic.nameResId) -> binding.affixTwo.setImageResource(R.drawable.affix_volcanic)
            getString(AffixesSet.Raging.nameResId) -> binding.affixTwo.setImageResource(R.drawable.affix_raging)
            getString(AffixesSet.Bolstering.nameResId) -> binding.affixTwo.setImageResource(R.drawable.affix_bolstering)
            getString(AffixesSet.Sanguine.nameResId) -> binding.affixTwo.setImageResource(R.drawable.affix_sanguine)
            getString(AffixesSet.Bursting.nameResId) -> binding.affixTwo.setImageResource(R.drawable.affix_bursting)
            getString(AffixesSet.Grievous.nameResId) -> binding.affixTwo.setImageResource(R.drawable.affix_grievous)
            getString(AffixesSet.Explosive.nameResId) -> binding.affixTwo.setImageResource(R.drawable.affix_explosive)
            getString(AffixesSet.Quaking.nameResId) -> binding.affixTwo.setImageResource(R.drawable.affix_quaking)
            getString(AffixesSet.Spiteful.nameResId) -> binding.affixTwo.setImageResource(R.drawable.affix_spiteful)
            getString(AffixesSet.Storming.nameResId) -> binding.affixTwo.setImageResource(R.drawable.affix_storming)
        }
    }
}