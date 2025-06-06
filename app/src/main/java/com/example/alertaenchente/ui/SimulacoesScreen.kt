package com.example.alertaenchente.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.alertaenchente.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimulacoesScreen(navController: NavController, fromHome: Boolean = false) {
    var selectedRegion by remember { mutableStateOf("Centro") }
    val regions = listOf("Centro", "Zona Norte", "Zona Sul", "Zona Leste", "Zona Oeste")

    val simulationScenarios = listOf(
        "Cenário atual",
        "Chuva de 50mm/h por 1 hora",
        "Chuva de 80mm/h por 1 hora",
        "Chuva de 100mm/h por 2 horas"
    )

    var selectedScenario by remember { mutableStateOf(simulationScenarios[0]) }

    Scaffold(
        topBar = {
    TopAppBar(
        title = { Text("Simulações de Enchente") },
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
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            item {
                Text(
                    "Visualize previsões de alagamento com base em diferentes cenários de chuva",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Text(
                    "Região",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                SingleChoiceSegmentedButtonRow(modifier = Modifier.fillMaxWidth()) {
                    regions.forEachIndexed { index, region ->
                        SegmentedButton(
                            selected = selectedRegion == region,
                            onClick = { selectedRegion = region },
                            shape = SegmentedButtonDefaults.itemShape(index = index, count = regions.size)
                        ) {
                            Text(region)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    "Cenário de chuva",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Column {
                    simulationScenarios.forEach { scenario ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                        ) {
                            RadioButton(
                                selected = selectedScenario == scenario,
                                onClick = { selectedScenario = scenario }
                            )
                            Text(scenario, modifier = Modifier.padding(start = 8.dp))
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            "Simulação: $selectedScenario - $selectedRegion",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // Placeholder for simulation map image
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp)
                                .border(1.dp, Color.Gray)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_launcher_background), // Replace with actual flood simulation image
                                contentDescription = "Mapa de simulação de enchente",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )

                            Text(
                                "Mapa de simulação de enchente\n$selectedRegion - $selectedScenario",
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .padding(16.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        val riskLevel = when(selectedScenario) {
                            simulationScenarios[0] -> "Baixo"
                            simulationScenarios[1] -> "Médio"
                            simulationScenarios[2] -> "Alto"
                            else -> "Crítico"
                        }

                        val riskColor = when(riskLevel) {
                            "Baixo" -> Color(0xFF4CAF50)
                            "Médio" -> Color(0xFFFFC107)
                            "Alto" -> Color(0xFFFF9800)
                            else -> Color(0xFFF44336)
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                "Nível de risco:",
                                style = MaterialTheme.typography.bodyLarge
                            )

                            Spacer(modifier = Modifier.weight(1f))

                            Surface(
                                color = riskColor,
                                shape = MaterialTheme.shapes.small
                            ) {
                                Text(
                                    text = riskLevel,
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyLarge,
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        Button(
                            onClick = { /* Gerar relatório detalhado */ },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Gerar relatório detalhado")
                            Spacer(modifier = Modifier.width(8.dp))
                            Icon(Icons.Default.ArrowForward, contentDescription = null)
                        }
                    }
                }
            }
        }
    }
}