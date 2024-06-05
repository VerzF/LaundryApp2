package com.trisulaforce.laundryapp.ui.screen.kenali

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.trisulaforce.laundryapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KenaliAplikasiKamiScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Deskripsi Aplikasi",
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center,
                        lineHeight = 1.5.em,
                        style = TextStyle(
                            fontSize = 16.sp,
                            letterSpacing = 0.15.sp
                        )
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                            contentDescription = "Back",
                            tint = Color(0xff1a1c20)
                        )
                    }
                }
            )
        },
        content = { padding ->
            KenaliAplikasiKami(Modifier.padding(padding))
        }
    )
}

@Composable
fun KenaliAplikasiKami(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(360.dp)
            .requiredHeight(800.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(Color(0xffd9e2ff))
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(y = 263.dp)
                .requiredWidth(360.dp)
                .requiredHeight(573.dp)
        ) {
            Box(
                modifier = Modifier
                    .requiredWidth(360.dp)
                    .requiredHeight(573.dp)
                    .clip(RoundedCornerShape(40.dp))
                    .background(
                        Brush.linearGradient(
                            colors = listOf(Color.White, Color(0xffd9e2ff)),
                            start = Offset(180f, 0f),
                            end = Offset(180f, 573f)
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 13.dp, y = 34.dp)
                    .requiredWidth(334.dp)
                    .requiredHeight(525.dp)
            ) {
                Box(
                    modifier = Modifier
                        .requiredWidth(333.dp)
                        .requiredHeight(89.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .requiredWidth(333.dp)
                            .requiredHeight(10.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .background(Color(0xff465d91))
                    )
                    Text(
                        text = "Dengan HOMIE, Anda dapat menikmati layanan laundry berkualitas tanpa harus keluar rumah. Kami menawarkan berbagai layanan mulai dari cuci kering, cuci setrika, hingga dry cleaning dengan proses yang cepat dan hasil yang memuaskan.",
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 8.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .offset(x = (-2).dp, y = 28.dp)
                            .requiredWidth(305.dp)
                            .requiredHeight(46.dp)
                    )
                    Text(
                        text = "Selamat Datang di HOMIE",
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .offset(x = (-71.04).dp, y = 10.64.dp)
                            .requiredWidth(167.dp)
                            .requiredHeight(13.dp)
                    )
                }
//                Spacer(modifier = Modifier.height(16.dp))
                Box(
                    modifier = Modifier
                        .requiredWidth(333.dp)
                        .requiredHeight(74.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .requiredWidth(333.dp)
                            .requiredHeight(74.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .background(Color(0xff465d91))
                    )
                    Text(
                        text = "Jika Anda memiliki pertanyaan atau membutuhkan bantuan, tim kami siap membantu Anda. Hubungi kami melalui HomieAI yang tersedia di aplikasi",
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 8.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .offset(x = (-2).dp, y = 28.dp)
                            .requiredWidth(305.dp)
                            .requiredHeight(46.dp)
                    )
                    Text(
                        text = "Hubungi Kami",
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .offset(x = (-71.04).dp, y = 10.64.dp)
                            .requiredWidth(167.dp)
                            .requiredHeight(13.dp)
                    )
                }
//                Spacer(modifier = Modifier.height(1.dp))
                Box(
                    modifier = Modifier
                        .requiredWidth(333.dp)
                        .requiredHeight(158.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .requiredWidth(333.dp)
                            .requiredHeight(120.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .background(Color(0xff465d91))
                    )
                    Text(
                        text = " - Penjemputan & Pengantaran Gratis: Kami menyediakan layanan penjemputan dan pengantaran pakaian Anda secara gratis di lokasi yang Anda tentukan.\n - Proses Mudah & Cepat: Dengan beberapa langkah sederhana, Anda bisa memesan layanan laundry langsung dari aplikasi.\n - Pembayaran Aman: Pilih metode pembayaran yang paling nyaman bagi Anda.\n - Layanan Khusus: Kami juga menawarkan layanan tambahan seperti pewangi khusus dan setrika lipat untuk pakaian Anda.",
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 8.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .offset(x = (-8.5).dp, y = 37.dp)
                            .requiredWidth(306.dp)
                            .requiredHeight(80.dp)
                    )
                    Text(
                        text = "Fitur Unggulan Kami",
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .offset(x = (-69.25).dp, y = 12.dp)
                            .requiredWidth(167.dp)
                            .requiredHeight(25.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .offset(x = 3.dp, y = 269.dp)
                        .requiredWidth(330.dp)
                        .requiredHeight(158.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .requiredWidth(330.dp)
                            .requiredHeight(120.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .background(Color(0xff465d91))
                    )
                    Text(
                        text = "Kualitas Terbaik: Kami menggunakan bahan dan teknologi terbaik untuk memastikan pakaian Anda bersih dan rapi.\nTim Profesional: Tim kami terdiri dari tenaga ahli yang berpengalaman dalam menangani berbagai jenis pakaian.\nKenyamanan Maksimal: Kami hadir untuk memudahkan hidup Anda dengan layanan yang bisa diakses dengan mudah.\nHarga Terjangkau: Nikmati layanan yang kami berikan dengan harga yang terjangkau.",
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 8.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .offset(x = (-8.42).dp, y = 37.dp)
                            .requiredWidth(303.dp)
                            .requiredHeight(112.dp)
                    )
                    Text(
                        text = "Kenapa Memilih Kami?",
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .offset(x = (-68.62).dp, y = 12.dp)
                            .requiredWidth(165.dp)
                            .requiredHeight(25.dp)
                    )
                }
            }
        }
        Text(
            text = "Apa itu Homie Laundry?",
            color = Color(0xff001a43),
            lineHeight = 1.em,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = (-0.5).sp


            ),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 196.dp, y = 143.dp)
                .requiredWidth(164.dp)
                .requiredHeight(41.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.gambar11),
            contentDescription = "Pekanbaru Laundry",
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 3.dp, y = 86.dp)
                .requiredWidth(192.dp)
                .requiredHeight(177.dp)
        )
        TypeLightMode(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(y = (-1).dp)
        )
    }
}

@Composable
fun TypeLightMode(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .requiredWidth(360.dp)
            .padding(start = 16.dp, end = 16.dp, top = 6.dp, bottom = 4.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .requiredWidth(17.dp)
                    .requiredHeight(16.dp)
            )
            Box(
                modifier = Modifier
                    .requiredWidth(17.dp)
                    .requiredHeight(16.dp)
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "69%",
                    color = Color(0xff191c1d),
                    textAlign = TextAlign.Center,
                    lineHeight = 10.em,
                    style = TextStyle(
                        fontSize = 12.sp
                    )
                )
                Box(
                    modifier = Modifier
                        .requiredWidth(23.dp)
                        .requiredHeight(24.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0xFFFFFFFF))
                    )
                }
            }
        }
    }
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun KenaliAplikasiKamiPreview() {
    val navController = rememberNavController()
    KenaliAplikasiKamiScreen(navController)
}
