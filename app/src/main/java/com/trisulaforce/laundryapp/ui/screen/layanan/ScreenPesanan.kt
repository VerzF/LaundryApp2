package com.trisulaforce.laundryapp.ui.screen.layanan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
import com.trisulaforce.laundryapp.component.LayananItem
import com.trisulaforce.laundryapp.model.DataProvider

@Composable
fun ScreenPesanan() {
    val screenPesanan = remember { DataProvider.layanan }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 24.dp)
        ){
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .requiredWidth(width = 312.dp)
            ) {
                IconButton(
                    onClick = {  }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                        contentDescription = "Icons",
                        tint = Color.Black
                    )
                }
                Text(
                    text = "Detail Pesanan",
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    lineHeight = 1.27.em,
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .wrapContentHeight(align = Alignment.CenterVertically))
                IconButton(onClick = {  }) { }
            }
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                items(screenPesanan) { layanan ->
                    LayananItem(layanan = layanan)
                }
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .requiredWidth(width = 360.dp)
                    .background(color = Color(0xfffaf9ff))
                    .padding(all = 24.dp)
            ) {
                VariantDefaultActionDefaultIconNoTypePrimary()
            }
        }
    }
}

// Line 87 + fun VariantDefaultActionIconNoTypePrimary buat button Konfirmasi //
@Composable
fun VariantDefaultActionDefaultIconNoTypePrimary(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(100.dp))
            .background(color = Color(0xff465d91))
            .padding(all = 16.dp)
    ) {
        Text(
            text = "Konfirmasi",
            color = Color.White,
            textAlign = TextAlign.Center,
            lineHeight = 1.43.em,
            style = TextStyle(
                fontSize = 14.sp,
                letterSpacing = 0.25.sp),
            modifier = Modifier
                .wrapContentHeight(align = Alignment.CenterVertically))
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPesananPreview(){
    ScreenPesanan()
}