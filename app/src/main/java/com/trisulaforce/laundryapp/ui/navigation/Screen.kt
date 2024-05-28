package com.trisulaforce.laundryapp.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Notification : Screen("Notification")
    object Profile : Screen("profile")
}