package com.trisulaforce.laundryapp.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.trisulaforce.laundryapp.model.Notifikasi
import com.trisulaforce.laundryapp.ui.theme.AppTypography
import com.trisulaforce.laundryapp.ui.theme.onBackgroundLight
import com.trisulaforce.laundryapp.ui.theme.surfaceContainerLight

@Composable
fun NotifikasiItem (
    notifikasi: Notifikasi
){
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 12.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = surfaceContainerLight
        ),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp, 16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                NotifikasiImage(items = notifikasi)
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier.requiredWidth(100.dp)
                ) {
                    Text(
                        text = notifikasi.title,
                        color = onBackgroundLight,
                        fontWeight = FontWeight.Bold,
                        style = AppTypography.labelLarge
                    )
                    Text(
                        text = notifikasi.text,
                        color = onBackgroundLight,
                        fontWeight = FontWeight.Bold,
                        style = AppTypography.labelSmall
                    )

                    Text(text = notifikasi.tanggal,
                        color = onBackgroundLight,
                        fontWeight = FontWeight.Bold,
                        style = AppTypography.labelSmall
                    )
                }
            }
        }
    }
}

@Composable
private fun NotifikasiImage(items:Notifikasi){
    Image(
        painter = painterResource(id = items.image),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(64.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}