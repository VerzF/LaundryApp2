package com.trisulaforce.laundryapp.ui.screen.chatbot

import android.annotation.SuppressLint
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.ai.client.generativeai.Chat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomieScreen(modifier: Modifier = Modifier) {
    var showWebView by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Web View")
                },
                navigationIcon = {
                    if (showWebView) {
                        IconButton(onClick = { showWebView = false }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "back"
                            )
                        }
                    }
                }
            )
        },
        modifier = modifier
    ) { paddingValues ->
        HomieContent(
            showWebView = showWebView,
            onButtonClick = {
                showWebView = true
            },
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun HomieContent(showWebView: Boolean, onButtonClick: () -> Unit, modifier: Modifier = Modifier) {
    val url = "https://chatbothomie.s3.us-south.cloud-object-storage.appdomain.cloud/chatbot_mobile.html" // URL chatbot

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        if (!showWebView) {
            Button(
                onClick = onButtonClick,
                colors = ButtonDefaults.buttonColors(Color.Blue)
            ) {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "icon chatbot",
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Homie", color = Color.White)
            }
        } else {
            AndroidView(
                factory = {
                    WebView(it).apply {
                        layoutParams = ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT
                        )
                        webViewClient = WebViewClient()
                        settings.javaScriptEnabled = true
                        loadUrl(url)
                    }
                },
                update = {
                    it.loadUrl(url)
                },
                modifier = Modifier
            )
        }
    }
}
