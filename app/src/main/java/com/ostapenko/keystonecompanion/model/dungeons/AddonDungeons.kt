package com.ostapenko.keystonecompanion.model.dungeons

import com.ostapenko.keystonecompanion.R
import com.ostapenko.keystonecompanion.model.dungeons.boss.DungeonBossImpl

sealed class AddonDungeon(val nameResId: Int, val imageResId: Int) {
    //TODO докачать картинки, сейчас сломаны ссылки
    object TheAzureVault :
        AddonDungeon(R.string.the_azure_vault, R.drawable.the_azure_vault_small)//id 1203
     {
        val boss1 = DungeonBossImpl(R.string.leymor, R.drawable.creature_leymor, R.string.description_leymor)
        val boss2 = DungeonBossImpl(R.string.azureblade, R.drawable.creature_azureblade, R.string.description_azureblade)
        val boss3 = DungeonBossImpl(R.string.telash_greywing, R.drawable.creature_telash_greywing, R.string.description_telash_greywing)
        val boss4 = DungeonBossImpl(R.string.umbrelskul, R.drawable.creature_umbrelskul, R.string.description_umbrelskul)
    }

    object AlgetharAcademy :
        AddonDungeon(R.string.algethar_academy, R.drawable.algethar_academy_small) // id 1201
    {
        val boss1 = DungeonBossImpl(R.string.vexamus, R.drawable.creature_vexamus, R.string.description_vexamus)
        val boss2 = DungeonBossImpl(R.string.crawth, R.drawable.creature_crawth, R.string.description_crawth)
        val boss3 = DungeonBossImpl(R.string.overgrown_ancient, R.drawable.creature_overgrown_ancient, R.string.description_overgrown_ancient)
        val boss4 = DungeonBossImpl(R.string.echo_of_doragosa, R.drawable.creature_echo_of_doragosa, R.string.description_echo_of_doragosa)
        }

    object RubyLifePools : AddonDungeon(R.string.ruby_life_pools, R.drawable.ruby_life_pools_small)// id 1202
    {

    }
    object TheNokhudOffensive :
        AddonDungeon(R.string.the_nokhud_offensive, R.drawable.the_nokhud_offensive_small) // id 1198

    object BrackenhideHollow :
        AddonDungeon(R.string.brackenhide_hollow, R.drawable.the_azure_vault_small) // id 1196

    object UldamanLegacyOfTyr :
        AddonDungeon(R.string.uldaman_legacy_of_tyr, R.drawable.the_azure_vault_small) // id 1197

    object Neltharus : AddonDungeon(R.string.neltharus, R.drawable.the_azure_vault_small)// id 1199
    object HallsOfInfusion :
        AddonDungeon(R.string.halls_of_infusion, R.drawable.the_azure_vault_small)// id 1204

}