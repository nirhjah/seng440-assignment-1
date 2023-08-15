package nz.ac.uclive.nse41.witsoc

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi

import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically

import androidx.compose.animation.shrinkVertically

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import kotlinx.coroutines.delay
import nz.ac.uclive.nse41.witsoc.ui.theme.WitsocTheme


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {

            WitsocTheme {
                Scaffold(
                    bottomBar = {
                        BottomNavigation()
                    },
                    containerColor =  Color(0xFFCCBFF7)
                ) {

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {

                        var visible by remember {
                            mutableStateOf(false)
                        }
                        LaunchedEffect(key1 = Unit, block = {
                            delay(100L)
                            visible = true
                        })
                        AnimatedVisibility(
                            visible,
                            // Sets the initial height of the content to 20, revealing only the top of the content at
                            // the beginning of the expanding animation.
                            enter = expandVertically(expandFrom = Alignment.Top) { 20 },
                            // Shrinks the content to half of its full height via an animation.
                            exit = shrinkVertically(animationSpec = tween()) { fullHeight ->
                                fullHeight / 2
                            },
                        ) {
                            // Content that needs to appear/disappear goes here:
                            WitsocLogo()
                        }

                        Text(stringResource(R.string.about_witsoc), textAlign = TextAlign.Center, modifier = Modifier.padding(all = 20.dp))
                    }
                }
            }
        }
    }
}





/*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WitsocTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WitsocTheme {
        Greeting("Android")
    }
}*/

@Composable
fun WitsocLogo() {

    Image(
        painter = painterResource(id = R.drawable.witsoclogo),
        contentDescription = "witsoc logo"
    )



}