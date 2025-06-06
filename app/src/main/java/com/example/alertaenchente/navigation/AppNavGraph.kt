package com.example.alertaenchente.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.alertaenchente.ui.*

@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        
        composable(Screen.Mapa.route) {
            MapaScreen(navController)
        }
        
        composable(Screen.Alertas.route) {
            AlertasScreen(navController)
        }
        
        composable(Screen.Previsao.route) {
            PrevisaoScreen(navController)
        }
        
        composable(Screen.Contatos.route) {
            ContatosScreen(navController)
        }
        
        // For screens that can be accessed from both bottom nav and direct links:
        composable(
            "${Screen.Abrigos.route}?fromHome={fromHome}",
            arguments = listOf(navArgument("fromHome") { 
                type = NavType.BoolType
                defaultValue = false 
            })
        ) { backStackEntry ->
            val fromHome = backStackEntry.arguments?.getBoolean("fromHome") ?: false
            AbrigosScreen(navController, fromHome)
        }
        
        composable(
            "${Screen.Simulacoes.route}?fromHome={fromHome}",
            arguments = listOf(navArgument("fromHome") { 
                type = NavType.BoolType
                defaultValue = false 
            })
        ) { backStackEntry ->
            val fromHome = backStackEntry.arguments?.getBoolean("fromHome") ?: false
            SimulacoesScreen(navController, fromHome)
        }
        
        composable(
            "${Screen.Sobre.route}?fromHome={fromHome}",
            arguments = listOf(navArgument("fromHome") { 
                type = NavType.BoolType
                defaultValue = false 
            })
        ) { backStackEntry ->
            val fromHome = backStackEntry.arguments?.getBoolean("fromHome") ?: false
            SobreScreen(navController, fromHome)
        }
    }
}

sealed class Screen(val route: String, val title: String) {
    object Home : Screen("home", "Home")
    object Mapa : Screen("mapa", "Mapa de Riscos")
    object Alertas : Screen("alertas", "Alertas")
    object Previsao : Screen("previsao", "Previsão do Tempo")
    object Contatos : Screen("contatos", "Contatos")
    object Abrigos : Screen("abrigos", "Abrigos")
    object Simulacoes : Screen("simulacoes", "Simulações")
    object Sobre : Screen("sobre", "Sobre")
}