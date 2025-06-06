package com.example.alertaenchente.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContatosScreen(navController: NavController) {
    var novoContato by remember { mutableStateOf("") }
    var contatos by remember { mutableStateOf(listOf("Defesa Civil - 199", "Bombeiros - 193")) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Contatos de Emergência") }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            OutlinedTextField(
                value = novoContato,
                onValueChange = { novoContato = it },
                label = { Text("Adicionar contato") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    if (novoContato.isNotBlank()) {
                        contatos = contatos + novoContato
                        novoContato = ""
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Adicionar")
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(contatos) { contato ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Text(
                            text = contato,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
        }
    }
}
