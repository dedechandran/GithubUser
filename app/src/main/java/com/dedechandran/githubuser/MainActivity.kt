package com.dedechandran.githubuser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.material.ExperimentalMaterialApi
import com.dedechandran.githubuser.ui.theme.GithubUserTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberAnimatedNavController()
            GithubUserTheme {
                AnimatedNavHost(
                    navController = navController,
                    startDestination = Screen.Home.route
                ) {
                    composable(
                        route = Screen.Home.route,
                        enterTransition = { _, _ ->
                            slideInHorizontally(
                                initialOffsetX = { -1000 },
                                animationSpec = tween(500)
                            )
                        },
                        exitTransition = { _, _ ->
                            slideOutHorizontally(
                                targetOffsetX = { -1000 },
                                animationSpec = tween(500)
                            )
                        },
                    ) {
                        HomeScreen(onItemClicked = { id ->
                            navController.navigate(route = Screen.Details.createRoute(id = id))
                        })
                    }
                    composable(
                        route = Screen.Details.route,
                        enterTransition = { _, _ ->
                            slideInHorizontally(
                                initialOffsetX = { 1000 },
                                animationSpec = tween(500)
                            )
                        },
                        exitTransition = { _, _ ->
                            slideOutHorizontally(
                                targetOffsetX = { 1000 },
                                animationSpec = tween(500)
                            )
                        }
                    ) { backStack ->
                        val args = backStack.arguments?.getString("id") ?: ""
                        DetailsScreen(
                            userId = args,
                            onNavigateBack = {
                            navController.popBackStack()
                        })
                    }
                }
            }
        }
    }
}

