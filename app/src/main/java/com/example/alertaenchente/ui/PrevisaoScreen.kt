package com.example.alertaenchente.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class PrevisaoTempo(
    val data: String,
    val temperatura: Int,
    val descricao: String,
    val precipitacao: Int, // mm
    val probabilidade: Int, // %
    val icone: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrevisaoScreen(navController: NavController, fromHome: Boolean = false) {
    val diasSemana = listOf("Hoje", "Amanhã", "Segunda", "Terça", "Quarta", "Quinta", "Sexta")

    val previsoes = listOf(
        PrevisaoTempo("Hoje", 22, "Chuva forte", 30, 90, "chuva_forte"),
        PrevisaoTempo("Amanhã", 24, "Chuva moderada", 15, 80, "chuva_moderada"),
        PrevisaoTempo("Depois de amanhã", 25, "Pancadas de chuva", 10, 60, "chuva_fraca"),
        PrevisaoTempo("Em 3 dias", 27, "Parcialmente nublado", 5, 30, "parcialmente_nublado"),
        PrevisaoTempo("Em 4 dias", 29, "Ensolarado", 0, 10, "sol")
    )

    var tabSelecionada by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Previsão do Tempo") },
                navigationIcon =
                    {
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
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            item {
                // Informações da previsão atual
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "Agora",
                            style = MaterialTheme.typography.titleMedium
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onPrimaryContainer,
                            modifier = Modifier.size(64.dp)
                        )

                        Text(
                            "22°C",
                            style = MaterialTheme.typography.displayMedium
                        )

                        Text(
                            "Sensação térmica: 24°C",
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            "Chuva forte",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    "Precipitação",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Text(
                                    "30 mm/h",
                                    style = MaterialTheme.typography.bodyLarge,
                                    fontWeight = FontWeight.Bold
                                )
                            }

                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    "Umidade",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Text(
                                    "85%",
                                    style = MaterialTheme.typography.bodyLarge,
                                    fontWeight = FontWeight.Bold
                                )
                            }

                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    "Vento",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Text(
                                    "15 km/h",
                                    style = MaterialTheme.typography.bodyLarge,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Tabs para previsão de dias seguintes
                Text(
                    "Próximos dias",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                // Previsão para os próximos dias
                previsoes.forEach { previsao ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = previsao.data,
                                style = MaterialTheme.typography.titleMedium,
                                modifier = Modifier.width(80.dp)
                            )

                            Icon(
                                imageVector = Icons.Default.Refresh,
                                contentDescription = null,
                                tint = when(previsao.precipitacao) {
                                    in 0..5 -> Color(0xFF4CAF50)
                                    in 6..15 -> Color(0xFFFFC107)
                                    in 16..25 -> Color(0xFFFF9800)
                                    else -> Color(0xFFF44336)
                                },
                                modifier = Modifier.size(36.dp)
                            )

                            Spacer(modifier = Modifier.width(16.dp))

                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = previsao.descricao,
                                    style = MaterialTheme.typography.bodyMedium
                                )

                                Text(
                                    text = "Precipitação: ${previsao.precipitacao}mm (${previsao.probabilidade}%)",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }

                            Text(
                                text = "${previsao.temperatura}°C",
                                style = MaterialTheme.typography.titleLarge
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            "Alerta meteorológico",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFF44336)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            "Previsão de chuvas intensas nas próximas 24h com possibilidade de inundações em áreas de risco. Evite deslocamentos desnecessários e fique atento às atualizações.",
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            "Última atualização: ${LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))}",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}