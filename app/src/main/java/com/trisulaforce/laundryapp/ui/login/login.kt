package com.trisulaforce.laundryapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

class Masuk : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}

@Composable
fun Masuk(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(360.dp)
            .requiredHeight(800.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .requiredWidth(360.dp)
                .requiredHeight(800.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.tsunamiatas),
                    contentDescription = "Top Image",
                    modifier = Modifier.fillMaxWidth()
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 30.dp)
                ) {
                    IconButton(onClick = { /* Handle back action */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                            contentDescription = "Back Icon",
                            tint = Color(0xff465d91)
                        )
                    }
                    Text(
                        text = "Masuk",
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        lineHeight = 1.27.em,
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.wrapContentHeight(align = Alignment.CenterVertically)
                    )
                    IconButton(onClick = { }) { /* Handle other action */ }
                }
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
            ) {
                    Text(
                        text = "Masuk ke akun anda",
                        color = Color.Black.copy(alpha = 0.8f),
                        textAlign = TextAlign.Center,
                        lineHeight = 1.43.em,
                        style = TextStyle(fontSize = 14.sp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(align = Alignment.CenterVertically)
                    )
                    var text by rememberSaveable { mutableStateOf("") }
                    OutlinedTextField(
                        value = text,
                        onValueChange = { text = it },
                        label = { Text(text = "Email") },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.email),
                                contentDescription = "Email"
                            )
                        },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    )
                    var password by rememberSaveable { mutableStateOf("") }
                    var passwordHidden by remember { mutableStateOf(true) }
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text(text = "Kata Sandi") },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.sandi),
                                contentDescription = "Kata Sandi"
                            )
                        },
                        trailingIcon = {
                            IconButton(onClick = { passwordHidden = !passwordHidden }) {
                                val visibilityIcon = if (passwordHidden) R.drawable.ic_visibility else R.drawable.ic_visibility_off
                                val description = if (passwordHidden) "Show password" else "Hide password"
                                Icon(painter = painterResource(id = visibilityIcon), contentDescription = description)
                            }
                        },
                        visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            var rememberMe by rememberSaveable { mutableStateOf(false) }
                            Checkbox(
                                checked = rememberMe,
                                onCheckedChange = { rememberMe = it },
                                modifier = Modifier.padding(end = 8.dp)
                            )
                            Text(text = "Ingat Saya", color = Color.Black.copy(alpha = 0.8f))
                        }
                        Text(
                            text = "Lupa Kata Sandi?",
                            color = Color(0xff465d91),
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }

                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xff465d91)),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Masuk",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        lineHeight = 1.43.em,
                        style = TextStyle(
                            fontSize = 14.sp,
                            letterSpacing = 0.25.sp
                        ),
                        modifier = Modifier.wrapContentHeight(align = Alignment.CenterVertically)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Belum punya akun? ",
                        color = Color.Black.copy(alpha = 0.8f)
                    )
                    Text(
                        text = "Daftar",
                        color = Color(0xff465d91),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }
        }
    }
    @Preview(widthDp = 360, heightDp = 800)
    @Composable
    private fun MasukPreview() {
        Masuk(Modifier)
    }
