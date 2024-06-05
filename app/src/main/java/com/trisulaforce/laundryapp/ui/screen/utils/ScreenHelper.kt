package com.trisulaforce.laundryapp.ui.screen.utils

import com.trisulaforce.laundryapp.ui.navigation.Screen

fun String?.shouldShowBottomBar(): Boolean {
    return this in setOf(
        Screen.Home.route,
        Screen.ScreenLayanan.route,
        Screen.DetailPesanan.route,
        Screen.RiwayatPesanan.route,
        Screen.Profile.route,
        Screen.Notification.route,
    )
}