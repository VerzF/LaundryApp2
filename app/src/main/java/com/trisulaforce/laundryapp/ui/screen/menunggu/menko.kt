package com.trisulaforce.laundryapp.menunggu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.trisulaforce.laundryapp.R

@Composable
fun Menunggu(modifier: Modifier = Modifier) {
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
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 143.dp)
                .requiredWidth(166.dp)
                .wrapContentHeight(align = Alignment.CenterVertically)
        )
        Text(
            text = "Sabar ya, masih nunggu admin buat konfirmasi pesananmu",
            color = Color.Black,
            textAlign = TextAlign.Center,
            lineHeight = 1.43.em,
            style = TextStyle(fontSize = 14.sp),
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 490.dp)
                .requiredWidth(259.dp)
                .wrapContentHeight(align = Alignment.CenterVertically)
        )
        Image(
            painter = painterResource(id = R.drawable.menunggu),
            contentDescription = "Pekanbaru Laundry",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 53.dp, y = 178.dp)
                .requiredWidth(253.dp)
                .requiredHeight(297.dp)
        )
        TypeLightMode(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(y = (-1).dp)
        )
        Button(
            onClick = { /* TODO: Handle button click */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xff465d91)),
            shape = RoundedCornerShape(100.dp),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = (-40).dp)
                .requiredWidth(270.dp)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Kembali ke Beranda",
                color = Color.White.copy(alpha = 0.87f),
                textAlign = TextAlign.Center,
                style = TextStyle(fontSize = 15.sp)
            )
        }
    }
}

@Composable
fun TypeLightMode(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .requiredWidth(360.dp)
            .padding(start = 16.dp, end = 16.dp, top = 6.dp, bottom = 4.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Placeholder for content
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
private fun MenungguPreview() {
    Menunggu()
}
