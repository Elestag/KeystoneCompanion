package com.ostapenko.keystonecompanion.model.dungeons

import com.ostapenko.keystonecompanion.R

sealed class AddonDungeon(val name: String, val imageResId: Int) {
    //TODO докачать картинки, сейчас сломаны ссылки
    object TheAzureVault : AddonDungeon("The Azure Vault", R.drawable.the_azure_vault_small)
    object AlgetharAcademy : AddonDungeon("Algeth'ar Academy", R.drawable.algethar_academy_small)
    object RubyLifePools : AddonDungeon("Ruby Life Pools", R.drawable.ruby_life_pools_small)
    object TheNokhudOffensive :
        AddonDungeon("The Nokhud Offensive", R.drawable.the_nokhud_offensive_small)

    object BrackenhideHollow :
        AddonDungeon("Brackenhide Hollow", R.drawable.the_azure_vault_small) // id 1196

    object UldamanLegacyOfTyr :
        AddonDungeon("Uldaman: Legacy of Tyr", R.drawable.the_azure_vault_small) // id 1197

    object Neltharus : AddonDungeon("Neltharus", R.drawable.the_azure_vault_small)// id 1199
    object HallsOfInfusion :
        AddonDungeon("Halls of Infusion", R.drawable.the_azure_vault_small)// id 1204

}