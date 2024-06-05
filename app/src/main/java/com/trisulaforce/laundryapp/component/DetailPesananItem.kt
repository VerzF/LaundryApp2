package com.trisulaforce.laundryapp.component

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedIconButton
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
import androidx.compose.ui.unit.sp
import com.trisulaforce.laundryapp.R
import com.trisulaforce.laundryapp.model.Layanan
import com.trisulaforce.laundryapp.ui.theme.surfaceContainerLight

@Composable
fun DetailPesananItem(service: Layanan, onDelete: () -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 12.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = surfaceContainerLight
        ),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
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
                LayananImage(items = service)
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier.requiredWidth(100.dp)
                ) {
                    Text(text = service.title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(text = "Rp${service.price}", fontSize = 14.sp)
                    Text(text = "2 Hari", fontSize = 12.sp, color = Color.Gray)
                }
            }
            Row(
                modifier = Modifier.padding(8.dp)
            ) {
                OutlinedIconButton(
                    onClick = onDelete,
                    border = BorderStroke(2.dp, Color.Red),
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_delete),
                        contentDescription = "Delete",
                        tint = Color.Red
                    )
                }
            }
        }
    }
}

@Composable
private fun LayananImage(items: Layanan){
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