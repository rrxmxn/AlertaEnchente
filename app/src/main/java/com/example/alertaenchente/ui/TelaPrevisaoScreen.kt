package com.example.alertaenchente.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaPrevisaoScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Previsão do Tempo") }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "🌧️ 80% de chance de chuva",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "💧 Risco de alagamento moderado",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Temperatura: 22°C\nUmidade: 88%\nVento: 10 km/h",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
