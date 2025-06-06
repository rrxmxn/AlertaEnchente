package com.example.alertaenchente.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrevisaoScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Previsão do Tempo") }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Previsão do tempo em desenvolvimento.\nAqui serão exibidos os dados meteorológicos.",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
