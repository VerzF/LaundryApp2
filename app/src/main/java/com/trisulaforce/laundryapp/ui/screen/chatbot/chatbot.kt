package com.trisulaforce.laundryapp.ui.screen.chatbot

import android.annotation.SuppressLint
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun chatbotScreen(navController: NavController, modifier: Modifier = Modifier) {
    // Variabel state untuk melacak apakah WebView harus ditampilkan
    var showWebView by remember { mutableStateOf(false) }

    // Komponen Scaffold untuk struktur layar
    Scaffold(
        topBar = {
            // TopAppBar dengan judul dan tombol kembali opsional
            TopAppBar(
                title = {
                    Text(text = "Homei ai")
                },
                navigationIcon = {
                    if (showWebView) {
                        // Tampilkan tombol kembali saat WebView ditampilkan
                        IconButton(onClick = { showWebView = false }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "kembali"
                            )
                        }
                    }
                }
            )
        },
        modifier = Modifier.navigationBarsPadding(), // Terapkan padding untuk navigation bars
        content = { paddingValues ->
            // Konten layar
            chatbotScreen(
                showWebView = showWebView,
                onButtonClick = {
                    // Tampilkan WebView saat tombol diklik
                    showWebView = true
                },
                modifier = Modifier.padding(paddingValues) // Terapkan padding dari Scaffold
            )
        }
    )
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun chatbotScreen(showWebView: Boolean, onButtonClick: () -> Unit, modifier: Modifier = Modifier) {
    // URL untuk chatbot
    val url = "https://chatbothomie.s3.us-south.cloud-object-storage.appdomain.cloud/chatbot_mobile.html"

    // Kolom untuk mengatur konten di tengah
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        if (!showWebView) {
            // Tombol untuk membuka WebView
            Button(
                onClick = onButtonClick,
                colors = ButtonDefaults.buttonColors(Color.Blue)
            ) {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "ikon chatbot",
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(4.dp)) // Spasi antara ikon dan teks
                Text(text = "Homie", color = Color.White)
            }
        } else {
            // Tampilkan WebView saat showWebView bernilai true
            AndroidView(
                factory = {
                    WebView(it).apply {
                        layoutParams = ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT
                        )
                        webViewClient = WebViewClient()
                        settings.javaScriptEnabled = true // Aktifkan JavaScript
                        loadUrl(url) // Muat URL
                    }
                },
                update = {
                    it.loadUrl(url) // Muat ulang URL saat diperlukan
                },
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun HomieScreenPreview() {
    // Fungsi pratinjau untuk HomieScreen
    val navController = rememberNavController()
    chatbotScreen(navController = navController)
}
