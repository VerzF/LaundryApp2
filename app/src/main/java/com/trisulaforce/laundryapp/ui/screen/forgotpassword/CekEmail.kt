package com.trisulaforce.laundryapp.ui.screen.forgotpassword

import android.widget.Toast
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
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
fun CekEmail(navController: NavController) {
    var otpValue by remember { mutableStateOf("") }
    val maxOtpLength = 5
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundLight)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(48.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
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
                            tint = primaryLight
                        )
                    }
                    Text(
                        text = "Cek Email Anda",
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
                        text = "Kita telah mengirimkan 5 digit kode pada email Anda",
                        color = onBackgroundLight,
                        textAlign = TextAlign.Center,
                        lineHeight = 1.43.em,
                        style = AppTypography.bodyMedium,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(align = Alignment.CenterVertically))
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        for (i in 0 until maxOtpLength) {
                            OTPTextField(
                                value = if (otpValue.length > i) otpValue[i].toString() else "",
                                onValueChange = { newValue ->
                                    if (newValue.length <= maxOtpLength && newValue.all { it.isDigit() }) {
                                        otpValue = otpValue.take(i) + newValue + otpValue.drop(i + 1)
                                    }
                                },
                                modifier = Modifier.size(56.dp)
                            )
                        }
                    }
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = { navController.navigate(Screen.ResetKataSandi.route) },
                        colors = ButtonDefaults.buttonColors(containerColor = primaryLight),
                        contentPadding = PaddingValues(
                            horizontal = 16.dp,
                            vertical = 16.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Konfirmasi OTP",
                            color = onPrimaryLight,
                            textAlign = TextAlign.Center,
                            lineHeight = 1.43.em,
                            style = AppTypography.labelLarge,
                            modifier = Modifier
                                .wrapContentHeight(align = Alignment.CenterVertically))
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Belum mendapatkan kode?",
                            color = onBackgroundLight,
                            textAlign = TextAlign.Center,
                            lineHeight = 1.43.em,
                            style = AppTypography.bodyMedium,
                            modifier = Modifier
                                .wrapContentHeight(align = Alignment.CenterVertically))
                        TextButton(
                            onClick = { Toast.makeText(context, "Kode OTP telah dikirimkan ke Email Anda", Toast.LENGTH_LONG).show() },
                            contentPadding = PaddingValues(
                                horizontal = 16.dp,
                                vertical = 16.dp),
                        ) {
                            Text(
                                text = "Kirim OTP",
                                color = primaryLight,
                                textAlign = TextAlign.Center,
                                lineHeight = 1.43.em,
                                style = AppTypography.labelLarge,
                                modifier = Modifier
                                    .wrapContentHeight(align = Alignment.CenterVertically)
                            )
                        }
                    }
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

@Composable
fun OTPTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .background(Color.White, shape = MaterialTheme.shapes.small)
            .padding(4.dp),
        textStyle = LocalTextStyle.current.copy(fontSize = 24.sp, textAlign = TextAlign.Center),
        singleLine = true,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        visualTransformation = VisualTransformation.None
    )
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun CekEmailPreview() {
    val navController = rememberNavController()
    LaundryAppTheme {
        CekEmail(navController)
    }
}
