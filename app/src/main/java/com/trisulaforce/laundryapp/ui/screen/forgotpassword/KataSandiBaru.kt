package com.trisulaforce.laundryapp.ui.screen.forgotpassword

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.trisulaforce.laundryapp.R
import com.trisulaforce.laundryapp.ui.navigation.Screen
import com.trisulaforce.laundryapp.ui.theme.AppTypography
import com.trisulaforce.laundryapp.ui.theme.LaundryAppTheme
import com.trisulaforce.laundryapp.ui.theme.backgroundLight
import com.trisulaforce.laundryapp.ui.theme.onBackgroundLight
import com.trisulaforce.laundryapp.ui.theme.onPrimaryLight
import com.trisulaforce.laundryapp.ui.theme.primaryLight

@Composable
fun KataSandiBaru(navController: NavController, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(24.dp))
            .background(backgroundLight)
    ) {
        Column(
            modifier = Modifier
                .requiredWidth(width = 360.dp)
                .requiredHeight(height = 800.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(48.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 24.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .requiredWidth(width = 312.dp)
                ) {
                    IconButton(
                        onClick = { navController.navigateUp() }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_leftarrow),
                            contentDescription = "Icons",
                            tint = primaryLight)
                    }
                    Text(
                        text = "Lupa Kata Sandi",
                        color = primaryLight,
                        textAlign = TextAlign.Center,
                        lineHeight = 1.27.em,
                        style = AppTypography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .wrapContentHeight(align = Alignment.CenterVertically))
                    IconButton(onClick = {  }) { }
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Masukkan password anda yang baru. Pastikan password anda yang baru berbeda dari password anda yang sebelumnya untuk keamanan.",
                        color = onBackgroundLight,
                        textAlign = TextAlign.Center,
                        lineHeight = 1.43.em,
                        style = AppTypography.bodyMedium,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(align = Alignment.CenterVertically))
                    Column (
                        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        var password by rememberSaveable { mutableStateOf("") }
                        var passwordHidden by rememberSaveable { mutableStateOf(true) }
                        val visibilityIcon = painterResource(id = if (passwordHidden) R.drawable.ic_visibility else R.drawable.ic_visibility_off)

                        OutlinedTextField(
                            value = password,
                            onValueChange = { password = it },
                            singleLine = true,
                            label = {
                                Text(
                                    text = "Kata sandi baru",
                                    color = onBackgroundLight,
                                    style = AppTypography.labelLarge
                                ) },
                            visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_lock),
                                    contentDescription = "Password",
                                    tint = onBackgroundLight
                                )
                            },
                            trailingIcon = {
                                IconButton(onClick = { passwordHidden = !passwordHidden }) {
                                    // Please provide localized description for accessibility services
                                    val description = if (passwordHidden) "Show password" else "Hide password"
                                    Icon(
                                        painter = visibilityIcon,
                                        contentDescription = description,
                                        tint = onBackgroundLight
                                    )
                                }
                            },
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.fillMaxWidth()
                        )
                        OutlinedTextField(
                            value = password,
                            onValueChange = { password = it },
                            singleLine = true,
                            label = {
                                Text(
                                    text = "Konfirmasi kata sandi",
                                    color = onBackgroundLight,
                                    style = AppTypography.labelLarge
                                ) },
                            visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_lock),
                                    contentDescription = "Password",
                                    tint = onBackgroundLight

                                )
                            },
                            trailingIcon = {
                                IconButton(onClick = { passwordHidden = !passwordHidden }) {
                                    // Please provide localized description for accessibility services
                                    val description = if (passwordHidden) "Show password" else "Hide password"
                                    Icon(
                                        painter = visibilityIcon,
                                        contentDescription = description,
                                        tint = onBackgroundLight
                                    )
                                }
                            },
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
                Button(
                    onClick = {navController.navigate(Screen.KonfirmasiKataSandi.route)},
                    colors = ButtonDefaults.buttonColors(containerColor = primaryLight),
                    contentPadding = PaddingValues(
                        horizontal = 16.dp,
                        vertical = 16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Perbarui",
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
                .offset(
                    x = (-6).dp,
                    y = 617.dp
                )
                .requiredWidth(width = 444.dp)
                .requiredHeight(height = 183.dp))
    }
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun KataSandiBaruPreview() {
    val navController = rememberNavController()
    LaundryAppTheme {
        KataSandiBaru(navController)
    }
}