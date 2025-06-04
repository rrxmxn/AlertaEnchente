package com.example.alertaenchente.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.alertaenchente.ui.*

@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    ) {
        composable("home") { HomeScreen(navController) }
//        composable("alertas") { AlertasScreen(navController) }
        composable("mapa") { MapaScreen(navController) }
//        composable("abrigos") { AbrigosScreen(navController) }
//        composable("simulacoes") { SimulacoesScreen(navController) }
//        composable("sobre") { SobreScreen(navController) }
    }
}
