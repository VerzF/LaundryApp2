package com.trisulaforce.laundryapp.ui.screen.beranda

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import com.trisulaforce.laundryapp.ui.navigation.Screen

@Composable
fun Beranda(navController: NavController, modifier: Modifier = Modifier) {
    val whatsapp = "https://wa.me/087898632468"
    val context = LocalContext.current
    val wintent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(whatsapp)) }
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .weight(weight = 1f)
                .padding(
                    top = 12.dp,
                    start = 24.dp,
                    end = 24.dp,
                    bottom = 12.dp
                )
        ) {
            item {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .rotate(degrees = 0.34f)
                        .padding(bottom = 30.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .rotate(degrees = 0.34f)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredWidth(width = 44.dp)
                                .requiredHeight(height = 40.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.fotoprofile),
                                contentDescription = "Foto Profile",
                                modifier = Modifier
                                    .align(alignment = Alignment.TopCenter)
                                    .offset(
                                        x = 0.dp,
                                        y = 0.dp
                                    )
                                    .requiredWidth(width = 44.dp)
                                    .requiredHeight(height = 40.dp))
                        }
                        Column(
                            modifier = Modifier
                                .requiredWidth(width = 180.dp)
                        ) {
                            Text(
                                text = "Selamat Datang, ",
                                color = Color.Black,
                                lineHeight = 1.45.em,
                                style = MaterialTheme.typography.labelSmall,
                                modifier = Modifier
                                    .requiredWidth(width = 105.dp))
                            Text(
                                text = "Iqbaal Ramadhan",
                                color = Color.Black,
                                lineHeight = 1.5.em,
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    letterSpacing = 0.15.sp),
                                modifier = Modifier
                                    .requiredWidth(width = 180.dp))
                        }
                    }
                    Image(
                        painter = painterResource(id = R.drawable.whatsapp),
                        contentDescription = "Frame",
                        modifier = Modifier
                            .clickable { context.startActivity(wintent) }
                            .requiredSize(size = 26.dp)
                            .rotate(degrees = 0.69f))
                }
            }
            item {
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 312.dp)
                        .requiredHeight(height = 166.dp)
                        .clip(shape = RoundedCornerShape(12.dp))
                ) {
                    LazyRow(
                        modifier = Modifier
                            .padding(
                                top = 30.dp,
                                bottom = 30.dp)
                    ) {
                        item {
                            Image(
                                painter = painterResource(id = R.drawable.frame53),
                                contentDescription = "Frame 53",
                                modifier = Modifier
                                    .requiredWidth(width = 312.dp)
                                    .requiredHeight(height = 166.dp))
                        }
                        item {
                            Image(
                                painter = painterResource(id = R.drawable.frame53),
                                contentDescription = "Frame 54",
                                modifier = Modifier
                                    .requiredWidth(width = 312.dp)
                                    .requiredHeight(height = 166.dp))
                        }
                        item {
                            Image(
                                painter = painterResource(id = R.drawable.frame53),
                                contentDescription = "Frame 55",
                                modifier = Modifier
                                    .requiredWidth(width = 312.dp)
                                    .requiredHeight(height = 166.dp))
                        }
                        item {
                            Image(
                                painter = painterResource(id = R.drawable.frame53),
                                contentDescription = "Frame 56",
                                modifier = Modifier
                                    .requiredWidth(width = 312.dp)
                                    .requiredHeight(height = 166.dp))
                        }
                        item {
                            Image(
                                painter = painterResource(id = R.drawable.frame53),
                                contentDescription = "Frame 57",
                                modifier = Modifier
                                    .requiredWidth(width = 312.dp)
                                    .requiredHeight(height = 166.dp))
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()

                ) {
                    Box(
                        modifier = Modifier
                            .requiredWidth(width = 24.dp)
                            .requiredHeight(height = 5.dp)
                            .clip(shape = RoundedCornerShape(100.dp))
                            .background(color = Color(0xff1a1c20)))

                    Spacer(modifier = Modifier.width(2.dp))

                    Box(
                        modifier = Modifier
                            .requiredSize(size = 5.dp)
                            .clip(shape = RoundedCornerShape(100.dp))
                            .background(color = Color(0xff3b3b3f)))

                    Spacer(modifier = Modifier.width(2.dp))

                    Box(
                        modifier = Modifier
                            .requiredSize(size = 5.dp)
                            .clip(shape = RoundedCornerShape(100.dp))
                            .background(color = Color(0xff3b3b3f)))

                    Spacer(modifier = Modifier.width(2.dp))

                    Box(
                        modifier = Modifier
                            .requiredSize(size = 5.dp)
                            .clip(shape = RoundedCornerShape(100.dp))
                            .background(color = Color(0xff3b3b3f)))

                    Spacer(modifier = Modifier.width(2.dp))

                    Box(
                        modifier = Modifier
                            .requiredSize(size = 5.dp)
                            .clip(shape = RoundedCornerShape(100.dp))
                            .background(color = Color(0xff3b3b3f)))
                }
            }
            item {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth()
                ) {
                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .requiredSize(size = 140.dp)
                            .clip(shape = RoundedCornerShape(12.dp))
                            .background(color = Color(0xffd9e2ff))
                            .padding(all = 12.dp)
                            .clickable{ navController.navigate(Screen.ScreenLayanan.route)}
                    ) { 
                        Image(
                            painter = painterResource(id = R.drawable.layananlaundry),
                            contentDescription = "Pekanbaru Laundry (9) 1",
                            modifier = Modifier
                                .requiredWidth(width = 118.dp)
                                .requiredHeight(height = 80.dp))
                        Text(
                            text = "Layanan",
                            color = Color(0xff261a00),
                            textAlign = TextAlign.Center,
                            lineHeight = 1.43.em,
                            style = TextStyle(
                                fontSize = 14.sp,
                                letterSpacing = 0.1.sp))
                    }
                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .requiredSize(size = 140.dp)
                            .clip(shape = RoundedCornerShape(12.dp))
                            .background(color = Color(0xffdbe2f9))
                            .padding(all = 12.dp)
                            .clickable{ navController.navigate(Screen.chatbotScreen.route)}
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.messagebot),
                            contentDescription = "Message Bot",
                            modifier = Modifier
                                .requiredWidth(width = 100.dp)
                                .requiredHeight(height = 80.dp))
                        Text(
                            text = "HomieAI",
                            color = Color(0xff261a00),
                            textAlign = TextAlign.Center,
                            lineHeight = 1.43.em,
                            style = TextStyle(
                                fontSize = 14.sp,
                                letterSpacing = 0.1.sp))
                    }
                }
            }
            item {
                Text(
                    text = "Kenali Aplikasi Kami",
                    color = Color.Black,
                    lineHeight = 1.5.em,
                    style = TextStyle(
                        fontSize = 16.sp,
                        letterSpacing = 0.15.sp),
                    modifier = Modifier
                        .padding(
                            top = 15.dp,
                            bottom = 15.dp
                        )
                        .requiredWidth(width = 173.dp)
                        .requiredHeight(height = 20.dp)
                        .wrapContentHeight(align = Alignment.CenterVertically))
            }
            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(12.dp))
                        .background(color = Color(0xff465d91))
                        .padding(all = 12.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(9.dp, Alignment.CenterVertically),
                        modifier = Modifier
                            .clickable{navController.navigate(Screen.Kenali.route)}
                    ) {
                        Text(
                            text = "Deskripsi Aplikasi",
                            color = Color.White,
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium),
                            modifier = Modifier
                                .requiredWidth(width = 211.dp)
                                .requiredHeight(height = 18.dp))
                        Text(
                            text = "Welcome to our homepage, a place where we inspire positive change through recycling waste to keep our earth green and sustainainable.\n14/03/2024\n\n",
                            color = Color.White,
                            style = TextStyle(
                                fontSize = 8.sp),
                            modifier = Modifier
                                .requiredWidth(width = 209.dp)
                                .requiredHeight(height = 46.dp))
                    }
                    Image(
                        painter = painterResource(id = R.drawable.rectangle1752),
                        contentDescription = "Rectangle 1752",
                        modifier = Modifier
                            .requiredSize(size = 64.dp)
                            .clip(shape = RoundedCornerShape(5.dp)))
                }
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(12.dp))
                        .background(color = Color(0xff465d91))
                        .padding(all = 12.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(9.dp, Alignment.CenterVertically),
                        modifier = Modifier
                            .clickable{navController.navigate(Screen.Penggunaan.route)}
                    ) {
                        Text(
                            text = "Cara Penggunaan",
                            color = Color.White,
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium),
                            modifier = Modifier
                                .requiredWidth(width = 211.dp)
                                .requiredHeight(height = 18.dp))
                        Text(
                            text = "Welcome to our homepage, a place where we inspire positive change through recycling waste to keep our earth green and sustainable.\n14/03/2024\n\n",
                            color = Color.White,
                            style = TextStyle(
                                fontSize = 8.sp),
                            modifier = Modifier
                                .requiredWidth(width = 209.dp)
                                .requiredHeight(height = 46.dp))
                    }
                    Image(
                        painter = painterResource(id = R.drawable.rectangle1752),
                        contentDescription = "Rectangle 1752",
                        modifier = Modifier
                            .requiredSize(size = 64.dp)
                            .clip(shape = RoundedCornerShape(5.dp)))
                }
            }
        }
    }
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun BerandaPreview() {
    val navController = rememberNavController()
    Beranda(navController, Modifier)
}