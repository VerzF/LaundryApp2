@file:OptIn(ExperimentalMaterial3Api::class)

package com.trisulaforce.laundryapp.Profil

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.trisulaforce.laundryapp.R

@Composable
fun editprofil(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        TopAppBar(
            title = {
                Text(
                    text = "Edit Profil",
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            },
            navigationIcon = {
                IconButton(onClick = { /* Handle back navigation */ }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color(0xff1a1c20)
                    )
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Transparent)
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                ProfileImageSection()
            }
            item {
                UserProfileInput(
                    imageRes = R.drawable.akun,
                    label = "Nama Lengkap",
                    placeholder = "Nama Lengkap"
                )
            }
            item {
                UserProfileInput(
                    imageRes = R.drawable.email,
                    label = "Email",
                    placeholder = "Email"
                )
            }
            item {
                UserProfileInput(
                    imageRes = R.drawable.telepon,
                    label = "Nomor Telepon",
                    placeholder = "Masukkan nomor telepon"
                )
            }
            item {
                UserProfileInput(
                    imageRes = R.drawable.alamat,
                    label = "Alamat",
                    placeholder = "Masukkan alamat"
                )
            }
            item {
                UserProfileInput(
                    imageRes = R.drawable.sandi,
                    label = "Kata Sandi Baru",
                    placeholder = "Masukkan kata sandi baru"
                )
            }
            item {
                SaveButton()
            }
        }
    }
}

@Composable
fun ProfileImageSection() {
    Box(
        modifier = Modifier
            .size(120.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(Color(0xff999999))
            .border(BorderStroke(2.dp, Color.Black), RoundedCornerShape(100.dp))
    ) {
        IconButton(
            onClick = { /* Handle change profile image */ },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(x = (-16).dp, y = 16.dp)
                .size(36.dp)
                .clip(CircleShape)
                .background(Color(0xffeac16c))
                .border(BorderStroke(2.dp, Color.Black), CircleShape)
        ) {
            Image(
                painter = painterResource(id = R.drawable.photo_camera_24dp_fill0_wght400_grad0_opsz24),
                contentDescription = "Change Profile Image",
            )
        }
    }
}

@Composable
fun UserProfileInput(
    imageRes: Int,
    label: String,
    placeholder: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xfff9f9ff))
            .border(BorderStroke(2.dp, Color(0xff74777f)), RoundedCornerShape(10.dp))
            .padding(horizontal = 24.dp, vertical = 16.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = label,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(
                text = placeholder,
                color = Color.Gray,
                style = TextStyle(fontSize = 14.sp, letterSpacing = 0.25.sp)
            )
        }
    }
}

@Composable
fun SaveButton() {
    Button(
        onClick = { /* Handle save action */ },
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(100.dp))
            .background(Color(0xff465d91)),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xff465d91))
    ) {
        Image(
            painter = painterResource(id = R.drawable.photo_camera_24dp_fill0_wght400_grad0_opsz24),
            contentDescription = "Change Profile Image",
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Save",
            color = Color.White,
            style = TextStyle(fontSize = 16.sp)
        )
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
private fun editprofilPreview() {
    editprofil()
}
