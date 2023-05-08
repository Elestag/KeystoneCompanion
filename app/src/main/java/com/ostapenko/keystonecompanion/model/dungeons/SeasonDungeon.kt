package com.ostapenko.keystonecompanion.model.dungeons

import com.ostapenko.keystonecompanion.R
import com.ostapenko.keystonecompanion.model.dungeons.boss.DungeonBossImpl


sealed class SeasonDungeon(val name: String, val imageResId: Int, val mPlus: Boolean = true) {
    object BrackenhideHollow :
        SeasonDungeon("Brackenhide Hollow", R.drawable.brackenhide_hollow_small) {
        val boss1 = DungeonBossImpl(
            R.string.hackclaws_war_band,
            R.drawable.creature_rira_hackclaw,
            R.string.description_hackclaws_war_band,
            R.string.tips_hackclaws_war_band
        )
        val boss2 = DungeonBossImpl(
            R.string.treemouth,
            R.drawable.creature_treemouth,
            R.string.description_treemouth,
            R.string.tips_treemouth
        )
        val boss3 = DungeonBossImpl(
            R.string.gutshot,
            R.drawable.creature_gutshot,
            R.string.description_gutshot,
            R.string.tips_gutshot
        )
        val boss4 = DungeonBossImpl(
            R.string.decatriarch_wratheye,
            R.drawable.creature_decatriarch_wratheye,
            R.string.description_decatriarch_wratheye,
            R.string.tips_decatriarch_wratheye
        )
    }

    object UldamanLegacyOfTyr :
        SeasonDungeon("Uldaman: Legacy of Tyr", R.drawable.uldaman_legacy_of_tyr_small) {
        val boss1 = DungeonBossImpl(
            R.string.the_lost_dwarves,
            R.drawable.creature_baelog,
            R.string.description_the_lost_dwarves,
            R.string.tips_the_lost_dwarves
        )
        val boss2 = DungeonBossImpl(
            R.string.bromach,
            R.drawable.creature_bromach,
            R.string.description_bromach,
            R.string.tips_bromach
        )
        val boss3 = DungeonBossImpl(
            R.string.sentinel_talondras,
            R.drawable.creature_sentinel_talondras,
            R.string.description_sentinel_talondras,
            R.string.tips_sentinel_talondras
        )
        val boss4 = DungeonBossImpl(
            R.string.emberon,
            R.drawable.creature_emberon,
            R.string.description_emberon,
            R.string.tips_emberon
        )
        val boss5 = DungeonBossImpl(
            R.string.chrono_lord_deios,
            R.drawable.creature_deios,
            R.string.description_chrono_lord_deios,
            R.string.tips_chrono_lord_deios
        )
    }

    object Neltharus : SeasonDungeon("Neltharus", R.drawable.neltharus_small) {
        val boss1 = DungeonBossImpl(
            R.string.chargath_bane_of_scales,
            R.drawable.creature_chargath,
            R.string.description_chargath_bane_of_scales,
            R.string.tips_chargath_bane_of_scales
        )
        val boss2 = DungeonBossImpl(
            R.string.forgemaster_gorek,
            R.drawable.creature_forgemaster_gorek,
            R.string.description_forgemaster_gorek,
            R.string.tips_forgemaster_gorek
        )
        val boss3 = DungeonBossImpl(
            R.string.magmatusk,
            R.drawable.creature_magmatusk,
            R.string.description_magmatusk,
            R.string.tips_magmatusk
        )
        val boss4 = DungeonBossImpl(
            R.string.warlord_sargha,
            R.drawable.creature_warlord_sargha,
            R.string.description_warlord_sargha,
            R.string.tips_warlord_sargha
        )
    }

    object HallsOfInfusion :
        SeasonDungeon("Halls of Infusion", R.drawable.halls_of_infusion_small) {
        val boss1 = DungeonBossImpl(
            R.string.watcher_irideus,
            R.drawable.creature_watcher_irideus,
            R.string.description_watcher_irideus,
            R.string.tips_watcher_irideus
        )
        val boss2 = DungeonBossImpl(
            R.string.gulping_goliath,
            R.drawable.creature_gulping_goliath,
            R.string.description_gulping_goliath,
            R.string.tips_gulping_goliath
        )
        val boss3 = DungeonBossImpl(
            R.string.khajin_the_unyielding,
            R.drawable.creature_khajin,
            R.string.description_khajin_the_unyielding,
            R.string.tips_khajin_the_unyielding
        )
        val boss4 = DungeonBossImpl(
            R.string.primal_tsunami,
            R.drawable.creature_primal_tsunami,
            R.string.description_primal_tsunami,
            R.string.tips_primal_tsunami
        )
    }

    object NeltarionsLair :
        SeasonDungeon("Neltharion\'s", R.drawable.neltharions_lair_small) {
        val boss1 = DungeonBossImpl(
            R.string.rokmora,
            R.drawable.creature_rokmora,
            R.string.description_rokmora,
            R.string.tips_rokmora
        )
        val boss2 = DungeonBossImpl(
            R.string.ularogg_cragshaper,
            R.drawable.creature_ularogg,
            R.string.description_ularogg_cragshaper,
            R.string.tips_ularogg_cragshaper
        )
        val boss3 = DungeonBossImpl(
            R.string.naraxas,
            R.drawable.creature_naraxas,
            R.string.description_naraxas,
            R.string.tips_naraxas
        )
        val boss4 = DungeonBossImpl(
            R.string.dargrul_the_underking,
            R.drawable.creature_dargrul,
            R.string.description_dargrul_the_underking,
            R.string.tips_dargrul_the_underking
        )
    }

    object TheUnderrot :
        SeasonDungeon("The Underrot", R.drawable.the_underrot_small) {
        val boss1 = DungeonBossImpl(
            R.string.elder_leaxa,
            R.drawable.creature_elder_leaxa,
            R.string.description_elder_leaxa,
            R.string.tips_elder_leaxa
        )
        val boss2 = DungeonBossImpl(
            R.string.cragmaw_the_infested,
            R.drawable.creature_cragmaw,
            R.string.description_cragmaw_the_infested,
            R.string.tips_cragmaw_the_infested
        )
        val boss3 = DungeonBossImpl(
            R.string.sporecaller_zancha,
            R.drawable.creature_sporecaller_zancha,
            R.string.description_sporecaller_zancha,
            R.string.tips_sporecaller_zancha
        )
        val boss4 = DungeonBossImpl(
            R.string.unbound_abomination,
            R.drawable.creature_unbound_abomination,
            R.string.description_unbound_abomination,
            R.string.tips_unbound_abomination
        )
    }

    object Freehold :
        SeasonDungeon("Freehold", R.drawable.freehold_small) {
        val boss1 = DungeonBossImpl(
            R.string.skycapn_kragg,
            R.drawable.creature_kragg,
            R.string.description_skycapn_kragg,
            R.string.tips_skycapn_kragg
        )
        val boss2 = DungeonBossImpl(
            R.string.council_o_captains,
            R.drawable.creature_eudora,
            R.string.description_council_o_captains,
            R.string.tips_council_o_captains
        )
        val boss3 = DungeonBossImpl(
            R.string.ring_of_booty,
            R.drawable.creature_shark_puncher,
            R.string.description_ring_of_booty,
            R.string.tips_ring_of_booty
        )
        val boss4 = DungeonBossImpl(
            R.string.harlan_sweete,
            R.drawable.creature_harlan,
            R.string.description_harlan_sweete,
            R.string.tips_harlan_sweete
        )
    }

    object TheVortexPinnacle : SeasonDungeon(
        "The Vortex Pinnacle",
        R.drawable.the_vortex_pinnacle_small
    ) {
        val boss1 = DungeonBossImpl(
            R.string.grand_vizier_ertan,
            R.drawable.creature_ertan,
            R.string.description_grand_vizier_ertan,
            R.string.tips_grand_vizier_ertan
        )
        val boss2 = DungeonBossImpl(
            R.string.altairus,
            R.drawable.creature_altairus,
            R.string.description_altairus,
            R.string.tips_altairus
        )
        val boss3 = DungeonBossImpl(
            R.string.asaad_caliph_of_zephyrs,
            R.drawable.creature_asaad,
            R.string.description_asaad_caliph_of_zephyrs,
            R.string.tips_asaad_caliph_of_zephyrs
        )
    }
}
