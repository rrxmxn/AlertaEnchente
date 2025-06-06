package com.example.alertaenchente.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(navController)
        }
        composable("mapa") {
            MapaScreen(navController)
        }
        composable("alertas") {
            AlertasScreen(navController)
        }
        composable("previsao") {
            PrevisaoScreen(navController)
        }
        composable("contatos") {
            ContatosScreen(navController)
        }
        composable("configuracoes") {
            ConfiguracoesScreen(navController)
        }
    }
}
