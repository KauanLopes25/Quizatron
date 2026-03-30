package com.example.quizatron.screens.quiz

import android.util.Log
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quizatron.R
import com.example.quizatron.components.checkBox
import com.example.quizatron.screens.result.ResultScreen

@Composable
fun QuizScreen(navController: NavController){
    var pergunta by remember {
        mutableStateOf(1)
    }
    var acertos by remember  {
        mutableStateOf(0)
    }



    Column(
        modifier = Modifier.fillMaxSize()
            .background(colorResource(R.color.pink_question))
            .padding(20.dp),
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
        Row(
            modifier = Modifier.width(300.dp)
                .height(60.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(colorResource(R.color.green_question))
                .border(1.dp, Color.Black, RoundedCornerShape(20.dp)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Pergunta $pergunta de 2",
                fontSize = 27.sp,
                color = Color.Black
            )
        }
//        1 Pergunta...................................................................
        if (pergunta == 1){
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .padding(
                            top = 30.dp,
                            bottom = 40.dp,
                            start = 20.dp,
                            end = 20.dp
                        ),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Qual a capital da França?",
                            fontSize = 25.sp
                        )
                    }
                    checkBox(
                        Modifier, "Londres",
                        false

                    ) {
                        retorno ->
                        if (retorno == false) {
                            pergunta = 2
                            acertos + 0
                        }
                    }
                    checkBox(
                        Modifier, "Berlim",
                        false
                    ) {
                        retorno ->
                        if (retorno == false) {
                            pergunta = 2
                            acertos + 0
                        }
                    }
                    checkBox(
                        Modifier, "Paris",
                        true
                    ) {
                        retorno ->
                        if (retorno == true) {
                            pergunta = 2
                            acertos + 1
                        }
                    }
                    checkBox(
                        Modifier, "Madri",
                        false
                    ) {
                        retorno ->
                        if (retorno == false) {
                            pergunta = 2
                            acertos + 0
                        }
                    }
                }
            }
        }
        //2 Pergunta...............................................................
        else if(pergunta == 2){
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .padding(
                            top = 30.dp,
                            bottom = 40.dp,
                            start = 20.dp,
                            end = 20.dp
                        ),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Qual planeta é conhecido como platena vermelho?",
                            fontSize = 25.sp
                        )
                    }
                    checkBox(
                        Modifier, "Vênus",
                        false
                    ) {
                        retorno ->
                        if (retorno == false) {
                            pergunta = 3
                            acertos + 0
                        }
                    }
                    checkBox(
                        Modifier, "Marte",
                        true
                    ) {
                        retorno ->
                        if (retorno == true) {
                            pergunta = 3
                            acertos + 1
                        }
                    }
                    checkBox(
                        Modifier, "Júpiter",
                        false
                    ) {
                        retorno ->
                        if (retorno == false) {
                            pergunta = 3
                            acertos + 0
                        }
                    }
                    checkBox(
                        Modifier, "Saturno",
                        false
                    ){
                        retorno ->
                        if (retorno == false) {
                            pergunta = 3
                            acertos + 0
                        }
                    }
                }
            }

        } else {
            navController.navigate("result")
        }
    }
}