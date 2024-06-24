package com.trisulaforce.laundryapp.ui.screen.notifikasi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.trisulaforce.laundryapp.R
import com.trisulaforce.laundryapp.component.NotifikasiItem
import com.trisulaforce.laundryapp.model.DataNotifikasi
import com.trisulaforce.laundryapp.model.DataNotifikasi.notifikasi
import com.trisulaforce.laundryapp.model.Notifikasi
import com.trisulaforce.laundryapp.ui.navigation.Screen

@Composable
fun Notification(
    navController: NavController,
    notifications : List<Notifikasi>
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(24.dp))
            .background(Color.White)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 24.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                IconButton(
                    onClick = { navController.navigate(Screen.Home.route) }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_leftarrow),
                        contentDescription = "Icons",
                        tint = Color(0xff465d91)
                    )
                }
                Text(
                    text = "Notifikasi",
                    color = Color(0xff465d91),
                    textAlign = TextAlign.Center,
                    lineHeight = 1.27.em,
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .wrapContentHeight(align = Alignment.CenterVertically)
                )
                IconButton(onClick = { }) { }
            }
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(notifications) { notifikasi ->
                    NotifikasiItem(notifikasi = notifikasi)
                }
            }
        }
    }
}
@Preview
@Composable
fun NotificationPreview() {
    val navController = rememberNavController()
    Notification(navController, notifikasi)
}