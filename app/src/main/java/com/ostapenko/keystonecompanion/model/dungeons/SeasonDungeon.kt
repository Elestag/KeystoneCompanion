package com.ostapenko.keystonecompanion.model.dungeons

import com.ostapenko.keystonecompanion.R
import com.ostapenko.keystonecompanion.model.dungeons.boss.DungeonBossImpl

sealed class SeasonDungeon(val name: String, val imageResId: Int, val mPlus: Boolean = true) {
    object TheAzureVault :
        SeasonDungeon("The Azure Vault", R.drawable.the_azure_vault_small) // id 1203
    {
        val boss1 = DungeonBossImpl(
            R.string.leymor,
            R.drawable.creature_leymor,
            R.string.description_leymor
        )
        val boss2 = DungeonBossImpl(
            R.string.azureblade,
            R.drawable.creature_azureblade,
            R.string.description_azureblade
        )
        val boss3 = DungeonBossImpl(
            R.string.telash_greywing,
            R.drawable.creature_telash_greywing,
            R.string.description_telash_greywing
        )
        val boss4 = DungeonBossImpl(
            R.string.umbrelskul,
            R.drawable.creature_umbrelskul,
            R.string.description_umbrelskul
        )
    }

    object AlgetharAcademy :
        SeasonDungeon("Algeth'ar Academy", R.drawable.algethar_academy_small) // id 1201
    {
        val boss1 = DungeonBossImpl(
            R.string.vexamus,
            R.drawable.creature_vexamus,
            R.string.description_vexamus
        )
        val boss2 = DungeonBossImpl(
            R.string.crawth,
            R.drawable.creature_crawth,
            R.string.description_crawth
        )
        val boss3 = DungeonBossImpl(
            R.string.overgrown_ancient,
            R.drawable.creature_overgrown_ancient,
            R.string.description_overgrown_ancient
        )
        val boss4 = DungeonBossImpl(
            R.string.echo_of_doragosa,
            R.drawable.creature_echo_of_doragosa,
            R.string.description_echo_of_doragosa
        )
    }

    object RubyLifePools :
        SeasonDungeon("Ruby Life Pools", R.drawable.ruby_life_pools_small) // id 1202
    {
        val boss1 = DungeonBossImpl(
            R.string.melidrussa_chillworn,
            R.drawable.creature_melidrussa_chilworn,
            R.string.description_melidrussa_chillworn
        )
        val boss2 = DungeonBossImpl(
            R.string.kokia_blazehoof,
            R.drawable.creature_kokkia_blazehoof,
            R.string.description_kokia_blazehoof
        )
        val boss3 = DungeonBossImpl(
            R.string.kyrakka_and_erkhart_stormvein,
            R.drawable.creature_erkhart_stormvein,
            R.string.description_kyrakka_and_erkhart_stormvein
        )
    }

    object TheNokhudOffensive :
        SeasonDungeon("The Nokhud Offensive", R.drawable.the_nokhud_offensive_small) // id 1198
    {
        val boss1 = DungeonBossImpl(
            R.string.granyth,
            R.drawable.creature_granyth,
            R.string.description_granyth
        )
        val boss2 = DungeonBossImpl(
            R.string.the_raging_tempest,
            R.drawable.creature_raging_tempest,
            R.string.description_the_raging_tempest
        )
        val boss3 = DungeonBossImpl(
            R.string.teera_and_maruuk,
            R.drawable.creature_teera,
            R.string.description_teera_and_maruuk
        )
        val boss4 = DungeonBossImpl(
            R.string.balakar_khan,
            R.drawable.creature_balakar_khan,
            R.string.balakar_khan
        )
    }

    object CourtOfStars :
        SeasonDungeon("Court of Stars", R.drawable.court_of_stars_small)
    //"id": 800
    {
        val boss1 = DungeonBossImpl(
            R.string.patrol_captain_gerdo,
            R.drawable.creature_gerdo,
            R.string.description_patrol_captain_gerdo
        )
        val boss2 = DungeonBossImpl(
            R.string.talixae_flamewreath,
            R.drawable.creature_talixae,
            R.string.description_talixae_flamewreath
        )
        val boss3 = DungeonBossImpl(
            R.string.kyrakka_and_erkhart_stormvein,
            R.drawable.creature_erkhart_stormvein,
            R.string.description_kyrakka_and_erkhart_stormvein
        )
    }

    object HallsOfValor :
        SeasonDungeon("Halls of Valor", R.drawable.halls_of_valor_small)
    //"id": 721
    {
        val boss1 = DungeonBossImpl(
            R.string.hymdall,
            R.drawable.creature_hymdall,
            R.string.description_hymdall
        )
        val boss2 = DungeonBossImpl(
            R.string.hyrja,
            R.drawable.creature_hyrja,
            R.string.description_hyrja
        )
        val boss3 = DungeonBossImpl(
            R.string.fenryr,
            R.drawable.creature_fenryr,
            R.string.description_fenryr
        )
        val boss4 = DungeonBossImpl(
            R.string.god_King_skovald,
            R.drawable.creature_skovald,
            R.string.description_god_King_skovald
        )
        val boss5 = DungeonBossImpl(
            R.string.odyn,
            R.drawable.creature_odyn,
            R.string.description_odyn
        )
    }

    object TempleOfJadeSerpent :
        SeasonDungeon("Temple of the Jade Serpent", R.drawable.temple_of_the_jade_serpent_small)
    //"id": 313
    {
        val boss1 = DungeonBossImpl(
            R.string.wise_mari,
            R.drawable.creature_wise_mari,
            R.string.description_wise_mari
        )
        val boss2 = DungeonBossImpl(
            R.string.lorewalker_stonestep,
            R.drawable.creature_lorewalker,
            R.string.description_lorewalker_stonestep
        )
        val boss3 = DungeonBossImpl(
            R.string.liu_flameheart,
            R.drawable.creature_liu,
            R.string.description_liu_flameheart
        )
        val boss4 = DungeonBossImpl(
            R.string.sha_of_doubt,
            R.drawable.creature_sha_of_doubt,
            R.string.description_sha_of_doubt
        )
    }

    object ShadowmoonBurialGrounds : SeasonDungeon(
        "Shadowmoon Burial Grounds",
        R.drawable.shadowmoon_burial_grounds_small
    ) // id 537
    {
        val boss1 = DungeonBossImpl(
            R.string.sadana_bloodfury,
            R.drawable.creature_sadana,
            R.string.description_sadana_bloodfury
        )
        val boss2 = DungeonBossImpl(
            R.string.nhallish,
            R.drawable.creature_nhallish,
            R.string.description_nhallish
        )
        val boss3 = DungeonBossImpl(
            R.string.bonemaw,
            R.drawable.creature_bonemaw,
            R.string.description_bonemaw
        )
        val boss4 = DungeonBossImpl(
            R.string.nerzhul,
            R.drawable.creature_nerzhul,
            R.string.description_nerzhul
        )
    }

    //next season "name": "Neltharion's Lair",+
    //      "id": 767
//      "name": "The Underrot",+
    //      "id": 1022
//      "name": "Freehold",+
    //      "id": 1001
//   "name": "The Vortex Pinnacle",+
//      "id": 68


}
