package com.trisulaforce.laundryapp.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.trisulaforce.laundryapp.model.Layanan
import com.trisulaforce.laundryapp.model.Pesanan
import com.trisulaforce.laundryapp.ui.theme.AppTypography
import com.trisulaforce.laundryapp.ui.theme.onPrimaryContainerLight
import com.trisulaforce.laundryapp.ui.theme.onPrimaryLight
import com.trisulaforce.laundryapp.ui.theme.primaryContainerLight
import com.trisulaforce.laundryapp.ui.theme.primaryLight

@Composable
fun ServiceItem(service: Layanan) {
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = service.title,
            color = onPrimaryContainerLight,
            style = AppTypography.labelLarge
        )
        Text(
            text = "Rp${service.price}",
            color = onPrimaryContainerLight,
            style = AppTypography.labelLarge
        )
    }
}

@Composable
fun RiwayatPesananItem(order: Pesanan) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 12.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = primaryContainerLight
        ),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .padding(vertical = 12.dp, horizontal = 0.dp)
            .fillMaxWidth()
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(primaryLight)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                ) {
                    Text(
                        text = order.date,
                        color = onPrimaryLight,
                        fontWeight = FontWeight.Bold,
                        style = AppTypography.titleMedium
                    )
                    Text(
                        text = order.status,
                        color = onPrimaryLight,
                        fontWeight = FontWeight.Bold,
                        style = AppTypography.titleMedium
                    )
                }
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Pesanan " + order.idPesanan,
                    style = AppTypography.bodyMedium,
                )
                Text(
                    text = order.customerName,
                    fontWeight = FontWeight.Bold,
                    style = AppTypography.titleLarge
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
                ) {
                    Text(
                        text = "Layanan",
                        fontWeight = FontWeight.Bold,
                        style = AppTypography.titleMedium,
                        color = onPrimaryContainerLight
                    )
                    OutlinedCard (
                        colors = CardDefaults.cardColors(
                            containerColor = primaryContainerLight
                        ),
                        border = BorderStroke(1.dp, onPrimaryContainerLight),
                    ) {
                        Column (
                            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
                            modifier = Modifier
                                .padding(12.dp)
                        ) {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                            ) {
                                order.services.forEach { service ->
                                    ServiceItem(service = service)
                                }
                            }
                            Text(
                                text = order.duration,
                                style = AppTypography.labelSmall,
                                color = Color.Gray
                            )
                        }
                    }
                }
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Total",
                        fontWeight = FontWeight.Bold,
                        style = AppTypography.titleMedium
                    )
                    Text(
                        text = "Rp${order.totalPrice}",
                        fontWeight = FontWeight.Bold,
                        style = AppTypography.titleMedium
                    )
                }
                Column (
                    verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row (
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Pilih Parfum",
                            style = AppTypography.bodyMedium
                        )
                        Text(
                            text = order.perfume,
                            style = AppTypography.bodyMedium
                        )
                    }
                    Row (
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Metode Pembayaran",
                            style = AppTypography.bodyMedium
                        )
                        Text(
                            text = order.paymentMethod,
                            style = AppTypography.bodyMedium
                        )
                    }
                    Row (
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Notes",
                            style = AppTypography.bodyMedium
                        )
                        Text(
                            text = order.notes,
                            style = AppTypography.bodyMedium
                        )
                    }
                }
            }
        }
    }
}


