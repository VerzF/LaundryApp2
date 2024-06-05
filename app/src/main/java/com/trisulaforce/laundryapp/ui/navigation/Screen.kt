package com.trisulaforce.laundryapp.ui.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("Beranda")
    data object Notification : Screen("Notification")
    data object Profile : Screen("profile")
    data object CekEmail : Screen("CekEmail")
    data object KataSandiBaru : Screen("KataSandiBaru")
    data object KonfirmasiKataSandi : Screen("KonfirmasiKataSandi")
    data object LupaKataSandi : Screen("LupaKataSandi")
    data object ResetKataSandi : Screen("ResetKataSandi")
    data object Masuk : Screen("Masuk")
    data object DaftarScreen : Screen("DaftarScreen")
    data object ScreenBeranda : Screen("ScreenBeranda")
    data object Onboarding : Screen("Onboarding")
    data object Editprofil : Screen("editprofil")
    data object DetailPesanan : Screen("DetailPesanan")
    data object ScreenLayanan : Screen("ScreenLayanan")
    data object KonfirmasiPesanan : Screen("KonfirmasiPesanan")
    data object RiwayatPesanan : Screen("RiwayatPesanan")
}