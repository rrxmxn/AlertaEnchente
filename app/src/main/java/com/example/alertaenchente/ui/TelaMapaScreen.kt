package com.example.alertaenchente.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.maps.android.compose.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
@Composable
@SuppressLint("MissingPermission")
fun TelaMapaScreen() {
    val saoPaulo = LatLng(-23.5505, -46.6333) // Troque para sua cidade ou localização relevante

    val context = LocalContext.current

    val permissionState = rememberPermissionState(
        android.Manifest.permission.ACCESS_FINE_LOCATION
    )

    LaunchedEffect(Unit) {
        permissionState.launchPermissionRequest()
    }

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(saoPaulo, 10f)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mapa de Enchentes") }
            )
        }
    ) { paddingValues ->

        GoogleMap(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            cameraPositionState = cameraPositionState,
            uiSettings = MapUiSettings(zoomControlsEnabled = true),
            properties = MapProperties(isMyLocationEnabled = true)
        ) {
            Marker(
                state = MarkerState(position = saoPaulo),
                title = "Ponto de referência",
                snippet = "Aqui há risco de enchente"
            )
        }
    }
}
