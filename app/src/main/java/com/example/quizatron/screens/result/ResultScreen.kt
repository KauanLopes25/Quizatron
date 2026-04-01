package com.example.quizatron.screens.result

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quizatron.R

@Composable
fun ResultScreen(navController: NavController, resultado: Int) {
    var resultado = resultado



    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
            .padding(
                top = 20.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(R.drawable.quiz),
                contentDescription = "Icone de Play",
                modifier = Modifier.size(80.dp)
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth()
                .height(200.dp)
                .background(colorResource(R.color.blue_baby)),
            verticalArrangement = Arrangement.spacedBy(
                40.dp,
               alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.width(300.dp)
                    .height(50.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(colorResource(R.color.green_question))
                    .border(1.dp, Color.Black, RoundedCornerShape(15.dp)),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Bom trabalho!",
                    fontSize = 24.sp,
                    color = Color.Black
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Você acertou a $resultado de 2 perguntas",
                    fontSize = 24.sp,
                    color = Color.Black
                )
            }
        }
        OutlinedButton(
            onClick = {
                navController.navigate(route = "start")
            },
            border = null,
            modifier = Modifier.width(300.dp)
                .height(50.dp)
                .clip(RoundedCornerShape(25.dp))
                .background(colorResource(R.color.yellow_question))
                .border(width = 1.dp, Color.Black, shape = RoundedCornerShape(25 .dp))
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "JOGAR NOVAMENTE",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.W400,
                    color = Color.Black
                )
            }

        }

    }
}