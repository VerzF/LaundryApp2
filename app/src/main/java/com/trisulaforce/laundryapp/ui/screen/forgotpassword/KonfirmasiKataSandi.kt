package com.trisulaforce.laundryapp.ui.screen.forgotpassword

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.trisulaforce.laundryapp.R
import com.trisulaforce.laundryapp.ui.theme.AppTypography
import com.trisulaforce.laundryapp.ui.theme.backgroundLight
import com.trisulaforce.laundryapp.ui.theme.onBackgroundLight
import com.trisulaforce.laundryapp.ui.theme.onPrimaryLight
import com.trisulaforce.laundryapp.ui.theme.primaryLight

@Composable
fun KonfirmasiKataSandi(navController: NavController, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 360.dp)
            .requiredHeight(height = 800.dp)
            .clip(shape = RoundedCornerShape(24.dp))
            .background(backgroundLight)
    ) {
        Column(
            modifier = Modifier
                .requiredWidth(width = 360.dp)
                .requiredHeight(height = 800.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(48.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 24.dp,
                        end = 24.dp,
                        top = 24.dp,
                        bottom = 120.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.successful),
                    contentDescription = "successful",
                    modifier = Modifier
                        .requiredSize(size = 104.dp))
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                            text = "Sukses",
                            color = onBackgroundLight,
                            textAlign = TextAlign.Center,
                            lineHeight = 1.27.em,
                            style = AppTypography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .wrapContentHeight(align = Alignment.CenterVertically))
                    Column(
                        verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Selamat! Kata sandi anda telah diubah. Klik selanjutnya untuk masuk",
                            color = onBackgroundLight,
                            textAlign = TextAlign.Center,
                            lineHeight = 1.43.em,
                            style = AppTypography.bodyMedium,
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight(align = Alignment.CenterVertically))
                    }
                }
                Button(
                    onClick = { navController.navigate("login")},
                    colors = ButtonDefaults.buttonColors(containerColor = primaryLight),
                    contentPadding = PaddingValues(
                        horizontal = 16.dp,
                        vertical = 16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Selanjutnya",
                        color = onPrimaryLight,
                        textAlign = TextAlign.Center,
                        lineHeight = 1.43.em,
                        style = AppTypography.labelLarge,
                        modifier = Modifier
                            .wrapContentHeight(align = Alignment.CenterVertically)
                    )
                }
            }
        }
        Image(
            painter = painterResource(id = R.drawable.wave_forgotpassword),
            contentDescription = "Vector 3",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = (-6).dp,
                    y = 617.dp)
                .requiredWidth(width = 444.dp)
                .requiredHeight(height = 183.dp))
    }
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun KonfirmasiKataSandiPreview() {
    val navController = rememberNavController()
    KonfirmasiKataSandi(navController = navController, modifier = Modifier)
}