package com.example.quizatron

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.quizatron.screens.quiz.QuizScreen
import com.example.quizatron.screens.result.ResultScreen
import com.example.quizatron.screens.start.StartScreen
import com.example.quizatron.ui.theme.QuizatronTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuizatronTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "start",
                    ) {
                        composable(
                            route = "start",
                            exitTransition = {
                                slideOutOfContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.Down,
                                    tween(4000)
                                ) + fadeOut(tween(4000))
                            },
                            enterTransition = {
                                slideIntoContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.Up,
                                    animationSpec = tween(4000)
                                )
                            }
                        ) {
                            StartScreen(navController)
                        }
                        composable(
                            route = "quiz/{nome}",
                            exitTransition = {
                                slideOutOfContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
                                    tween(2000)
                                ) + fadeOut(tween(2000))
                            },
                            enterTransition = {
                                slideIntoContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.Down,
                                    animationSpec = tween(4000)
                                )
                            },
                            arguments = listOf(
                                navArgument("nome") {
                                    type = NavType.StringType
                                }
                            )
                        ) { navBackStackEntry ->
                            val nome = navBackStackEntry.arguments?.getString("nome") ?: ""
                            QuizScreen(navController, nome = nome)
                        }
                        composable(
                            route = "result/{acertos}/{nome}",
                            exitTransition = {
                                slideOutOfContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.Up,
                                    tween(4000)
                                ) + fadeOut(tween(4000))
                            },
                            enterTransition = {
                                slideIntoContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
                                    animationSpec = tween(2000)
                                )
                            },
                            arguments = listOf(
                                navArgument("acertos") {
                                    type = NavType.IntType
                                }
                            )
                        ) { navBackStackEntry ->
                            val acertos = navBackStackEntry.arguments?.getInt("acertos") ?: 0
                            val nome = navBackStackEntry.arguments?.getString("nome") ?: ""
                            ResultScreen(navController, resultado = acertos, nome = nome)
                        }
                    }
                }
            }
        }
    }
}