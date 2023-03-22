package com.ostapenko.keystonecompanion.model.dungeons

import com.ostapenko.keystonecompanion.R
import com.ostapenko.keystonecompanion.model.dungeons.boss.DungeonBossImpl

sealed class AddonDungeon(val nameResId: Int, val imageResId: Int) {
    //TODO докачать картинки, сейчас сломаны ссылки
    object TheAzureVault :
        AddonDungeon(R.string.the_azure_vault, R.drawable.the_azure_vault_small)//id 1203
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
        AddonDungeon(R.string.algethar_academy, R.drawable.algethar_academy_small) // id 1201
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
        AddonDungeon(R.string.ruby_life_pools, R.drawable.ruby_life_pools_small)// id 1202
    {
        val boss1 = DungeonBossImpl(
            R.string.melidrussa_chillworn,
            R.drawable.creature_melidrussa_chilworn,
            R.string.description_melidrussa_chillworn,
            "Fucks tank up"
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
        AddonDungeon(
            R.string.the_nokhud_offensive,
            R.drawable.the_nokhud_offensive_small
        ) // id 1198
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

    object BrackenhideHollow :
        AddonDungeon(R.string.brackenhide_hollow, R.drawable.the_azure_vault_small) // id 1196
    {
        val boss1 = DungeonBossImpl(
            R.string.hackclaws_war_band,
            R.drawable.creature_rira_hackclaw,
            R.string.description_hackclaws_war_band
        )
        val boss2 = DungeonBossImpl(
            R.string.treemouth,
            R.drawable.creature_treemouth,
            R.string.description_treemouth
        )
        val boss3 = DungeonBossImpl(
            R.string.gutshot,
            R.drawable.creature_gutshot,
            R.string.description_gutshot
        )
        val boss4 = DungeonBossImpl(
            R.string.decatriarch_wratheye,
            R.drawable.creature_decatriarch_wratheye,
            R.string.description_decatriarch_wratheye
        )
    }

    object UldamanLegacyOfTyr :
        AddonDungeon(R.string.uldaman_legacy_of_tyr, R.drawable.the_azure_vault_small) // id 1197
    {
        val boss1 = DungeonBossImpl(
            R.string.the_lost_dwarves,
            R.drawable.creature_baelog,
            R.string.description_the_lost_dwarves
        )
        val boss2 = DungeonBossImpl(
            R.string.bromach,
            R.drawable.creature_bromach,
            R.string.description_bromach
        )
        val boss3 = DungeonBossImpl(
            R.string.sentinel_talondras,
            R.drawable.creature_sentinel_talondras,
            R.string.description_sentinel_talondras
        )
        val boss4 = DungeonBossImpl(
            R.string.emberon,
            R.drawable.creature_emberon,
            R.string.description_emberon
        )
        val boss5 = DungeonBossImpl(
            R.string.chrono_lord_deios,
            R.drawable.creature_deios,
            R.string.description_chrono_lord_deios
        )
    }

    object Neltharus : AddonDungeon(R.string.neltharus, R.drawable.the_azure_vault_small)// id 1199
    {
        val boss1 = DungeonBossImpl(
            R.string.chargath_bane_of_scales,
            R.drawable.creature_chargath,
            R.string.description_chargath_bane_of_scales
        )
        val boss2 = DungeonBossImpl(
            R.string.forgemaster_gorek,
            R.drawable.creature_forgemaster_gorek,
            R.string.description_forgemaster_gorek
        )
        val boss3 = DungeonBossImpl(
            R.string.magmatusk,
            R.drawable.creature_magmatusk,
            R.string.description_magmatusk
        )
        val boss4 = DungeonBossImpl(
            R.string.warlord_sargha,
            R.drawable.creature_warlord_sargha,
            R.string.description_warlord_sargha
        )
    }

    object HallsOfInfusion :
        AddonDungeon(R.string.halls_of_infusion, R.drawable.the_azure_vault_small)// id 1204
    {
        val boss1 = DungeonBossImpl(
            R.string.watcher_irideus,
            R.drawable.creature_watcher_irideus,
            R.string.description_watcher_irideus
        )
        val boss2 = DungeonBossImpl(
            R.string.gulping_goliath,
            R.drawable.creature_gulping_goliath,
            R.string.description_gulping_goliath
        )
        val boss3 = DungeonBossImpl(
            R.string.khajin_the_unyielding,
            R.drawable.creature_khajin,
            R.string.description_khajin_the_unyielding
        )
        val boss4 = DungeonBossImpl(
            R.string.primal_tsunami,
            R.drawable.creature_primal_tsunami,
            R.string.description_primal_tsunami
        )
    }

}