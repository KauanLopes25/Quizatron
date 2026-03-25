package com.example.quizatron.components

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun checkBox(
    modifier: Modifier,
    alternativa: String,
) {
    OutlinedButton(
        onClick = {/* TUDO */},
        modifier = Modifier.fillMaxWidth()
            .height(50.dp),
        enabled = true,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = alternativa,
                fontSize = 20.sp,
                fontWeight = FontWeight.W400,
                color = Color.Black
            )
        }
    }
}