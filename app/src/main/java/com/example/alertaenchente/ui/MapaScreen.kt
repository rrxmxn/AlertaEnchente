package com.example.alertaenchente.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapaScreen(navController: NavController) {
    val areasDeRisco = listOf(
        "Bairro Centro - Próximo ao Rio Tietê",
        "Região do Morro Azul",
        "Vale da Esperança",
        "Vila Santa Luzia - Área baixa",
        "Comunidade São Jorge"
    )

    var mapMode by remember { mutableStateOf("Risco") } // Pode ser "Risco" ou "Abrigos"

    Scaffold(
        topBar = {
    TopAppBar(
        title = { Text("Mapa de Áreas de Risco") },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Voltar"
                )
            }
        }
    )
}
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            // Seletor de modo do mapa
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Button(
                    onClick = { mapMode = "Risco" },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (mapMode == "Risco")
                            MaterialTheme.colorScheme.primary
                        else
                            MaterialTheme.colorScheme.surfaceVariant
                    ),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Áreas de Risco")
                }

                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = { mapMode = "Abrigos" },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (mapMode == "Abrigos")
                            MaterialTheme.colorScheme.primary
                        else
                            MaterialTheme.colorScheme.surfaceVariant
                    ),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Abrigos")
                }
            }

            // Placeholder para o mapa (em uma implementação real, isso seria um componente de mapa real)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(Color.LightGray)
            ) {
                Text(
                    text = "Mapa de ${if (mapMode == "Risco") "Áreas de Risco" else "Abrigos Disponíveis"}",
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Áreas de risco ou lista de abrigos
            if (mapMode == "Risco") {
                Text(
                    "Áreas com alto risco de enchente",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                LazyColumn {
                    items(areasDeRisco.size) { index ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Warning,
                                    contentDescription = null,
                                    tint = Color(0xFFF44336)
                                )

                                Spacer(modifier = Modifier.width(16.dp))

                                Text(areasDeRisco[index])
                            }
                        }
                    }
                }
            } else {
                Text(
                    "Abrigos próximos",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                val abrigos = listOf(
                    "Escola Municipal Paulo Freire - 1.2km",
                    "Ginásio Municipal - 2.5km",
                    "Igreja São Francisco - 3.0km"
                )

                LazyColumn {
                    items(abrigos.size) { index ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                            ) {
                                Icon(
                                    imageVector = Icons.Default.LocationOn,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary
                                )

                                Spacer(modifier = Modifier.width(16.dp))

                                Text(abrigos[index])
                            }
                        }
                    }
                }
            }
        }
    }
}