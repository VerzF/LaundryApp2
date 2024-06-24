package com.trisulaforce.laundryapp

import androidx.compose.animation.AnimatedVisibility
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
import com.trisulaforce.laundryapp.model.DataNotifikasi.notifikasi
import com.trisulaforce.laundryapp.ui.screen.menunggu.Menunggu
import com.trisulaforce.laundryapp.model.DataPesanan.orders
import com.trisulaforce.laundryapp.ui.screen.profil.Editprofil
import com.trisulaforce.laundryapp.model.Layanan
import com.trisulaforce.laundryapp.ui.screen.profil.ProfilScreen
import com.trisulaforce.laundryapp.ui.screen.forgotpassword.CekEmail
import com.trisulaforce.laundryapp.ui.screen.forgotpassword.LupaKataSandi
import com.trisulaforce.laundryapp.ui.navigation.NavigationItem
import com.trisulaforce.laundryapp.ui.navigation.Screen
import com.trisulaforce.laundryapp.ui.screen.beranda.Beranda
import com.trisulaforce.laundryapp.ui.screen.chatbot.chatbotScreen
import com.trisulaforce.laundryapp.ui.screen.forgotpassword.daftar.DaftarScreen
import com.trisulaforce.laundryapp.ui.screen.forgotpassword.KataSandiBaru
import com.trisulaforce.laundryapp.ui.screen.forgotpassword.KonfirmasiKataSandi
import com.trisulaforce.laundryapp.ui.screen.forgotpassword.ResetKataSandi
import com.trisulaforce.laundryapp.ui.screen.kenali.KenaliAplikasiKamiScreen
import com.trisulaforce.laundryapp.ui.screen.kenali.PenggunaanAplikasiKamiScreen
import com.trisulaforce.laundryapp.ui.screen.layanan.ScreenLayanan
import com.trisulaforce.laundryapp.ui.screen.masuk.Masuk
import com.trisulaforce.laundryapp.ui.screen.menunggu.Konfirmasi
import com.trisulaforce.laundryapp.ui.screen.notifikasi.Notification
import com.trisulaforce.laundryapp.ui.screen.pesanan.DetailPesanan
import com.trisulaforce.laundryapp.ui.screen.pesanan.RiwayatPesanan
import com.trisulaforce.laundryapp.ui.screen.splashscreen.Onboarding
import com.trisulaforce.laundryapp.ui.screen.utils.shouldShowBottomBar
import com.trisulaforce.laundryapp.ui.theme.LaundryAppTheme

@Composable
fun LaundryApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val services = listOf(
        Layanan(id = 1, image = R.drawable.laundry1, title = "Nyuci Kering (Min. 2kg)", price = 4000),
        Layanan(id = 2, image = R.drawable.laundry1, title = "Cuci Selimut", price = 12000)
    )

    Scaffold(
        bottomBar = {
            AnimatedVisibility(
                visible = currentRoute.shouldShowBottomBar()
            ) {
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
                Notification(navController, notifikasi)
            }

            composable(Screen.LupaKataSandi.route){
                LupaKataSandi(navController = navController)
            }

            composable(Screen.CekEmail.route){
                CekEmail(navController = navController)
            }

            composable(Screen.ResetKataSandi.route){
                ResetKataSandi(navController = navController)
            }

            composable(Screen.KonfirmasiKataSandi.route){
                KonfirmasiKataSandi(navController = navController)
            }

            composable(Screen.KataSandiBaru.route){
                KataSandiBaru(navController)
            }

            composable(Screen.Masuk.route){
                Masuk(navController, Modifier)
            }

            composable(Screen.Onboarding.route){
                Onboarding(navController = navController, modifier = Modifier) {}
            }

            composable(Screen.DaftarScreen.route){
                DaftarScreen(navController)
            }

            composable(Screen.Editprofil.route){
                Editprofil(navController)
            }

            composable(Screen.DetailPesanan.route){
                DetailPesanan(navController = navController, initialServices = services)
            }

            composable(Screen.RiwayatPesanan.route){
                RiwayatPesanan(navController, orders = orders )
            }

            composable(Screen.ScreenLayanan.route){
                ScreenLayanan(navController)
            }
            
            composable(Screen.Menunggu.route){
                Menunggu(navController)
            }

            composable(Screen.Konfirmasi.route){
                Konfirmasi(navController)
            }

            composable(Screen.Kenali.route){
                KenaliAplikasiKamiScreen(navController)
            }

            composable(Screen.Penggunaan.route){
                PenggunaanAplikasiKamiScreen(navController)
            }
            composable(Screen.chatbotScreen.route) {
                chatbotScreen()
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