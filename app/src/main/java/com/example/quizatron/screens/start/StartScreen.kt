package com.example.quizatron.screens.start


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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quizatron.R

@Composable
fun StartScreen(navController: NavController){
    var nome by remember{
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize()
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
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = nome,
                onValueChange = { nome = it },
                singleLine = true,
                shape = RoundedCornerShape(20.dp),
                label = {
                    Text(text = "nome")
                },
                placeholder = {
                    Text(text = "Digite sem nome...")
                },
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color(0, 0, 0, 255),
                    unfocusedTextColor = Color(230, 0, 255, 255),
                    unfocusedPlaceholderColor = Color(0, 0, 0)
                )
            )
        }
        if (nome == ""){
            OutlinedButton(
                onClick = { },
                modifier = Modifier
                    .width(220.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(30.dp),
                border = BorderStroke(1.dp, Color.Black),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color(129, 121, 121, 255),
                    contentColor = Color.Black
                )
            ) {
                Text(
                    text = "COMEÇAR!",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W400,
                    color = Color.Black
                )
            }
        } else {
            OutlinedButton(
                onClick = {
                    navController.navigate("quiz/$nome")
                },
                modifier = Modifier
                    .width(220.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(30.dp),
                border = BorderStroke(1.dp, Color.Black),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = colorResource(R.color.yellow_question),
                    contentColor = Color.Black
                )
            ) {
                Text(
                    text = "COMEÇAR!",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W400,
                    color = Color.Black
                )
            }
        }
    }
}