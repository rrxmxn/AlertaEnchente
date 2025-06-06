package com.example.alertaenchente

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.navigation.compose.rememberNavController
import com.example.alertaenchente.ui.AppNavigation
import com.example.alertaenchente.ui.BottomNavigationBar
import com.example.alertaenchente.ui.theme.AlertaEnchenteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlertaEnchenteTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(navController)
                    }
                ) { innerPadding ->
                    AppNavigation(navController = navController)
                }
            }
        }
    }
}
