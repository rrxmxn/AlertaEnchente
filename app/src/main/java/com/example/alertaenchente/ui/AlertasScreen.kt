package com.example.alertaenchente.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Alerta(
    val tipo: String,
    val local: String,
    val nivelRisco: NivelRisco,
    val dataHora: LocalDateTime,
    val descricao: String
)

enum class NivelRisco(val cor: Color, val descricao: String) {
    BAIXO(Color(0xFF4CAF50), "Baixo"),
    MEDIO(Color(0xFFFFC107), "Médio"),
    ALTO(Color(0xFFFF9800), "Alto"),
    CRITICO(Color(0xFFF44336), "Crítico")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertasScreen(navController: NavController) {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")
    val agora = LocalDateTime.now()
    
    val alertas = listOf(
        Alerta(
            tipo = "Enchente",
            local = "Bairro Centro",
            nivelRisco = NivelRisco.CRITICO,
            dataHora = agora.minusHours(1),
            descricao = "Transbordamento do Rio Tietê afetando ruas principais. Evite área e procure rotas alternativas."
        ),
        Alerta(
            tipo = "Deslizamento",
            local = "Morro Azul", 
            nivelRisco = NivelRisco.ALTO,
            dataHora = agora.minusHours(2),
            descricao = "Risco iminente de deslizamento devido às chuvas intensas. Moradores devem evacuar a área."
        ),
        Alerta(
            tipo = "Chuva Intensa",
            local = "Região Norte",
            nivelRisco = NivelRisco.MEDIO,
            dataHora = agora.minusHours(3),
            descricao = "Previsão de precipitação acima de 60mm nas próximas 3 horas. Possibilidade de alagamentos."
        )
    )

    Scaffold(
        topBar = {
    TopAppBar(
        title = { Text("Alertas Ativos") },
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
            items(alertas) { alerta ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(
                                imageVector = Icons.Default.Warning,
                                contentDescription = "Alerta",
                                tint = alerta.nivelRisco.cor,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "${alerta.tipo} - ${alerta.local}",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Surface(
                                color = alerta.nivelRisco.cor,
                                shape = MaterialTheme.shapes.small
                            ) {
                                Text(
                                    text = "Risco ${alerta.nivelRisco.descricao}",
                                    color = Color.White,
                                    style = MaterialTheme.typography.labelMedium,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }
                        }
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = alerta.descricao,
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Emitido: ${alerta.dataHora.format(formatter)}",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}