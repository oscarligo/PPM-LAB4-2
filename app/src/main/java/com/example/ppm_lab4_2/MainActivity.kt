package com.example.ppm_lab4_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import com.example.ppm_lab4_2.ui.theme.PPMLAB42Theme
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PPMLAB42Theme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "images") {
                    composable("images") { ImagesScreen(navController) }
                    composable("add") { AddImageScreen(navController) }
                }
            }
        }
    }
}


