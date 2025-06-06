package com.example.alertaenchente.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertasScreen(navController: NavController) {
    val alertas = listOf(
        "Alerta de enchente - Bairro Centro",
        "Alerta de deslizamento - Morro Azul",
        "Aviso de chuva intensa - Região Norte"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Alertas Ativos") }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            items(alertas) { alerta ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                ) {
                    Text(
                        text = alerta,
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}
