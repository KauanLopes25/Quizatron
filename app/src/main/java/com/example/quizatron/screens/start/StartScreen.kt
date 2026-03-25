package com.example.quizatron.screens.start


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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizatron.R

@Composable
fun StartScreen(modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxSize()
            .background(colorResource(R.color.blue_baby))
            .padding(
                top = 100.dp,
                bottom = 0.dp,
                start = 0.dp,
                end = 0.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(
                    bottom = 50.dp
                ),
            horizontalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(R.drawable.quiz),
                contentDescription = "Icone de Play",
                modifier = Modifier.size(120.dp)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "QUIZATRON 3000",
                fontSize = 30.sp,
                color = Color.Black
            )
        }
        Row(
            modifier = Modifier.width(220.dp)
                .height(50.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(colorResource(R.color.yellow_question))
                .border(1.dp, Color.Black, RoundedCornerShape(30.dp)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "COMEÇAR!",
                fontSize = 20.sp,
                color = Color.Black
            )
        }
    }
}