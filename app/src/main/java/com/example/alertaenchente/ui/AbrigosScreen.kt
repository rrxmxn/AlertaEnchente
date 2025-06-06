package com.example.alertaenchente.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

data class Abrigo(
    val nome: String,
    val endereco: String,
    val telefone: String,
    val capacidade: Int,
    val ocupacao: Int,
    val estrutura: List<String>
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AbrigosScreen(navController: NavController, fromHome: Boolean = false) {
    val abrigos = listOf(
        Abrigo(
            nome = "Escola Municipal Paulo Freire",
            endereco = "Rua das Flores, 123 - Centro",
            telefone = "(11) 3333-4444",
            capacidade = 200,
            ocupacao = 157,
            estrutura = listOf("Dormitórios", "Refeitório", "Atendimento médico", "Banheiros adaptados")
        ),
        Abrigo(
            nome = "Ginásio Municipal",
            endereco = "Av. Principal, 500 - Jd. Esperança",
            telefone = "(11) 3333-5555",
            capacidade = 350,
            ocupacao = 230,
            estrutura = listOf("Colchões", "Refeitório", "Área para pets", "Fraldário")
        ),
        Abrigo(
            nome = "Igreja São Francisco",
            endereco = "Rua da Paz, 78 - Bela Vista",
            telefone = "(11) 3333-6666",
            capacidade = 120,
            ocupacao = 85,
            estrutura = listOf("Dormitórios", "Cozinha", "Área infantil")
        )
    )

    Scaffold(
        topBar = {
    TopAppBar(
        title = { Text("Abrigos Disponíveis") },
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
                    "Locais seguros para abrigo temporário durante emergências",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }

            items(abrigos) { abrigo ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = abrigo.nome,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.LocationOn,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = abrigo.endereco,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }

                        Spacer(modifier = Modifier.height(4.dp))

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Phone,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = abrigo.telefone,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        LinearProgressIndicator(
                            progress = abrigo.ocupacao.toFloat() / abrigo.capacidade,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Ocupação: ${abrigo.ocupacao}/${abrigo.capacidade} pessoas",
                            style = MaterialTheme.typography.bodySmall
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Estrutura disponível:",
                            style = MaterialTheme.typography.bodySmall,
                            fontWeight = FontWeight.Bold
                        )

                        abrigo.estrutura.forEach { item ->
                            Text(
                                text = "• $item",
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }
            }
        }
    }
}