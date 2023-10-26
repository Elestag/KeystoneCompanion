package com.ostapenko.keystonecompanion.ui.main


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.compose.rememberNavController
import com.ostapenko.keystonecompanion.R
import com.ostapenko.keystonecompanion.ui.theme.MyKeystoneTheme
import com.ostapenko.keystonecompanion.viewmodel.main.NetworkViewModel


class MainFragment : Fragment() {

    private val viewModel = NetworkViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                CompanionApp()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*  viewModel.myData.observe(viewLifecycleOwner) {
               Log.d("Affix","${it[0]}=it[0], ${it[1]}=it[1], ${it[2]}=it[2]")
                checkTyraFortAffix(it[0])
                checkAffixOne(it[1])
                checkAffixTwo(it[2])
          }*/

        /* viewModel.rating.observe(viewLifecycleOwner){
             binding.cutoffsRatingSeason.text = it[0]
             val color = Color.parseColor(it[1])
             binding.cutoffsRatingSeason.setTextColor(color)
         }

         binding.dungeonsButton.setOnClickListener {
             val transaction = activity?.supportFragmentManager?.beginTransaction()
             transaction?.replace(R.id.container, DungeonsFragment())
                 ?.addToBackStack("MainFragment")
                 ?.commit()
         }

         binding.mythicButton.setOnClickListener {
             val transaction = activity?.supportFragmentManager?.beginTransaction()
             transaction?.replace(R.id.container, MplusFragment())
                 ?.addToBackStack("MainFragment")
                 ?.commit()
         }*/

    }

    /*private fun checkTyraFortAffix(name: String) {
        if (name == getString(AffixesSet.Tyrannical.nameResId)) {
            binding.tyraFortAffix.setImageResource(R.drawable.affix_tyrannical)
        } else {
            binding.tyraFortAffix.setImageResource(R.drawable.affix_fortified)
        }
    }

    private fun checkAffixOne(name: String) {
        when (name) {
            getString(AffixesSet.Volcanic.nameResId) -> binding.affixOne.setImageResource(R.drawable.affix_volcanic)
            getString(AffixesSet.Raging.nameResId) -> binding.affixOne.setImageResource(R.drawable.affix_raging)
            getString(AffixesSet.Bolstering.nameResId) -> binding.affixOne.setImageResource(R.drawable.affix_bolstering)
            getString(AffixesSet.Sanguine.nameResId) -> binding.affixOne.setImageResource(R.drawable.affix_sanguine)
            getString(AffixesSet.Bursting.nameResId) -> binding.affixOne.setImageResource(R.drawable.affix_bursting)
            getString(AffixesSet.Grievous.nameResId) -> binding.affixOne.setImageResource(R.drawable.affix_grievous)
            getString(AffixesSet.Explosive.nameResId) -> binding.affixOne.setImageResource(R.drawable.affix_explosive)
            getString(AffixesSet.Quaking.nameResId) -> binding.affixOne.setImageResource(R.drawable.affix_quaking)
            getString(AffixesSet.Spiteful.nameResId) -> binding.affixOne.setImageResource(R.drawable.affix_spiteful)
            getString(AffixesSet.Storming.nameResId) -> binding.affixOne.setImageResource(R.drawable.affix_storming)
            getString(AffixesSet.Entangling.nameResId) -> binding.affixOne.setImageResource(R.drawable.affix_entangling)
            getString(AffixesSet.Afflicted.nameResId) -> binding.affixOne.setImageResource(R.drawable.affix_afflicted)
            getString(AffixesSet.Incorporeal.nameResId) -> binding.affixOne.setImageResource(R.drawable.affix_incorporeal)
            getString(AffixesSet.Shielding.nameResId) -> binding.affixOne.setImageResource(R.drawable.affix_shielding)
        }
    }

    private fun checkAffixTwo(name: String) {
        when (name) {
            getString(AffixesSet.Volcanic.nameResId) -> binding.affixTwo.setImageResource(R.drawable.affix_volcanic)
            getString(AffixesSet.Raging.nameResId) -> binding.affixTwo.setImageResource(R.drawable.affix_raging)
            getString(AffixesSet.Bolstering.nameResId) -> binding.affixTwo.setImageResource(R.drawable.affix_bolstering)
            getString(AffixesSet.Sanguine.nameResId) -> binding.affixTwo.setImageResource(R.drawable.affix_sanguine)
            getString(AffixesSet.Bursting.nameResId) -> binding.affixTwo.setImageResource(R.drawable.affix_bursting)
            getString(AffixesSet.Grievous.nameResId) -> binding.affixTwo.setImageResource(R.drawable.affix_grievous)
            getString(AffixesSet.Explosive.nameResId) -> binding.affixTwo.setImageResource(R.drawable.affix_explosive)
            getString(AffixesSet.Quaking.nameResId) -> binding.affixTwo.setImageResource(R.drawable.affix_quaking)
            getString(AffixesSet.Spiteful.nameResId) -> binding.affixTwo.setImageResource(R.drawable.affix_spiteful)
            getString(AffixesSet.Storming.nameResId) -> binding.affixTwo.setImageResource(R.drawable.affix_storming)
            getString(AffixesSet.Entangling.nameResId) -> binding.affixTwo.setImageResource(R.drawable.affix_entangling)
            getString(AffixesSet.Afflicted.nameResId) -> binding.affixTwo.setImageResource(R.drawable.affix_afflicted)
            getString(AffixesSet.Incorporeal.nameResId) -> binding.affixTwo.setImageResource(R.drawable.affix_incorporeal)
            getString(AffixesSet.Shielding.nameResId) -> binding.affixTwo.setImageResource(R.drawable.affix_shielding)
        }
    }*/
}


@Composable
fun CompanionTopAppBar() {
    //todo make icon
    TopAppBar(title = { Text(text = "Keystone Companion") })
}

@Composable
fun CutoffsAndButtons(modifier: Modifier = Modifier, cutoffs: String) {
    MyKeystoneTheme {
        Surface {
            Column(
                modifier = modifier
                    .background(Color.Black)
                    .fillMaxSize()
                    .padding(16.dp),

                ) {

                Spacer(modifier = modifier.height(160.dp))
                Text(text = "cutoffs rating", color = Color.White) //todo font size 24sp + style
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "$cutoffs", color = Color.White)
                Column(
                    modifier = modifier
                        .width(200.dp)
                        .padding(2.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Button(onClick = { /*TODO*/ }) //todo set buttons clicks
                    {
                        Text(
                            text = "Dungeons",
                            modifier = modifier.width(150.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                    Spacer(modifier = modifier.height(10.dp))
                    Button(onClick = { /*TODO*/ }) {
                        Text(
                            text = "Mythic+",
                            modifier = modifier.width(150.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                }
                Spacer(modifier = modifier.height(20.dp))
                WeeklyModifiers()
            }
        }
    }
}

@Composable
fun WeeklyModifiers(modifier: Modifier = Modifier) {
    MyKeystoneTheme {
        Surface {
            Column(
                modifier = modifier
                    .background(Color.Black),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Weekly m+ modifiers", color = Color.White)
                Spacer(modifier = modifier.height(16.dp))
                Row(
                    modifier = modifier
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.affix_tyrannical),
                        contentDescription = "affix tyrannical",
                        modifier.size(56.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.affix_afflicted),
                        contentDescription = "affix one",
                        modifier.size(56.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.affix_bolstering),
                        contentDescription = "affix two",
                        modifier.size(56.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun CompanionApp() {
    MyKeystoneTheme {
        val navController = rememberNavController()
        Scaffold(topBar = { CompanionTopAppBar() }) { contPadding ->
            CutoffsAndButtons(
                modifier = Modifier.padding(contPadding),
                cutoffs = "4339"
            )
        }
    }
}


