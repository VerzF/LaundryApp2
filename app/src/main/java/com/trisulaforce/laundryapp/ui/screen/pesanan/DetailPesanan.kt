package com.trisulaforce.laundryapp.ui.screen.pesanan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
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
import com.trisulaforce.laundryapp.component.DetailPesananItem
import com.trisulaforce.laundryapp.model.Layanan
import com.trisulaforce.laundryapp.ui.theme.AppTypography
import com.trisulaforce.laundryapp.ui.theme.LaundryAppTheme
import com.trisulaforce.laundryapp.ui.theme.backgroundLight
import com.trisulaforce.laundryapp.ui.theme.onBackgroundLight
import com.trisulaforce.laundryapp.ui.theme.onPrimaryLight
import com.trisulaforce.laundryapp.ui.theme.primaryLight

@Composable
fun DetailPesananScreen(
    navController: NavController,
    services: List<Layanan>,
    onServiceDelete: (Layanan) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(24.dp))
            .background(backgroundLight)
            .padding(vertical = 24.dp, horizontal = 24.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize()
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
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_leftarrow),
                            contentDescription = "Back",
                            tint = onBackgroundLight
                        )
                    }
                    Text(
                        text = "Detail Pesanan",
                        color = onBackgroundLight,
                        textAlign = TextAlign.Center,
                        lineHeight = 1.27.em,
                        style = AppTypography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.wrapContentHeight(align = Alignment.CenterVertically)
                    )
                    IconButton(onClick = { }) { }
                }
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(services) { service ->
                        DetailPesananItem(
                            service = service,
                            onDelete = { onServiceDelete(service) }
                        )
                    }
                }
            }
            Button(
                onClick = { navController.navigate("ResetKataSandi") },
                colors = ButtonDefaults.buttonColors(containerColor = primaryLight),
                contentPadding = PaddingValues(
                    horizontal = 16.dp,
                    vertical = 16.dp
                ),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Konfirmasi Pesanan",
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
}

@Composable
fun DetailPesanan(
    navController: NavController,
    initialServices: List<Layanan>
) {
    val services = remember { mutableStateListOf(*initialServices.toTypedArray()) }

    fun handleDelete(service: Layanan) {
        services.remove(service)
    }

    DetailPesananScreen(
        navController = navController,
        services = services,
        onServiceDelete = ::handleDelete
    )
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun DetailPesananPreview() {
    val navController = rememberNavController()
    val services = listOf(
        Layanan(id = 1, image = R.drawable.laundry1, title = "Nyuci Kering (Min. 2kg)", price = 4000),
        Layanan(id = 2, image = R.drawable.laundry1, title = "Cuci Selimut", price = 12000)
    )
    LaundryAppTheme {
        DetailPesanan(navController = navController, initialServices = services)
    }
}
