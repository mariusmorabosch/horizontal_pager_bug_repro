package com.example.horizontalpagerscrollbugrepro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.horizontalpagerscrollbugrepro.ui.theme.HorizontalPagerScrollBugreproTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import dev.chrisbanes.snapper.ExperimentalSnapperApi

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class, ExperimentalSnapperApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HorizontalPagerScrollBugreproTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                vertical = 40.dp,
                                horizontal = 20.dp
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        val pagerState = rememberPagerState()

                        HorizontalPager(
                            count = 5,
                            state = pagerState,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Brush.horizontalGradient(listOf(Color.Gray, Color.White))),
//                            flingBehavior = rememberFlingBehaviorMultiplier(multiplier = 2.0f,
//                                baseFlingBehavior = PagerDefaults.flingBehavior(state = pagerState))
                        ) { page ->

                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                Spacer(modifier = Modifier.height(40.dp))
                                Text(
                                    text = "Title $page",
                                    style = MaterialTheme.typography.h1,
                                    textAlign = TextAlign.Center
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "Some message here for page #$page",
                                    style = MaterialTheme.typography.body1,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }

                        HorizontalPagerIndicator(
                            pagerState = pagerState,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(top = 16.dp, bottom = 20.dp),
                            activeColor = MaterialTheme.colors.primary,
                            spacing = 16.dp
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    }
}

//@Composable
//fun rememberFlingBehaviorMultiplier(
//    multiplier: Float,
//    baseFlingBehavior: FlingBehavior,
//): FlingBehavior = remember(multiplier, baseFlingBehavior) {
//    FlingBehaviourMultiplier(multiplier, baseFlingBehavior)
//}
//
//private class FlingBehaviourMultiplier(
//    private val multiplier: Float,
//    private val baseFlingBehavior: FlingBehavior,
//) : FlingBehavior {
//    override suspend fun ScrollScope.performFling(initialVelocity: Float): Float {
//        return with(baseFlingBehavior) {
//            performFling(initialVelocity * multiplier)
//        }
//    }
//}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HorizontalPagerScrollBugreproTheme {
        Greeting("Android")
    }
}