package com.ostapenko.keystonecompanion.model.dungeons

import com.ostapenko.keystonecompanion.R

sealed class SeasonDungeon(val name: String, val imageResId: Int, val mPlus: Boolean = true) {
    object TheAzureVault :
        SeasonDungeon("The Azure Vault", R.drawable.the_azure_vault_small) // id 1203

    object AlgetharAcademy :
        SeasonDungeon("Algeth'ar Academy", R.drawable.algethar_academy_small) // id 1201

    object RubyLifePools :
        SeasonDungeon("Ruby Life Pools", R.drawable.ruby_life_pools_small) // id 1202

    object TheNokhudOffensive :
        SeasonDungeon("The Nokhud Offensive", R.drawable.the_nokhud_offensive_small) // id 1198

    object CourtOfStars :
        SeasonDungeon("Court of Stars", R.drawable.court_of_stars_small)
    //"id": 800

    object HallsOfValor :
        SeasonDungeon("Halls of Valor", R.drawable.halls_of_valor_small)
    //"id": 721

    object TempleOfJadeSerpent :
        SeasonDungeon("Temple of the Jade Serpent", R.drawable.temple_of_the_jade_serpent_small)
    //"id": 313

    object ShadowmoonBurialGrounds : SeasonDungeon(
        "Shadowmoon Burial Grounds",
        R.drawable.shadowmoon_burial_grounds_small
    ) // id 537


    //next season "name": "Neltharion's Lair",+
    //      "id": 767
//      "name": "The Underrot",+
    //      "id": 1022
//      "name": "Freehold",+
    //      "id": 1001
//   "name": "The Vortex Pinnacle",+
//      "id": 68


}
