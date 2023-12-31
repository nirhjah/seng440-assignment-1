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
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

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
import androidx.compose.ui.graphics.graphicsLayer

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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


                    BoxWithConstraints {
                        if (maxWidth < 400.dp) {

                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.verticalScroll(rememberScrollState()).padding(bottom = 90.dp)

                            ) {

                                Text(stringResource(R.string.home_heading), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, modifier = Modifier.width(400.dp).padding(top = 15.dp), fontSize = 30.sp)
                                //ANIMATION
                                var visible by remember {
                                    mutableStateOf(false)
                                }
                                LaunchedEffect(key1 = Unit, block = {
                                    delay(100L)
                                    visible = true
                                })
                                AnimatedVisibility(
                                    visible,
                                    enter = expandVertically(expandFrom = Alignment.Top) { 20 },
                                    exit = shrinkVertically(animationSpec = tween()) { fullHeight ->
                                        fullHeight / 2
                                    },
                                ) {
                                    WitsocLogo()
                                }

                                Text(stringResource(R.string.about_witsoc), textAlign = TextAlign.Center, modifier = Modifier.padding(all = 20.dp), fontSize = 20.sp)

                                ImageDisplay()

                            }

                        } else {

                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.verticalScroll(rememberScrollState()).padding(bottom = 90.dp)

                            ) {

                                Text(stringResource(R.string.home_heading), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, modifier = Modifier.width(400.dp).padding(top = 15.dp), fontSize = 30.sp)
                                WitsocLogo()
                                Text(stringResource(R.string.about_witsoc), textAlign = TextAlign.Center, modifier = Modifier.padding(all = 20.dp), fontSize = 20.sp)


                                Row {

                                    ImageDisplay()
                                }

                            }




                        }
                    }











                }
            }
        }
    }
}


@Composable
fun WitsocLogo() {
    Image(
        painter = painterResource(id = R.drawable.witsoclogo),
        contentDescription = "witsoc logo"
    )
}

@Composable
fun ImageDisplay() {
    Image(
        painter = painterResource(id = R.drawable.home_pic1),
        contentDescription = "witsoc logo",
        modifier = Modifier
            .graphicsLayer {
                this.rotationZ = 15f
            }
    )

    Image(
        painter = painterResource(id = R.drawable.home_pic2),
        contentDescription = "witsoc logo",
        modifier = Modifier
            .graphicsLayer {
                this.rotationZ = -15f
            }

    )

    Image(
        painter = painterResource(id = R.drawable.home_pic3),
        contentDescription = "witsoc logo",
        modifier = Modifier
            .graphicsLayer {
                this.rotationZ = 15f
            }
    )

    Image(
        painter = painterResource(id = R.drawable.home_pic4),
        contentDescription = "witsoc logo",
        modifier = Modifier
            .graphicsLayer {
                this.rotationZ = -15f
            }
    )
}

