package com.trisulaforce.laundryapp.Notifikasi

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.trisulaforce.laundryapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationTopAppBar() {
    TopAppBar(
        title = {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(text = "Notifikasi", color = Color.Black)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
    )
}

@Composable
fun BottomNavigationBar() {
    BottomAppBar(
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
            BottomNavItem(
                icon = R.drawable.notifikasi,
                label = "Notifications",
                isSelected = false,
                onClick = { /* TODO: Handle Notifications Click */ }
            )
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

@Preview
@Composable
fun NotificationTopAppBarPreview() {
    NotificationTopAppBar()
}

@Preview
@Composable
fun BottomNavigationBarPreview() {
    BottomNavigationBar()
}
