package com.trisulaforce.laundryapp.ui.screen.pesanan

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
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
import com.trisulaforce.laundryapp.model.DataUser.users
import com.trisulaforce.laundryapp.model.Layanan
import com.trisulaforce.laundryapp.ui.theme.AppTypography
import com.trisulaforce.laundryapp.ui.theme.LaundryAppTheme
import com.trisulaforce.laundryapp.ui.theme.backgroundLight
import com.trisulaforce.laundryapp.ui.theme.onBackgroundLight
import com.trisulaforce.laundryapp.ui.theme.onPrimaryLight
import com.trisulaforce.laundryapp.ui.theme.primaryLight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KonfirmasiPesanan(
    navController: NavController,
    services: List<Layanan>
) {
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(24.dp))
            .background(backgroundLight)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
            modifier = Modifier
                .padding(24.dp)
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
                    text = "Konfirmasi Pesanan",
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
            Column(
                verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
                modifier = Modifier
//                   .verticalScroll(rememberScrollState())
                    .fillMaxSize()
            ) {
                Text(
                    text = "Lokasi Penjemputan",
                    style = AppTypography.titleMedium
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.alamat),
                        contentDescription = "Address Icon",
                        modifier = Modifier.size(36.dp)
                    )
                    Text(
                        text = users.address,
                        style = AppTypography.bodyMedium
                    )
                }
                Divider()
                Text(
                    text = "Detail Pesanan",
                    style = AppTypography.titleMedium
                )
                Column (
                    verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        items(services) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = it.image),
                                    contentDescription = "Service Image",
                                    modifier = Modifier.size(64.dp)
                                )
                                Column(
                                    verticalArrangement = Arrangement.spacedBy(4.dp),
                                ) {
                                    Text(text = it.title, style = AppTypography.bodyMedium)
                                    Text(text = "2 Hari", style = AppTypography.labelSmall, color = Color.Gray)
                                }
                            }
                        }
                    }
                }
                Text(
                    text = "Pilih Parfum",
                    style = AppTypography.titleMedium
                )
                val radioOptions = listOf("Serena", "Violet")
                val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }
                Row(Modifier.selectableGroup()) {
                    radioOptions.forEach { text ->
                        Row(
                            modifier = Modifier
                                .selectable(
                                    selected = (text == selectedOption),
                                    onClick = { onOptionSelected(text) },
                                    role = Role.RadioButton
                                )
                                .padding(horizontal = 12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = (text == selectedOption),
                                onClick = null
                            )
                            Text(
                                text = text,
                                style = AppTypography.bodyMedium,
                                modifier = Modifier.padding(start = 12.dp)
                            )
                        }
                    }
                }
                Divider()
                Text(
                    text = "Informasi Tambahan",
                    style = AppTypography.titleMedium
                )
                var expanded by remember { mutableStateOf(false) }
                var selectedText by remember { mutableStateOf("Pilih Jam Pengantaran") }
                Box(
                    modifier = Modifier
                        .wrapContentSize(Alignment.TopStart)
                ) {
                    OutlinedCard(
                        colors = CardDefaults.cardColors(
                            containerColor = backgroundLight
                        ),
                        border = BorderStroke(1.dp, onBackgroundLight),
                        onClick = { expanded = true }
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp)
                        ) {
                            Text(text = selectedText, style = AppTypography.bodyMedium)
                            Icon(painterResource(id = R.drawable.ic_chevrondown), contentDescription = "Localized description")
                        }
                    }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text(text = "Bebas", style = AppTypography.bodyMedium) },
                            onClick = {
                                selectedText = "Bebas"
                                expanded = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text(text = "08.00 - 10.00", style = AppTypography.bodyMedium) },
                            onClick = {
                                selectedText = "08.00 - 10.00"
                                expanded = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text(text = "12.00 - 15.00", style = AppTypography.bodyMedium) },
                            onClick = {
                                selectedText = "12.00 - 15.00"
                                expanded = false
                            }
                        )
                    }
                }
                Text(
                    text = "Catatan Tambahan",
                    style = AppTypography.titleMedium
                )
                var text by rememberSaveable { mutableStateOf("") }
                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    label = {
                        Text(
                            text = "Catatan tambahan untuk lokasi penjemputan, jadwal penjemputan, keterangan pakaian, dan lain-lain",
                            style = AppTypography.bodyMedium,
                            color = Color.Gray
                        ) },
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Divider()
                Text(
                    text = "Persetujuan",
                    style = AppTypography.titleMedium
                )
                var isChecked by remember { mutableStateOf(false) }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Checkbox(
                        checked = isChecked,
                        onCheckedChange = { isChecked = it }
                    )
                    Text(
                        text = "Dengan menekan tombol ini, kamu setuju dengan ketentuan bahwa semua perhitungan berat, ongkir, dan total tagihan merupakan kebijak dari Outlet.",
                        style = AppTypography.bodyMedium,
                        modifier = Modifier.clickable { isChecked = !isChecked }
                    )
                }
                Button(
                    onClick = {  },
                    colors = ButtonDefaults.buttonColors(containerColor = primaryLight),
                    contentPadding = PaddingValues(
                        horizontal = 16.dp,
                        vertical = 16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Pesan Sekarang",
                        color = onPrimaryLight,
                        textAlign = TextAlign.Center,
                        lineHeight = 1.43.em,
                        style = AppTypography.labelLarge,
                        modifier = Modifier
                            .wrapContentHeight(align = Alignment.CenterVertically))
                }
            }
        }
    }
}

@Preview
@Composable
private fun KonfirmasiPesananPreview() {
    val navController = rememberNavController()
    val services = listOf(
        Layanan(id = 1, image = R.drawable.laundry1, title = "Nyuci Kering (Min. 2kg)", price = 4000),
        Layanan(id = 2, image = R.drawable.laundry1, title = "Cuci Selimut", price = 12000)
    )
    LaundryAppTheme {
        KonfirmasiPesanan(navController = navController, services = services)
    }
}