package com.trisulaforce.laundryapp.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("Beranda")
    object Notification : Screen("Notification")
    object Profile : Screen("profile")
    object CekEmail : Screen("CekEmail")
    object KataSandiBaru : Screen("KataSandiBaru")
    object KonfirmasiKataSandi : Screen("KonfirmasiKataSandi")
    object LupaKataSandi : Screen("LupaKataSandi")
    object ResetKataSandi : Screen("ResetKataSandi")
    object Masuk : Screen("Masuk")
    object DaftarScreen : Screen("DaftarScreen")
    object ScreenBeranda : Screen("ScreenBeranda")
    object Onboarding : Screen("Onboarding")
}