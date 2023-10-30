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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment

import com.ostapenko.keystonecompanion.R
import com.ostapenko.keystonecompanion.databinding.ItemDungeonsRvBinding
import com.ostapenko.keystonecompanion.model.dungeons.AddonDungeon
import com.ostapenko.keystonecompanion.model.dungeons.DungeonsItemRV
import com.ostapenko.keystonecompanion.ui.base.viewBinding
import com.ostapenko.keystonecompanion.ui.main.adapters.DungeonsItemAdapter
import com.ostapenko.keystonecompanion.ui.theme.MyKeystoneTheme
import com.ostapenko.keystonecompanion.ui.theme.primaryBlack
import com.ostapenko.keystonecompanion.ui.theme.primaryWhite
import com.ostapenko.keystonecompanion.ui.theme.typography

class DungeonsFragment : Fragment() {


    private val dungeonList: List<AddonDungeon> = listOf(
        AddonDungeon.AlgetharAcademy,
        AddonDungeon.BrackenhideHollow,
        AddonDungeon.HallsOfInfusion,
        AddonDungeon.Neltharus,
        AddonDungeon.TheNokhudOffensive,
        AddonDungeon.RubyLifePools,
        AddonDungeon.TheAzureVault,
        AddonDungeon.UldamanLegacyOfTyr
    )

    /*private val binding by viewBinding { ItemDungeonsRvBinding.bind(it) }
    private val myAdapter = DungeonsItemAdapter(dungeonList)*/


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                DungeonsListColumn(dungeons = dungeonList)
            }
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      /*  binding.dungeonsRecyclerView.apply {
            adapter = myAdapter
        }*/


    }
}

@Composable
fun DungeonsListColumn(dungeons: List<AddonDungeon>) {

    MyKeystoneTheme {
        Surface {
            LazyColumn {
                itemsIndexed(dungeons) { index, dungeon ->
                    DungeonElement(
                        dungeonName = dungeon.nameResId,
                        dungeonImage = dungeon.imageResId
                    )
                }
            }
        }
    }
}

@Composable
fun DungeonElement(
    @StringRes dungeonName: Int,
    @DrawableRes dungeonImage: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(color = primaryBlack)
            .padding(top = 10.dp)
    ) {
        Text(
            text = stringResource(id = dungeonName),
            style = typography.h2,
            color = primaryWhite
        )
        Image(
            painterResource(id = dungeonImage),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .height(300.dp)
                .padding(top = 10.dp)

        )
    }
}

@Preview(showBackground = true)
@Composable
fun DungeonElementPreview() {
    MyKeystoneTheme {
        DungeonElement(
            dungeonName = AddonDungeon.AlgetharAcademy.nameResId,
            dungeonImage = AddonDungeon.AlgetharAcademy.imageResId
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DungeonsListColumnPreview() {

    val dungeonList: List<AddonDungeon> = listOf(
        AddonDungeon.AlgetharAcademy,
        AddonDungeon.BrackenhideHollow,
        AddonDungeon.HallsOfInfusion,
        AddonDungeon.Neltharus,
        AddonDungeon.TheNokhudOffensive,
        AddonDungeon.RubyLifePools,
        AddonDungeon.TheAzureVault,
        AddonDungeon.UldamanLegacyOfTyr
    )

    MyKeystoneTheme {
        DungeonsListColumn(dungeons = dungeonList)
    }
}

