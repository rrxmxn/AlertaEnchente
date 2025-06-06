package com.example.alertaenchente.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import android.content.Intent
import android.net.Uri

data class Contato(val nome: String, val telefone: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaContatosScreen() {
    val context = LocalContext.current
    val contatos = listOf(
        Contato("Defesa Civil", "199"),
        Contato("Bombeiros", "193"),
        Contato("Polícia Militar", "190"),
        Contato("SAMU", "192")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Contatos de Emergência") }
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
            items(contatos) { contato ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            val intent = Intent(
                                Intent.ACTION_DIAL,
                                Uri.parse("tel:${contato.telefone}")
                            )
                            context.startActivity(intent)
                        }
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = contato.nome,
                            style = MaterialTheme.typography.headlineMedium
                        )
                        Text(
                            text = "Telefone: ${contato.telefone}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }
}
