package com.trisulaforce.laundryapp.ui.SplashScreen

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.trisulaforce.laundryapp.ui.theme.LaundryAppTheme
import com.trisulaforce.laundryapp.R

class HomieSplash : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaundryAppTheme {
                val navController = rememberNavController()
                SplashScreenContent(navController)
            }
        }
    }

    @Composable
    fun SplashScreenContent(navController: NavController) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            SizeLarge()

            // Navigate to the onboarding screen after a delay
            LaunchedEffect(Unit) {
                Handler(Looper.getMainLooper()).postDelayed({
                    navController.navigate("onboarding")
                }, 3000)
            }
        }
    }

    @Composable
    fun SizeLarge(modifier: Modifier = Modifier) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            contentScale = ContentScale.Crop,
            modifier = modifier.size(240.dp)
        )
    }

    @Preview(showBackground = true)
    @Composable
    private fun SplashScreenPreview() {
        LaundryAppTheme {
            val navController = rememberNavController()
            SplashScreenContent(navController)
        }
    }
}
