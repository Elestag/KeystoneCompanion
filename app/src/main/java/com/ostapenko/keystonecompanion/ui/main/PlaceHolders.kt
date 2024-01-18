package com.ostapenko.keystonecompanion.ui.main


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.RadioButton
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp

import com.ostapenko.keystonecompanion.R
import com.ostapenko.keystonecompanion.model.Region
import com.ostapenko.keystonecompanion.model.dungeons.AffixesSet
import com.ostapenko.keystonecompanion.ui.theme.MyKeystoneTheme
import com.ostapenko.keystonecompanion.ui.theme.shapes
import com.ostapenko.keystonecompanion.ui.theme.typography
import kotlinx.coroutines.launch


@Composable
fun CutoffsAndButtonsPlaceHolders(
    modifier: Modifier = Modifier
) {
    MyKeystoneTheme {
        Surface {
            Column {

                Spacer(modifier = modifier.height(60.dp))
                Row(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Select Region")
                    Spacer(modifier = Modifier.height(8.dp))

                    listOf(Region.US, Region.EU, Region.TW).forEach { region ->
                        Column {
                            RadioButton(
                                selected = false,
                                onClick = {
                                })
                            Text(
                                text = region.name,
                                modifier = Modifier.padding(start = 16.dp)
                            )
                        }
                    }
                }

                Column(
                    modifier = modifier
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Cutoffs rating",
                        style = typography.titleLarge
                    )
                    val ratingColor = androidx.compose.ui.graphics.Color.White
                    Text(
                        text = "N/A",
                        color = ratingColor,
                        style = typography.titleLarge
                    )
                    // Spacer(modifier = Modifier.height(30.dp))
                    Button(shape = shapes.large,
                        modifier = modifier
                            .width(180.dp)
                            .height(50.dp),
                        onClick = {

                        })
                    {
                        Text(
                            text = "Dungeons",
                            style = typography.titleMedium
                        )
                    }

                    //Spacer(modifier = modifier.height(20.dp))

                    val tyraForAffix = painterResource(id = AffixesSet.Fortified.imageResId)

                    val affixOne = painterResource(id = R.drawable.affix_volcanic)

                    val affixTwo = painterResource(id = R.drawable.affix_volcanic)

                    Column(
                        modifier = modifier,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Weekly M+ modifiers",
                            style = typography.titleLarge
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        ModifierImages(
                            tyraFortAffix = tyraForAffix,
                            affixOne = affixOne,
                            affixTwo = affixTwo
                        )
                    }
                }
            }

        }
    }

}

