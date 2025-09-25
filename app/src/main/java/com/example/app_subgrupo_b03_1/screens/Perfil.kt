package com.example.app_subgrupo_b03_1.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_subgrupo_b03_1.R


@Preview
@Composable

fun Perfil ()  {
    val scrollState = rememberScrollState()
    Box(modifier = Modifierg
        .fillMaxSize()
        .padding(horizontal = 16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column (
            modifier = Modifier
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.imagenperfil2),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 80.dp)
                    .size(300.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(50.dp) )
            Text(
                text = "ANDREA \nLOPEZ ",
                fontSize = 55.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Serif
            )
            Row(
                modifier = Modifier.fillMaxWidth().padding(top=50.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text="PROFESION",
                    modifier = Modifier.width(180.dp),
                    fontSize = 23.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold
                )
                Text(text="Diseñadora Grafica",
                    fontSize = 18.sp)
            }
            HorizontalDivider(
                modifier = Modifier.padding(vertical =30.dp),
                color = Color.LightGray,
                thickness = 2.dp)

            Row(
                modifier = Modifier.fillMaxWidth().padding(top =5.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text="UNIVERSIDAD",
                    modifier = Modifier.width(180.dp),
                    fontSize = 23.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold
                )
                Text(text="Politecnico Gran \n" +
                        "Colombiano - Año 2010",
                    fontSize = 18.sp)
            }
            HorizontalDivider(
                modifier = Modifier.padding(vertical =30.dp),
                color = Color.LightGray,
                thickness = 2.dp)

            Row(
                modifier = Modifier.fillMaxWidth().padding(top=30.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text="EXPERIENCIA",
                    modifier = Modifier.width(180.dp),
                    fontSize = 23.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold
                )
                Text(text="Mas de 10 años en diseños de logos para marcas independientes",
                    fontSize = 18.sp)
            }
            HorizontalDivider(
                modifier = Modifier.padding(vertical =30.dp),
                color = Color.LightGray,
                thickness = 2.dp)

            Row(
                modifier = Modifier.fillMaxWidth().padding(top=30.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text="PROGRAMAS \nMANEJADOS",
                    modifier = Modifier.width(180.dp),
                    fontSize = 23.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold
                )
                Text(text="PicMonkey\n" +
                        "Canva\n" +
                        "Open Art",
                    fontSize = 18.sp)
            }
            HorizontalDivider(
                modifier = Modifier.padding(vertical =30.dp),
                color = Color.LightGray,
                thickness = 2.dp)
        }
    }
}