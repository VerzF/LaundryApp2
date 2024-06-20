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
fun KenaliAplikasiKamiScreen
            (navController: NavController) {
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
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.gambar11),
                contentDescription = "Pekanbaru Laundry",
                modifier = Modifier
                    .size(width = 192.dp, height = 177.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Apa itu Homie Laundry?",
                color = Color(0xff001a43),
                lineHeight = 1.em,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = (-0.5).sp
                )
            )
        }
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color(0xff465d91)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Selamat Datang di HOMIE",
                    color = Color.White,
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Dengan HOMIE, Anda dapat menikmati layanan laundry berkualitas tanpa harus keluar rumah. Kami menawarkan berbagai layanan mulai dari cuci kering, cuci setrika, hingga dry cleaning dengan proses yang cepat dan hasil yang memuaskan.",
                    color = Color.White,
                    style = TextStyle(
                        fontSize = 8.sp,
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color(0xff465d91)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Fitur Unggulan Kami",
                    color = Color.White,
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "1. Penjemputan & Pengantaran Gratis: Kami menyediakan layanan penjemputan dan pengantaran pakaian Anda secara gratis di lokasi yang Anda tentukan.\n\n" +
                            "2. Proses Mudah & Cepat: Dengan beberapa langkah sederhana, Anda bisa memesan layanan laundry langsung dari aplikasi.\n\n" +
                            "3. Pembayaran Aman: Pilih metode pembayaran yang paling nyaman bagi Anda.\n\n" +
                            "4. Layanan Khusus: Kami juga menawarkan layanan tambahan seperti pewangi khusus dan setrika lipat untuk pakaian Anda.",
                    color = Color.White,
                    style = TextStyle(
                        fontSize = 8.sp,
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color(0xff465d91)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Kenapa Memilih Kami?",
                    color = Color.White,
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "1. Kualitas Terbaik: Kami menggunakan bahan dan teknologi terbaik untuk memastikan pakaian Anda bersih dan rapi.\n\n" +
                            "2. Tim Profesional: Tim kami terdiri dari tenaga ahli yang berpengalaman dalam menangani berbagai jenis pakaian.\n\n" +
                            "3. Kenyamanan Maksimal: Kami hadir untuk memudahkan hidup Anda dengan layanan yang bisa diakses dengan mudah.\n\n" +
                            "4. Harga Terjangkau: Nikmati layanan yang kami berikan dengan harga yang terjangkau.",
                    color = Color.White,
                    style = TextStyle(
                        fontSize = 8.sp,
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color(0xff465d91)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Hubungi Kami",
                    color = Color.White,
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Jika Anda memiliki pertanyaan atau membutuhkan bantuan, tim kami siap membantu Anda. Hubungi kami melalui HomieAI yang tersedia di aplikasi.",
                    color = Color.White,
                    style = TextStyle(
                        fontSize = 8.sp,
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
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
