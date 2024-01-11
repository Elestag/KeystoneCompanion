package com.ostapenko.keystonecompanion.ui.main


import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.RadioButton
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.ostapenko.keystonecompanion.R
import com.ostapenko.keystonecompanion.model.Region
import com.ostapenko.keystonecompanion.model.dungeons.AffixesSet
import com.ostapenko.keystonecompanion.ui.KeystoneApplication
import com.ostapenko.keystonecompanion.ui.theme.MyKeystoneTheme
import com.ostapenko.keystonecompanion.ui.theme.shapes
import com.ostapenko.keystonecompanion.ui.theme.typography
import com.ostapenko.keystonecompanion.viewmodel.main.NetworkViewModel
import com.ostapenko.keystonecompanion.viewmodel.main.NetworkViewModelFactory
import kotlinx.coroutines.launch


class MainFragment : Fragment() {

    private val viewModelFactory: NetworkViewModelFactory by lazy {
        NetworkViewModelFactory(
            (requireActivity().application as KeystoneApplication).dataStoreManager,
        )
    }
    private val viewModel: NetworkViewModel by viewModels { viewModelFactory }
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                navController = findNavController()
                Column(modifier = Modifier.fillMaxSize()) {
                    CompanionApp(viewModel, navController = navController)
                }
            }
        }
    }
}

//todo понять почему на андроид 9 не работает экран
@Composable
fun CutoffsAndButtons(
    modifier: Modifier = Modifier,
    viewModel: NetworkViewModel,
    navHostController: NavController
) {
    val cutoffs by viewModel.rating.collectAsState()
   /* Log.d(
        "cutoffs",
        "${cutoffs.size} = cutoffs.size, ${cutoffs[0]} = cutoffs[0], ${cutoffs[1]} = cutoffs[1]"
    )*/

    if (cutoffs.isNotEmpty()) {
           Log.d(
           "cutoffs",
           "${cutoffs.size} = cutoffs.size, ${cutoffs[0]} = cutoffs[0], ${cutoffs[1]} = cutoffs[1]"
       )
        Column(
            modifier = modifier
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            RegionSelection { selectedRegion ->
                viewModel.setRegion(selectedRegion)
            }
            Spacer(modifier = modifier.height(30.dp))
            Text(
                text = "Cutoffs rating",
                style = typography.titleLarge
            )
            Spacer(modifier = Modifier.height(10.dp))

            val ratingColor = if (cutoffs.size >= 2) {
                Color(android.graphics.Color.parseColor(cutoffs[1]))
            } else {
                Color.White
            }

            Text(
                text = cutoffs.getOrNull(0)?.substring(0, 4) ?: "N/A",
                color = ratingColor,
                style = typography.titleLarge
            )
            // Spacer(modifier = Modifier.height(30.dp))
            Button(shape = shapes.large,
                modifier = modifier
                    .width(180.dp)
                    .height(50.dp),
                onClick = {
                    navHostController.navigate(R.id.action_mainFragment_to_dungeonsFragment)
                })
            {
                Text(
                    text = "Dungeons",
                    style = typography.titleMedium
                )
            }

            Spacer(modifier = modifier.height(20.dp))
            WeeklyModifiers(modifier, viewModel)
        }
    }
}

@Composable
fun CutoffsAndButtonsNoInternet(modifier: Modifier, navHostController: NavController) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = modifier.height(30.dp))
        Text(
            text = "Cutoffs rating",
            style = typography.titleLarge
        )
        Spacer(modifier = Modifier.height(10.dp))
        val ratingColor = Color.White
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
                navHostController.navigate(R.id.action_mainFragment_to_dungeonsFragment)
            })
        {
            Text(
                text = "Dungeons",
                style = typography.titleMedium
            )
        }
    }
}

@Composable
fun WeeklyModifiers(modifier: Modifier = Modifier, viewModel: NetworkViewModel) {
    val affixes by viewModel.affixes.collectAsState()
//    Log.d("affixes", "${affixes[0]}=it[0], ${affixes[1]}=it[1], ${affixes[2]}=it[2]")
    val tyraForAffix =
        if (affixes.isNotEmpty() && affixes[0] == stringResource(id = AffixesSet.Tyrannical.nameResId)) {
            painterResource(id = AffixesSet.Tyrannical.imageResId)
        } else {
            painterResource(id = AffixesSet.Fortified.imageResId)
        }

    val affixOne = if (affixes[1].isNotEmpty()) {
        checkAffix(name = affixes[1])
    } else {
        painterResource(id = R.drawable.affix_volcanic)
    }

    val affixTwo = if (affixes[2].isNotEmpty()) {
        checkAffix(name = affixes[2])
    } else {
        painterResource(id = R.drawable.affix_volcanic)
    }

    Column(
        modifier = modifier
            .fillMaxSize(),
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

private val modifierSize = 56.dp

@Composable
fun ModifierImages(tyraFortAffix: Painter, affixOne: Painter?, affixTwo: Painter?) {
    Row(
        Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = tyraFortAffix,
            contentDescription = "Weekly modifier - $tyraFortAffix",
            Modifier
                .size(modifierSize)
                .clip(shape = shapes.small)
        )
        Image(
            painter = affixOne ?: painterResource(id = R.drawable.affix_tyrannical),
            contentDescription = "Weekly modifier - $affixOne",
            Modifier
                .size(modifierSize)
                .clip(shape = shapes.small)
        )
        Image(
            painter = affixTwo ?: painterResource(id = R.drawable.affix_tyrannical),
            contentDescription = "Weekly modifier - $affixTwo",
            Modifier
                .size(modifierSize)
                .clip(shape = shapes.small)
        )
    }
}

@Composable
fun CompanionApp(viewModel: NetworkViewModel, navController: NavController) {

    val connectivityManager =
        LocalContext.current.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    var isNetworkAvailable by remember { mutableStateOf(isNetworkAvailable(connectivityManager)) }
    MyKeystoneTheme {
        Surface {
            Scaffold(topBar = { CompanionTopAppBar() }
            ) { contPadding ->

                DisposableEffect(Unit) {
                    val callback = object : ConnectivityManager.NetworkCallback() {
                        override fun onAvailable(network: Network) {
                            isNetworkAvailable = true
                        }

                        override fun onLost(network: Network) {
                            isNetworkAvailable = false
                        }
                    }
                    connectivityManager.registerDefaultNetworkCallback(callback)
                    onDispose {
                        connectivityManager.unregisterNetworkCallback(callback)
                    }
                }
                if (isNetworkAvailable) {
                    CutoffsAndButtons(
                        modifier = Modifier.padding(contPadding),
                        viewModel = viewModel,
                        navHostController = navController
                    )

                } else {
                    CutoffsAndButtonsNoInternet(
                        modifier = Modifier.padding(contPadding),
                        navHostController = navController
                    )
                }
            }
        }

    }
}

@Composable
fun CompanionTopAppBar() {
    val appBarBackgroundColor = MaterialTheme.colorScheme.background
    TopAppBar(
        title = {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_keystone),
                    contentDescription = "App icon",
                    modifier = Modifier
                        .size(36.dp)
                        .clip(shape = shapes.medium)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Keystone Companion", style = typography.headlineLarge)
            }
        },
        backgroundColor = appBarBackgroundColor
    )
}

@Composable
fun RegionSelection(onRegionSelected: (Region) -> Unit) {
    val app = LocalContext.current.applicationContext as KeystoneApplication
    val selectedRegion by app.dataStoreManager.getSelectedRegion()
        .collectAsState(initial = null)
    val viewModelScope = rememberCoroutineScope()

    LaunchedEffect(selectedRegion) {
        selectedRegion?.let {
            app.dataStoreManager.saveSelectedRegion(it)
        }
    }
    Row(modifier = Modifier.padding(16.dp)) {
        Text(text = "Select Region")
        Spacer(modifier = Modifier.height(8.dp))

        listOf(Region.US, Region.EU, Region.TW).forEach { region ->
            Column {
                RadioButton(
                    selected = selectedRegion == region,
                    onClick = {
                        viewModelScope.launch {
                            onRegionSelected(region)
                            app.dataStoreManager.saveSelectedRegion(region)
                        }
                    })
                Text(
                    text = region.name,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}

@Composable
fun checkAffix(name: String): Painter {
    var affix = painterResource(id = R.drawable.affix_volcanic)
    when (name) {
        stringResource(AffixesSet.Volcanic.nameResId) -> affix =
            painterResource(R.drawable.affix_volcanic)

        stringResource(AffixesSet.Raging.nameResId) -> affix =
            painterResource(R.drawable.affix_raging)

        stringResource(AffixesSet.Bolstering.nameResId) -> affix =
            painterResource(R.drawable.affix_bolstering)

        stringResource(AffixesSet.Sanguine.nameResId) -> affix =
            painterResource(R.drawable.affix_sanguine)

        stringResource(AffixesSet.Bursting.nameResId) -> affix =
            painterResource(R.drawable.affix_bursting)

        stringResource(AffixesSet.Grievous.nameResId) -> affix =
            painterResource(R.drawable.affix_grievous)

        stringResource(AffixesSet.Explosive.nameResId) -> affix =
            painterResource(R.drawable.affix_explosive)

        stringResource(AffixesSet.Quaking.nameResId) -> affix =
            painterResource(R.drawable.affix_quaking)

        stringResource(AffixesSet.Spiteful.nameResId) -> affix =
            painterResource(R.drawable.affix_spiteful)

        stringResource(AffixesSet.Storming.nameResId) -> affix =
            painterResource(R.drawable.affix_storming)

        stringResource(AffixesSet.Entangling.nameResId) -> affix =
            painterResource(R.drawable.affix_entangling)

        stringResource(AffixesSet.Afflicted.nameResId) -> affix =
            painterResource(R.drawable.affix_afflicted)

        stringResource(AffixesSet.Incorporeal.nameResId) -> affix =
            painterResource(R.drawable.affix_incorporeal)

        stringResource(AffixesSet.Shielding.nameResId) -> affix =
            painterResource(R.drawable.affix_shielding)
    }
    return affix
}

fun isNetworkAvailable(connectivityManager: ConnectivityManager): Boolean {

    val network = connectivityManager.activeNetwork
    val capabilities = connectivityManager.getNetworkCapabilities(network)
    return capabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true
}
