package com.example.alertaenchente.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.alertaenchente.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SobreScreen(navController: NavController, fromHome: Boolean = false) {
    Scaffold(
        topBar = {
    TopAppBar(
        title = { Text("Sobre o App") },
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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                // App logo
                Image(
                    painter = painterResource(id = R.drawable.ic_logo),
                    contentDescription = "Logo Alerta Enchente",
                    modifier = Modifier
                        .size(120.dp)
                        .padding(vertical = 16.dp),
                    contentScale = ContentScale.Fit
                )

                Text(
                    "Alerta Enchente",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    "v1.0.0",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(24.dp))

                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Info,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                "Sobre o aplicativo",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            "O Alerta Enchente é uma aplicação desenvolvida para auxiliar a população em situações de emergência relacionadas a enchentes e alagamentos.",
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            "Nosso objetivo é fornecer informações em tempo real sobre áreas de risco, alertas de enchentes, locais de abrigo e instruções de segurança para ajudar a comunidade a se preparar e responder adequadamente a eventos climáticos extremos.",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            "Desenvolvedores",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // Lista de desenvolvedores - substitua com nomes reais
                        listOf(
                            "Catherine Mian Palhares - RM98463",
                            "Rafael Bossert Borring - RM98196",
                            "Ramon Vitor Domingues de Moraes - RM96207",
                            "Vanderlei Lopes Ferreira - RM550435"
                        ).forEach { dev ->
                            Text(
                                "• $dev",
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(vertical = 4.dp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            "Tecnologias utilizadas",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // Lista de tecnologias
                        listOf(
                            "Kotlin",
                            "Jetpack Compose",
                            "Material Design 3",
                            "Navigation Component",
                            "Retrofit para conexões API",
                            "Google Maps API"
                        ).forEach { tech ->
                            Text(
                                "• $tech",
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(vertical = 4.dp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    "© 2025 Alerta Enchente - Todos os direitos reservados",
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}