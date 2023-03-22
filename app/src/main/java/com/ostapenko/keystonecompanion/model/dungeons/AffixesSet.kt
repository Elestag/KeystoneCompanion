package com.ostapenko.keystonecompanion.model.dungeons

import com.ostapenko.keystonecompanion.R

sealed class AffixesSet(val nameResId: Int, val imageResId: Int) {

    object Fortified : AffixesSet(R.string.affix_fortified, R.drawable.affix_fortified)
    object Tyrannical: AffixesSet(R.string.affix_tyrannical, R.drawable.affix_tyrannical)
    object Volcanic: AffixesSet(R.string.affix_volcanic, R.drawable.affix_volcanic)
    object Raging: AffixesSet(R.string.affix_raging, R.drawable.affix_raging)
    object Bolstering: AffixesSet(R.string.affix_bolstering, R.drawable.affix_bolstering)
    object Sanguine: AffixesSet(R.string.affix_sanguine, R.drawable.affix_sanguine)
    object Bursting: AffixesSet(R.string.affix_bursting, R.drawable.affix_bolstering)
    object Grievous: AffixesSet(R.string.affix_grievous, R.drawable.affix_grievous)
    object Explosive: AffixesSet(R.string.affix_explosive, R.drawable.affix_explosive)
    object Quaking: AffixesSet(R.string.affix_quaking, R.drawable.affix_quaking)
    object Spiteful: AffixesSet(R.string.affix_spiteful, R.drawable.affix_spiteful)
    object Storming: AffixesSet(R.string.affix_storming, R.drawable.affix_storming)
    object Thundering: AffixesSet(R.string.affix_thundering, R.drawable.affix_thundering)


}
