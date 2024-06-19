package com.trisulaforce.laundryapp.ui.screen.kenali

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
fun PenggunaanAplikasiKamiScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Penggunaan Aplikasi",
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
            PenggunaanAplikasi(Modifier.padding(padding))
        }
    )
}

@Composable
fun PenggunaanAplikasi(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
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
                    text = "Cara menggunakan aplikasi?",
                    color = Color(0xff001a43),
                    lineHeight = 1.em,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        letterSpacing = (-0.5).sp,
                        textAlign = TextAlign.Start
                    )
                )
            }
        }
        item {
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
                        text = "1. Daftar atau Masuk ke Aplikasi",
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Daftar : Jika belum memiliki akun, klik tombol “Daftar” dan isi formulir pendaftaran dengan informasi yang diperlukan seperti nama, email, nomor, telepon, dan kata sandi.\n" +
                                "Masuk : Jika sudah memiliki akun, klik tombol “Masuk” dan masukkan email dan kata sandi yang telah terdaftar..",
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
        item {
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
                        text = "2. Pilih Layanan Laundry",
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Setelah berhasil masuk, Anda akan diarahkan ke halaman beranda yang menampilkan berbagai layanan laundry yang tersedia.\n" +
                                "Pilih jenis yang diinginkan, misalnya ‘Kiloan Reguler”, “Cuci Kering”, “Setrika”, atau lainnya.",
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
        item {
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
                        text = "3. Masukkan Detail Pesanan",
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Masukkan jumlah pakaian yang akan dicuci dan pilih layanan tambahan jika ada, seperti pewangi khusus atau setrika lipat.\n" +
                                "Pastikan semua informasi sudah benar sebelum melanjutkan.",
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
        item {
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
                        text = "4. Konfirmasi Pesanan",
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Periksa kembali detail pesanan Anda termasuk layanan yang dipilih, lokasi penjemputan, dan waktu.\n" +
                                "Klik tombol “Pesan Sekarang” untuk melanjutkan ke tahap pembayaran.",
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
        item {
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
                        text = "5. Pembayaran ",
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Pilih metode pembayaran yang tersedia.\n" +
                                "Masukkan informasi pembayaran yang diperlukan dan selesaikan transaksi.",
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
        item {
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
                        text = "6. Penjemputan Pakaian ",
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Pada waktu yang telah Anda tentukan, petugas laundry akan datang ke lokasi penjemputan untuk mengambil Anda.\n" +
                                "Pastikan Anda atau orang yang Anda percayai siap menyerahkan kepada petugas.",
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
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun PenggunaanAplikasiKamiPreview() {
    val navController = rememberNavController()
    PenggunaanAplikasiKamiScreen(navController)
}
