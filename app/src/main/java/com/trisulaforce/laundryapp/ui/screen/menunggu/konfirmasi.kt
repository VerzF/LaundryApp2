package com.trisulaforce.laundryapp.ui.screen.menunggu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.trisulaforce.laundryapp.ui.navigation.Screen

@Composable
fun Konfirmasi(navController: NavController, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(360.dp)
            .requiredHeight(800.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(
                Brush.linearGradient(
                    colors = listOf(Color(0xffd9e2ff), Color.White),
                    start = androidx.compose.ui.geometry.Offset(180f, 0f),
                    end = androidx.compose.ui.geometry.Offset(180f, 800f)
                )
            )
    ) {
        Spacer(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 199.dp, y = 109.dp)
                .requiredWidth(48.dp)
                .requiredHeight(68.dp)
        )
        Text(
            text = "Menunggu Konfirmasi",
            color = Color.Black,
            lineHeight = 1.43.em,
            style = TextStyle(fontSize = 14.sp),
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 143.dp)
                .requiredWidth(166.dp)
                .wrapContentHeight(align = Alignment.CenterVertically)
        )
        Text(
            text = "Yeay!! pesananmu terkonfirmasi silahkan kembali ke beranda",
            color = Color.Black,
            textAlign = TextAlign.Center,
            lineHeight = 1.43.em,
            fontWeight = FontWeight.SemiBold,

            style = TextStyle(fontSize = 14.sp),
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 490.dp)
                .requiredWidth(259.dp)
                .wrapContentHeight(align = Alignment.CenterVertically)
        )
        Image(
            painter = painterResource(id = R.drawable.konfirmasi),
            contentDescription = "Pekanbaru Laundry",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 53.dp, y = 178.dp)
                .requiredWidth(253.dp)
                .requiredHeight(297.dp)
        )

        Button(
            onClick = { navController.navigate(Screen.Home.route) },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xff465d91)),
            shape = RoundedCornerShape(100.dp),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 45.dp, y = 684.dp)
                .requiredWidth(270.dp)
                .padding(horizontal = 16.dp, vertical = 9.dp)
        ) {
            Text(
                text = "Kembali ke Beranda",
                color = Color.White.copy(alpha = 0.87f),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,

                style = TextStyle(fontSize = 15.sp)
            )
        }
    }
}



@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
private fun KonfirmasiPreview() {
    val navController = rememberNavController()
    Konfirmasi(navController = navController)
}