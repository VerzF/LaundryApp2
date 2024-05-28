package com.trisulaforce.laundryapp.Profil

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.foundation.text.BasicText
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
import com.trisulaforce.laundryapp.R

@Composable
fun ProfilScreen() {
    Scaffold(
        bottomBar = { BottomNavigationBar() }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFAF9FF))
                .padding(it)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
            ) {
                Spacer(modifier = Modifier.height(120.dp))
                ProfileHeader()
                Spacer(modifier = Modifier.height(140.dp))
                ProfileActions()
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
fun ProfileHeader() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.vector2),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(160.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Black, CircleShape)
            )
            Icon(
                painter = painterResource(id = R.drawable.typeedit),
                contentDescription = "Edit Icon",
                modifier = Modifier
                    .size(32.dp)
                    .align(Alignment.BottomEnd)
                    .offset(x = (-8).dp, y = (-8).dp) // Offset for positioning inside the image
                    .padding(6.dp)
            )}
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Iqbaal Ramadhan",
            style = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                lineHeight = 2.91.em
            ),
            textAlign = TextAlign.Center
        )
        Text(
            text = "iqbaalramadhan@gmail.com",
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
fun ProfileActions() {
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Button(
            onClick = { /* TODO: Add order history functionality */ },
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
            onClick = { /* TODO: Add logout functionality */ },
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

@Composable
fun BottomNavigationBar() {BottomAppBar(
    containerColor = Color.White,
    contentColor = Color.Black,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color(0xFFFAF9FF))
    ) {
        BottomNavItem(
            icon = R.drawable.home,
            label = "Home",
            isSelected = false,
            onClick = { /* TODO: Handle Home Click */ }
        )
        Spacer(modifier = Modifier.width(16.dp)) // Mengurangi lebar spacer di sini
        BottomNavItem(
            icon = R.drawable.notifikasi,
            label = "Notifications",
            isSelected = false,
            onClick = { }
        )
        Spacer(modifier = Modifier.width(16.dp)) // Mengurangi lebar spacer di sini
        BottomNavItem(
            icon = R.drawable.profile,
            label = "Profil",
            isSelected = true,
            onClick = { /* TODO: Handle Profile Click */ }
        )
    }
}

}



@Composable
fun BottomNavItem(
    icon: Int,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp)
            .padding(horizontal = 30.dp)
    ) {
        val color = if (isSelected) Color.Black else Color(0xFF44474F)
        if (isSelected) {

        }
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "$label Icon",
            tint = color,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = label,
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = color,
                lineHeight = 1.33.em
            )
        )
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
fun ProfilScreenPreview() {
    ProfilScreen()
}

