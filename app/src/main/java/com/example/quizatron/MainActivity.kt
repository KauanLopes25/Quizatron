package com.example.quizatron

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
                        ) {
                            StartScreen(navController)
                        }
                        composable(
                            route = "quiz",
                        ) {
                            QuizScreen(navController)
                        }
                        composable(
                            route = "result",
                        ) {
                            ResultScreen(navController)
                        }
                    }
                }
            }
        }
    }
}
