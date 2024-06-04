package com.trisulaforce.laundryapp

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.trisulaforce.laundryapp.ui.screen.profil.ProfilScreen
import com.trisulaforce.laundryapp.ui.screen.forgotpassword.CekEmail
import com.trisulaforce.laundryapp.ui.screen.forgotpassword.LupaKataSandi
import com.trisulaforce.laundryapp.ui.navigation.NavigationItem
import com.trisulaforce.laundryapp.ui.navigation.Screen
import com.trisulaforce.laundryapp.ui.screen.beranda.Beranda
import com.trisulaforce.laundryapp.ui.screen.forgotpassword.KataSandiBaru
import com.trisulaforce.laundryapp.ui.screen.forgotpassword.KonfirmasiKataSandi
import com.trisulaforce.laundryapp.ui.screen.forgotpassword.ResetKataSandi
import com.trisulaforce.laundryapp.ui.screen.masuk.Masuk
import com.trisulaforce.laundryapp.ui.screen.notifikasi.Notification
import com.trisulaforce.laundryapp.ui.screen.splashscreen.Onboarding
import com.trisulaforce.laundryapp.ui.theme.LaundryAppTheme

@Composable
fun LaundryApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.Profile.route) {
                BottomBar(navController, contentPadding = PaddingValues())
            }
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Onboarding.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                Beranda(navController)
            }

            composable(Screen.Profile.route){
                ProfilScreen(navController = navController, PaddingValues())
            }

            composable(Screen.Notification.route){
                Notification( navigateBack = { navController.popBackStack() })
            }

            composable(Screen.LupaKataSandi.route){
                LupaKataSandi(navController = navController, navigateBack = { navController.popBackStack() })
            }

            composable(Screen.CekEmail.route){
                CekEmail(navController = navController, navigateBack = { navController.popBackStack() })
            }

            composable(Screen.ResetKataSandi.route){
                ResetKataSandi(navController, navigateBack = { navController.popBackStack() })
            }

            composable(Screen.KonfirmasiKataSandi.route){
                KonfirmasiKataSandi(navController = navController)
            }

            composable(Screen.KataSandiBaru.route){
                KataSandiBaru(navController = navController, navigateBack = { navController.popBackStack() })
            }

            composable(Screen.Masuk.route){
                Masuk(navController, Modifier, navigateBack = { navController.popBackStack() })
            }

            composable(Screen.Onboarding.route){
                Onboarding(navController = navController, modifier = Modifier) {}
            }
        }
    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues
) {
    NavigationBar(
        modifier = modifier.padding(contentPadding),
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(R.string.menu_home),
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(R.string.menu_notifikasi),
                icon = Icons.Default.Notifications,
                screen = Screen.Notification
            ),
            NavigationItem(
                title = stringResource(R.string.menu_profile),
                icon = Icons.Default.AccountCircle,
                screen = Screen.Profile
            ),
        )
        navigationItems.map { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = { Text(item.title) },
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LaundryAppPreview() {
    LaundryAppTheme {
        LaundryApp()
    }
}