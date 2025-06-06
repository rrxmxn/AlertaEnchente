package com.example.alertaenchente.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfiguracoesScreen(navController: NavController) {
    var notificacoesAtivas by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Configurações") }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text(
                text = "Preferências",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Notificações",
                    modifier = Modifier.weight(1f)
                )
                Switch(
                    checked = notificacoesAtivas,
                    onCheckedChange = { notificacoesAtivas = it }
                )
            }
        }
    }
}


