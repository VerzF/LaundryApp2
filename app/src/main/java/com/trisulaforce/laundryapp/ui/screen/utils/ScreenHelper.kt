package com.trisulaforce.laundryapp.ui.screen.utils

import com.trisulaforce.laundryapp.ui.navigation.Screen

fun String?.shouldShowBottomBar(): Boolean {
    return this in setOf(
        Screen.Home.route,
        Screen.Profile.route,
        Screen.Notification.route,
    )
}