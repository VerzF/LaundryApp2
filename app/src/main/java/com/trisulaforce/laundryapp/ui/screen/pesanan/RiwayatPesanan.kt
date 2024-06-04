package com.trisulaforce.laundryapp.ui.screen.pesanan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.trisulaforce.laundryapp.R
import com.trisulaforce.laundryapp.component.RiwayatPesananItem
import com.trisulaforce.laundryapp.model.DataPesanan.orders
import com.trisulaforce.laundryapp.model.Pesanan
import com.trisulaforce.laundryapp.ui.theme.AppTypography
import com.trisulaforce.laundryapp.ui.theme.LaundryAppTheme
import com.trisulaforce.laundryapp.ui.theme.backgroundLight
import com.trisulaforce.laundryapp.ui.theme.onBackgroundLight

@Composable
fun RiwayatPesanan(navController: NavController, modifier: Modifier = Modifier, orders: List<Pesanan>) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(24.dp))
            .background(backgroundLight)
            .padding(vertical = 24.dp, horizontal = 24.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                IconButton(
                    onClick = {  }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_leftarrow),
                        contentDescription = "Icons",
                        tint = onBackgroundLight
                    )
                }
                Text(
                    text = "Riwayat Pesanan",
                    color = onBackgroundLight,
                    textAlign = TextAlign.Center,
                    lineHeight = 1.27.em,
                    style = AppTypography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .wrapContentHeight(align = Alignment.CenterVertically))
                IconButton(onClick = {  }) { }
            }
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(orders) { order ->
                    RiwayatPesananItem(order = order)
                }
            }
        }
    }
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun RiwayatPesananPreview() {
    val navController = rememberNavController()
    LaundryAppTheme {
        RiwayatPesanan(navController = navController, modifier = Modifier, orders = orders)
    }
}
