package com.example.alertaenchente.ui

import android.Manifest
import android.content.pm.PackageManager
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.google.maps.android.compose.*
import androidx.compose.material3.Text
import androidx.navigation.NavHostController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MapaScreen() {
    val context = LocalContext.current

    val permissionState = rememberPermissionState(
        android.Manifest.permission.ACCESS_FINE_LOCATION
    )

    LaunchedEffect(Unit) {
        permissionState.launchPermissionRequest()
    }

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(
            LatLng(-23.5505, -46.6333), // Posição inicial (SP, exemplo)
            12f
        )
    }

    val hasPermission = permissionState.status.isGranted

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        properties = MapProperties(
            isMyLocationEnabled = hasPermission
        )
    )
}

