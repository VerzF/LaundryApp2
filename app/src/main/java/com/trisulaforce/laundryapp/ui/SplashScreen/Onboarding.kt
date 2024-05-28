package com.trisulaforce.laundryapp.ui.SplashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Tab
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.trisulaforce.laundryapp.R


@Composable
fun Onboarding(modifier: Modifier = Modifier, onFinish: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .requiredWidth(360.dp)
            .requiredHeight(800.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(
                Brush.linearGradient(
                    colors = listOf(Color(0xffd9e2ff), Color.White),
                    start = Offset(180f, 0f),
                    end = Offset(180f, 800f)
                )
            )
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 64.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SizeSmall()
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color(0xff465d91),
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold
                            )
                        ) { append("PEKANBARU\n") }
                        withStyle(
                            style = SpanStyle(
                                color = Color(0xff465d91),
                                fontSize = 16.sp
                            )
                        ) { append("Laundry") }
                    },
                    modifier = Modifier.requiredWidth(135.dp)
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "Pekanbaru Laundry (7) 1",
                    modifier = Modifier
                        .requiredWidth(256.dp)
                        .requiredHeight(260.dp)
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(70.dp, Alignment.Top),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Membersihkan pakaianmu \ndengan mudah, praktis, \ndan cepat.",
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        lineHeight = 1.5.em,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Tab(
                    selected = false,
                    onClick = { onFinish() },
                    text = {
                        Text(
                            text = "Mulai sekarang",
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            lineHeight = 1.43.em,
                            style = TextStyle(
                                fontSize = 14.sp,
                                letterSpacing = 0.25.sp
                            ),
                            modifier = Modifier.wrapContentHeight(align = Alignment.CenterVertically)
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(100.dp))
                        .background(color = Color(0xff465d91))
                        .padding(horizontal = 16.dp, vertical = 14.dp)
                )
                Tab(
                    selected = false,
                    onClick = { onFinish() },
                    text = {
                        Text(
                            text = "Saya sudah punya akun",
                            color = Color(0xff425e91),
                            textAlign = TextAlign.Center,
                            lineHeight = 1.43.em,
                            style = TextStyle(
                                fontSize = 14.sp,
                                letterSpacing = 0.25.sp
                            ),
                            modifier = Modifier.wrapContentHeight(align = Alignment.CenterVertically)
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .padding(horizontal = 16.dp, vertical = 14.dp)
                )
            }
        }
    }
}

@Composable
fun SizeSmall(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(horizontal = 6.dp, vertical = 8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logoapp1-01 1",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .requiredWidth(54.dp)
                .requiredHeight(48.dp)
        )
    }
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun OnboardingPreviewContent() {
    Onboarding(modifier = Modifier) {}
}

