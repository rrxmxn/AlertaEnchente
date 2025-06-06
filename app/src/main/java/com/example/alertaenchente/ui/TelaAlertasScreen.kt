package com.example.alertaenchente.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaAlertasScreen() {
    val alertas = listOf(
        "⚠️ Alerta de enchente no bairro Centro - Risco alto",
        "🌧️ Possibilidade de alagamentos em Vila Nova nas próximas 2 horas",
        "🚧 Rua das Flores interditada por acúmulo de água"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Alertas de Enchente") }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(alertas) { alerta ->
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = alerta,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}
