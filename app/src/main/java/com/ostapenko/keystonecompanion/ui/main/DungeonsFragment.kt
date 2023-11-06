package com.ostapenko.keystonecompanion.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.ostapenko.keystonecompanion.R
import com.ostapenko.keystonecompanion.model.dungeons.AddonDungeon
import com.ostapenko.keystonecompanion.ui.theme.MyKeystoneTheme
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
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val navController = findNavController()
                DungeonsListColumn(dungeons = dungeonList, navController = navController)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}

@Composable
fun DungeonsListColumn(dungeons: List<AddonDungeon>, navController: NavController) {

    MyKeystoneTheme {
        Surface {
            LazyColumn {
                itemsIndexed(dungeons) { _, dungeon ->
                    DungeonElement(
                        dungeonName = dungeon.nameResId,
                        dungeonImage = dungeon.imageResId,
                        navController = navController
                    )
                }
            }
        }
    }
}

@Composable
fun DungeonElement(
    modifier: Modifier = Modifier,
    @StringRes dungeonName: Int,
    @DrawableRes dungeonImage: Int,
    navController: NavController,
    isClickable: Boolean = true
) {
    val dungeonNameString = stringResource(id = dungeonName)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(top = 10.dp)
    ) {
        Text(
            text = stringResource(id = dungeonName),
            style = typography.titleMedium,
            modifier = modifier.padding(10.dp)
        )
        Image(
            painterResource(id = dungeonImage),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .height(300.dp)
                .fillMaxWidth()
                .padding(top = 10.dp)
                .clickable {
                    if (isClickable) {
                        val bundle = bundleOf("dungNameArg" to dungeonNameString)
                        navController.navigate(
                            R.id.action_dungeonsFragment_to_detailedDungeonFragment,
                            bundle
                        )

                    }
                })
    }
}

