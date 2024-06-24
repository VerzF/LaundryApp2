package com.trisulaforce.laundryapp.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.trisulaforce.laundryapp.R
import com.trisulaforce.laundryapp.model.Layanan
import com.trisulaforce.laundryapp.ui.theme.AppTypography
import com.trisulaforce.laundryapp.ui.theme.onBackgroundLight
import com.trisulaforce.laundryapp.ui.theme.primaryLight
import com.trisulaforce.laundryapp.ui.theme.surfaceContainerLight

@Composable
fun LayananItem(
    layanan: Layanan,
    isSelected: Boolean,
    onSelect: (Layanan) -> Unit
) {
    val borderColor = if (isSelected) Color(0xFF83AAFF) else Color.Transparent
    val icon = if (isSelected) R.drawable.ic_check_circle else R.drawable.ic_add_circle
    val iconTint = if (isSelected) Color(0xFF83AAFF) else primaryLight

    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 12.dp
        ),
        border = BorderStroke(4.dp, borderColor),
        colors = CardDefaults.cardColors(
            containerColor = surfaceContainerLight
        ),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .clickable { onSelect(layanan) }
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
                LayananImage(items = layanan)
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier.requiredWidth(100.dp)
                ) {
                    Text(
                        text = layanan.title,
                        color = onBackgroundLight,
                        fontWeight = FontWeight.Bold,
                        style = AppTypography.labelLarge
                    )
                    Text(
                        text = "Rp${layanan.price}",
                        color = onBackgroundLight,
                        fontWeight = FontWeight.Bold,
                        style = AppTypography.labelSmall
                    )

                    Text(text = "2 hari",
                        color = onBackgroundLight,
                        fontWeight = FontWeight.Bold,
                        style = AppTypography.labelSmall
                    )
                }
            }
            Row(
                modifier = Modifier.padding(8.dp)
            ) {
                IconButton(
                    onClick = { onSelect(layanan) },
                ) {
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = "Select",
                        tint = iconTint,
                        modifier = Modifier.size(48.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun LayananImage(items: Layanan) {
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