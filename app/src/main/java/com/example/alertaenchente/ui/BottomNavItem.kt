package com.example.alertaenchente.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.alertaenchente.R

sealed class BottomNavItem(
    val route: String,
    @DrawableRes val icon: Int
) {
    object Home : BottomNavItem("home", R.drawable.ic_home)
    object Mapa : BottomNavItem("mapa", R.drawable.ic_map)
    object Alertas : BottomNavItem("alertas", R.drawable.ic_alert)
    object Previsao : BottomNavItem("previsao", R.drawable.ic_cloud)
    object Contatos : BottomNavItem("contatos", R.drawable.ic_contact)
}
