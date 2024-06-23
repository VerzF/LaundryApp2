package com.trisulaforce.laundryapp.ui.screen.layanan

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.trisulaforce.laundryapp.R
import com.trisulaforce.laundryapp.component.LayananItem
import com.trisulaforce.laundryapp.model.DataProvider
import com.trisulaforce.laundryapp.model.Layanan
import com.trisulaforce.laundryapp.ui.navigation.Screen
import com.trisulaforce.laundryapp.ui.theme.AppTypography
import com.trisulaforce.laundryapp.ui.theme.backgroundLight
import com.trisulaforce.laundryapp.ui.theme.onPrimaryLight
import com.trisulaforce.laundryapp.ui.theme.primaryLight

@Composable
fun ScreenLayanan(navController: NavController) {
    val screenLayanan = remember { DataProvider.layanan }
    val selectedItems = remember { mutableStateListOf<Layanan>() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = backgroundLight)
    ) {
        Column {
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp, 24.dp, 24.dp, 0.dp)
                    .weight(0.9f)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    IconButton(
                        onClick = { navController.navigateUp() }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                            contentDescription = "Icons",
                            tint = Color.Black
                        )
                    }
                    Text(
                        text = "Layanan",
                        color = Color.Black,
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
                var text by rememberSaveable { mutableStateOf("") }
                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text(text = "Mau pesan apa hari ini?") },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search_24),
                            contentDescription = "Email"
                        )
                    },
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                )
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    items(screenLayanan) { layanan ->
                        val isSelected = selectedItems.contains(layanan)
                        LayananItem(
                            layanan = layanan,
                            isSelected = isSelected,
                            onSelect = {
                                if (isSelected) {
                                    selectedItems.remove(layanan)
                                } else {
                                    selectedItems.add(layanan)
                                }
                            }
                        )
                    }
                }
            }
            AnimatedVisibility(
                visible = selectedItems.isNotEmpty(),
                enter = slideIn(tween(100, easing = LinearOutSlowInEasing)) {
                    IntOffset(0, 100)
                },
                exit = slideOut(tween(100, easing = FastOutSlowInEasing)) {
                    IntOffset(0, 50)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Divider(thickness = 2.dp, modifier = Modifier.fillMaxWidth())
                    Button(
                        onClick = {
                            navController.navigate(Screen.DetailPesanan.route + "?selectedItems=${selectedItems.joinToString { it.id.toString() }}")
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = primaryLight),
                        contentPadding = PaddingValues(
                            horizontal = 16.dp,
                            vertical = 16.dp
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp)
                    ) {
                        Text(
                            text = "Detail Pesanan",
                            color = onPrimaryLight,
                            textAlign = TextAlign.Center,
                            lineHeight = 1.43.em,
                            style = AppTypography.labelLarge,
                            modifier = Modifier.wrapContentHeight(align = Alignment.CenterVertically)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenLayananPreview() {
    val navController = rememberNavController()
    ScreenLayanan(navController)
}