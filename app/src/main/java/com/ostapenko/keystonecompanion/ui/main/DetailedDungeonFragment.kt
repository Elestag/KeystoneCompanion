package com.ostapenko.keystonecompanion.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ostapenko.keystonecompanion.R
import com.ostapenko.keystonecompanion.model.dungeons.AddonDungeon
import com.ostapenko.keystonecompanion.model.dungeons.boss.DungeonBossImpl
import com.ostapenko.keystonecompanion.ui.theme.MyKeystoneTheme
import com.ostapenko.keystonecompanion.ui.theme.primaryBlack
import com.ostapenko.keystonecompanion.ui.theme.primaryWhite
import com.ostapenko.keystonecompanion.ui.theme.typography

class DetailedDungeonFragment : Fragment() {

    /*  private val binding by viewBinding { ItemDungeonDetailedRvBinding.bind(it) }
      private lateinit var myAdapter: DetailedItemAdapter
      private val mySnapHelper = PagerSnapHelper()*/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val args: DetailedDungeonFragmentArgs by navArgs()
        val dungeonName = args.dungNameArg

        return ComposeView(requireContext()).apply {
            setContent {
                val navController = findNavController()
                MyKeystoneTheme {
                    Surface {
                        DungeonBossDetailed(dungeonName, navController = navController)
                    }
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*   val args = arguments
           val name = args?.getString("name")


           if (name !== null) {

               binding.dungeonTextViewName.text = name
               binding.descriptionTextView.text = dungeonDescription(name)
               setDungeonImage(binding.dungeonImageView, name)
               myAdapter = DetailedItemAdapter(showDetailedDungeon(name))
               binding.detailedDungeonRecyclerView.apply {
                   adapter = myAdapter

               }
               mySnapHelper.attachToRecyclerView(binding.detailedDungeonRecyclerView)
           }*/

    }


}


private fun setDungeonDescription(name: String): Int {
    var description = R.string.description_azure_vault
    when (name) {
        "The Azure Vault" -> description = R.string.description_azure_vault
        "Algeth\'ar Academy" -> description = R.string.description_algethar_academy
        "Ruby Life Pools" -> R.string.description_ruby_life_pools
        "The Nokhud Offensive" -> description = R.string.description_the_nokhud_offensive
        "Brackenhide Hollow" -> description = R.string.description_brackenhide_hollow
        "Uldaman: Legacy of Tyr" -> description = R.string.description_uldaman_legacy_of_tyr
        "Neltharus" -> description = R.string.description_neltharus
        "Halls of Infusion" -> description = R.string.description_halls_of_infusion
    }
    return description
}


private fun setDungeonImage(name: String): Int {
    var image = R.drawable.the_azure_vault_small
    when (name) {
        "The Azure Vault" -> image = R.drawable.the_azure_vault_small
        "Algeth\'ar Academy" -> image = R.drawable.algethar_academy_small
        "Ruby Life Pools" -> image = R.drawable.ruby_life_pools_small
        "The Nokhud Offensive" -> image = R.drawable.the_nokhud_offensive_small
        "Brackenhide Hollow" -> image = R.drawable.brackenhide_hollow_small
        "Uldaman: Legacy of Tyr" -> image = R.drawable.uldaman_legacy_of_tyr_small
        "Neltharus" -> image = R.drawable.neltharus_small
        "Halls of Infusion" -> image = R.drawable.halls_of_infusion_small
    }
    return image
}

fun showDetailedDungeon(name: String): List<DungeonBossImpl> {
    var dungeonBosses = listOf<DungeonBossImpl>()
    when (name) {
        "The Azure Vault" -> dungeonBosses = listOf(
            AddonDungeon.TheAzureVault.boss1,
            AddonDungeon.TheAzureVault.boss2,
            AddonDungeon.TheAzureVault.boss3,
            AddonDungeon.TheAzureVault.boss4
        )

        "Algeth\'ar Academy" -> dungeonBosses = listOf(
            AddonDungeon.AlgetharAcademy.boss1,
            AddonDungeon.AlgetharAcademy.boss2,
            AddonDungeon.AlgetharAcademy.boss3,
            AddonDungeon.AlgetharAcademy.boss4
        )

        "Ruby Life Pools" -> dungeonBosses = listOf(
            AddonDungeon.RubyLifePools.boss1,
            AddonDungeon.RubyLifePools.boss2,
            AddonDungeon.RubyLifePools.boss3,
        )

        "The Nokhud Offensive" -> dungeonBosses = listOf(
            AddonDungeon.TheNokhudOffensive.boss1,
            AddonDungeon.TheNokhudOffensive.boss2,
            AddonDungeon.TheNokhudOffensive.boss3,
            AddonDungeon.TheNokhudOffensive.boss4
        )

        "Brackenhide Hollow" -> dungeonBosses = listOf(
            AddonDungeon.BrackenhideHollow.boss1,
            AddonDungeon.BrackenhideHollow.boss2,
            AddonDungeon.BrackenhideHollow.boss3,
            AddonDungeon.BrackenhideHollow.boss4
        )

        "Uldaman: Legacy of Tyr" -> dungeonBosses = listOf(
            AddonDungeon.UldamanLegacyOfTyr.boss1,
            AddonDungeon.UldamanLegacyOfTyr.boss2,
            AddonDungeon.UldamanLegacyOfTyr.boss3,
            AddonDungeon.UldamanLegacyOfTyr.boss4,
            AddonDungeon.UldamanLegacyOfTyr.boss5
        )

        "Neltharus" -> dungeonBosses = listOf(
            AddonDungeon.Neltharus.boss1,
            AddonDungeon.Neltharus.boss2,
            AddonDungeon.Neltharus.boss3,
            AddonDungeon.Neltharus.boss4
        )

        "Halls of Infusion" -> dungeonBosses = listOf(
            AddonDungeon.HallsOfInfusion.boss1,
            AddonDungeon.HallsOfInfusion.boss2,
            AddonDungeon.HallsOfInfusion.boss3,
            AddonDungeon.HallsOfInfusion.boss4
        )
    }
    return dungeonBosses
}


@Composable
fun DungeonBossDetailed(dungeonName: String, navController: NavController) {

    val bossList = showDetailedDungeon(dungeonName)
    LazyColumn {
        item {
            DungeonElement(
                dungeonName = setDungeonDescription(name = dungeonName),
                dungeonImage = setDungeonImage(name = dungeonName),
                navController = navController,
                isClickable = false
            )
        }

        itemsIndexed(bossList) { _, boss ->
            DungeonBossElement(
                bossNameId = boss.nameResId,
                bossImageId = boss.imageResId,
                bossDescriptionId = boss.descriptionResId,
                bossTipsId = boss.bossTips
            )

        }
    }
}

@Composable
fun DungeonBossElement(
    @StringRes bossNameId: Int,
    @DrawableRes bossImageId: Int,
    @StringRes bossDescriptionId: Int,
    @StringRes bossTipsId: Int,
    modifier: Modifier = Modifier
) {
    var isExpandedDescription by remember { mutableStateOf(false) }
    var isExpandedTips by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(color = primaryBlack)
            .padding(top = 10.dp, start = 16.dp, end = 16.dp)
    ) {
        Text(
            text = stringResource(id = bossNameId),
            style = typography.h2,
            color = primaryWhite
        )
        Image(
            painterResource(id = bossImageId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .height(300.dp)
                .padding(top = 10.dp)

        )
        Column(modifier = modifier) {
            Text(
                text = stringResource(id = bossDescriptionId),
                style = typography.h3,
                color = primaryWhite,
                maxLines = if (isExpandedDescription) Int.MAX_VALUE else 1,
            )
            TextButton(onClick = { isExpandedDescription = !isExpandedDescription }) {
                Text(
                    text = if (!isExpandedDescription) "Show more" else "Show less",
                    style = typography.button,
                    color = primaryWhite
                )
            }
        }
        //TODO this column has extra padding, idk why, fix later
        Column(modifier = modifier) {
            Text(
                text = stringResource(id = bossTipsId),
                style = typography.h3,
                color = primaryWhite,
                maxLines = if (isExpandedTips) Int.MAX_VALUE else 1
            )
            TextButton(onClick = { isExpandedTips = !isExpandedTips }) {
                Text(
                    text = if (!isExpandedTips) "Show more" else "Show less",
                    style = typography.button,
                    color = primaryWhite
                )
            }
        }

    }
}

/*
@Preview(showBackground = true)
@Composable
fun ShowDungeonDetailedPreview() {
    MyKeystoneTheme {
        DungeonBossDetailed(dungeonName = "Algeth\'ar Academy")
    }
}*/
