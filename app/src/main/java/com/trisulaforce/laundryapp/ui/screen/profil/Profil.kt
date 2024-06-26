package com.trisulaforce.laundryapp.ui.screen.profil

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.trisulaforce.laundryapp.model.DataUser.users
import com.trisulaforce.laundryapp.ui.navigation.Screen
import com.trisulaforce.laundryapp.ui.theme.primaryLight

@Composable
fun ProfilScreen(navController: NavController, contentPadding: PaddingValues) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFAF9FF))
                .padding(contentPadding)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
            ) {
                Spacer(modifier = Modifier.height(120.dp))
                ProfileHeader(navController)
                Spacer(modifier = Modifier.height(140.dp))
                ProfileActions(navController)
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }

@Composable
fun ProfileHeader(navController: NavController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box {
            Image(
                painter = painterResource(id = users.profileImage),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(160.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Black, CircleShape)
            )
            IconButton(
                onClick = { navController.navigate(Screen.Editprofil.route) }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_leftarrow),
                    contentDescription = "Icons",
                    tint = primaryLight
                    )
                }
            }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = users.fullName,
            style = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                lineHeight = 2.91.em
            ),
            textAlign = TextAlign.Center
        )
        Text(
            text = users.email,
            style = TextStyle(
                fontSize = 14.sp,
                color = Color(0xFF545252),
                lineHeight = 1.33.em
            ),
            textAlign = TextAlign.Center,
//            verticalArrangement = Arrangement.spacedBy(100.dp)
        )
    }
}

@Composable
fun ProfileActions(navController: NavController) {
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Button(
            onClick = { navController.navigate(Screen.RiwayatPesanan.route) },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(100.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFDEA0))
        ) {
            Icon(
                painter = painterResource(id = R.drawable.typepesanan),
                contentDescription = "Order History Icon",
                tint = Color(0xFF261A00),
                        modifier = Modifier
                        .size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Riwayat Pesanan",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF261A00),
                    lineHeight = 1.43.em

                )
            )
        }
        Button(
            onClick = { navController.navigate(Screen.Masuk.route) },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(100.dp),
            colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent),
            border = BorderStroke(2.dp, Color(0xFFBA1A1A))
        ) {
            Icon(
                painter = painterResource(id = R.drawable.typelogout),
                contentDescription = "Logout Icon",
                tint = Color(0xFFBA1A1A),
                modifier = Modifier
                    .size(24.dp) // Sesuaikan ukuran ikon yang lebih besar
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Keluar Akun",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFFBA1A1A),
                    lineHeight = 1.43.em
                )
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
fun ProfilScreenPreview() {
    val navController = rememberNavController()
    ProfilScreen(navController, PaddingValues())
}